package battleship.InputLineParser;

import battleship.Position;

import java.text.ParseException;
import java.util.ArrayList;

public class BattleshipInputLineParser extends AbstractInputLineParser<Position[]> {
    private static final int EXPECTED_INPUT_LINE_LENGTH = 4;
    private static final int HORIZONTAL_POSITION_CHARACTER_INDEX = 0;
    private static final int VERTICAL_POSITION_CHARACTER_INDEX = 1;
    private static final int IS_HORIZONTAL_CHARACTER_INDEX = 2;
    private static final int LENGTH_CHARACTER_INDEX = 3;
    private static final String PARSING_ERROR_MESSAGE = "";
    private static final String PARSING_EXCEPTION_MESSAGE = "Error while parsing the battleship's %s";
    private static final char ZERO = '0';
    private static final char ONE = '1';
    private static final char TWO = '2';
    private static final char THREE = '3';
    private static final char FIVE = '5';

    public BattleshipInputLineParser(String rawLine) {
        super(rawLine);
    }

    @Override
    public Position[] parse() throws ParseException {
        var horizontalPosition = tryParseBattleshipHorizontalPosition();
        var verticalPosition = tryParseBattleshipVerticalPosition();

        var prow = new Position(horizontalPosition, verticalPosition);
        var isHorizontalOrientation = tryParseBattleshipIsHorizontalOrientation();
        var length = tryParseBattleshipLength();
        return translateToCartesian(prow, isHorizontalOrientation, length);
    }


    public void validateBattleshipInputLine() throws ParseException {
        if (!isValidBattleshipInputLine()) {
            throw new ParseException(PARSING_ERROR_MESSAGE, 0);
        }
    }

    /**
     * Example: 0105 -> X=0;Y=5;Orientation=Vertical;Length=5

     */
    public boolean isValidBattleshipInputLine() {
        return rawLine.length() == EXPECTED_INPUT_LINE_LENGTH
               && Character.isDigit(rawLine.charAt(HORIZONTAL_POSITION_CHARACTER_INDEX))
               && Character.isDigit(rawLine.charAt(VERTICAL_POSITION_CHARACTER_INDEX))
               && (rawLine.charAt(IS_HORIZONTAL_CHARACTER_INDEX) == ZERO
                   || rawLine.charAt(IS_HORIZONTAL_CHARACTER_INDEX) == ONE)
               && (rawLine.charAt(LENGTH_CHARACTER_INDEX) == TWO
                   || rawLine.charAt(LENGTH_CHARACTER_INDEX) == THREE
                   || rawLine.charAt(LENGTH_CHARACTER_INDEX) == FIVE);
    }

    public int tryParseBattleshipHorizontalPosition() throws ParseException {
        try {
            var idx = HORIZONTAL_POSITION_CHARACTER_INDEX;
            return Integer.parseInt(rawLine.substring(idx, idx + 1));
        } catch (NumberFormatException nfe) {
            var exceptionMessage = String.format(PARSING_EXCEPTION_MESSAGE, "horizontal position");
            throw new ParseException(exceptionMessage, HORIZONTAL_POSITION_CHARACTER_INDEX);
        }
    }

    public int tryParseBattleshipVerticalPosition() throws ParseException {
        try {
            var idx = VERTICAL_POSITION_CHARACTER_INDEX;
            return Integer.parseInt(rawLine.substring(idx, idx+1));
        } catch (NumberFormatException nfe) {
            var exceptionMessage = String.format(PARSING_EXCEPTION_MESSAGE, "vertical position");
            throw new ParseException(exceptionMessage, VERTICAL_POSITION_CHARACTER_INDEX);
        }
    }

    public boolean tryParseBattleshipIsHorizontalOrientation() throws ParseException {
        try {
            return rawLine.charAt(IS_HORIZONTAL_CHARACTER_INDEX) == ONE;
        } catch (NumberFormatException nfe) {
            var exceptionMessage = String.format(PARSING_EXCEPTION_MESSAGE, "orientation");
            throw new ParseException(exceptionMessage, IS_HORIZONTAL_CHARACTER_INDEX);
        }
    }

    public int tryParseBattleshipLength() throws ParseException {
        try {
            return Integer.parseInt(rawLine.substring(LENGTH_CHARACTER_INDEX, LENGTH_CHARACTER_INDEX + 1));
        } catch (NumberFormatException nfe) {
            var exceptionMessage = String.format(PARSING_EXCEPTION_MESSAGE, "length");
            throw new ParseException(exceptionMessage, LENGTH_CHARACTER_INDEX);
        }
    }

    //TODO: refactor this
    private static Position[] translateToCartesian(Position prow, boolean isHorizontalOrientation, int length) {
        var battleshipPositions = new Position[] {};
        var x = prow.GetHorizontalPosition();
        var y = prow.GetVerticalPosition();
        var positions = new ArrayList<Position>();

        Position pos;
        for (int k=0; k<length; k++) {
            pos = isHorizontalOrientation ? new Position(x+k, y)
                    : new Position(x, y+k);
            positions.add(pos);
        }
        return positions.toArray(battleshipPositions);
    }
}