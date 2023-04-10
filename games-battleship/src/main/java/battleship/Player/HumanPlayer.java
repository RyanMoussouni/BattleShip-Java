package battleship.Player;

import battleship.InputLineParser.BattleshipInputLineParser;
import battleship.InputLineParser.TargetInputLineParser;
import battleship.Position;

import java.text.ParseException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {
    private final Scanner scanner;
    private static final String SELECT_BATTLESHIP_MESSAGE = "Please select a %s ('XYOL')";
    private static final String INVALID_BATTLESHIP_SELECTED_MESSAGE = "The battleship positions you provided are invalid";
    private static final String INVALID_BATTLESHIP_INPUT_LINE_FORMAT_MESSAGE = "The format of your input is invalid."
                                                                                + "\nPlease try again";
    private static final String BATTLESHIP_OUT_OF_BOUNDS_MESSAGE = "The battleship you selected is out of bounds";
    private static final String BATTLESHIPS_OVERLAP_MESSAGE = "The battleship you selected overlaps with the first ones";
    private static final String SELECT_TARGET_MESSAGE = "Please select a target position";

    public HumanPlayer() {
        super();
        scanner = new Scanner(System.in);
    }


    @Override
    public void placeBattleships() {
        tryPlaceBattleship(AIRCRAFT_CARRIER_LENGTH);
        tryPlaceBattleship(CRUISER_LENGTH);
        tryPlaceBattleship(CRUISER_LENGTH);
        tryPlaceBattleship(SUBMARINE_LENGTH);
    }

    private void clearBattleships() {
        board.setGridWithWater();
    }

    //TODO: cette fonction fait deux choses; (CC)
    //TODO: changer terminologie select -> choose
    private void tryPlaceBattleship(int length) {
        try {
            var battleshipPositions = selectBattleshipPositions(length);
            validateBattleshipPositions(battleshipPositions);
            board.setBattleship(battleshipPositions);
        } catch (InputMismatchException ipse) {
            handleInvalidSelectedPosition(length, ipse);
        }
    }

    private Position[] selectBattleshipPositions(int length) {
        var userInputLine = fetchUserInputLine(length);
        return tryParseUserBattleshipInputLine(userInputLine);
    }

    private Position[] tryParseUserBattleshipInputLine(String line) {
        try {
            return parseUserBattleshipInputLine(line);
        } catch (ParseException e) {
            handleParsingException(e);
            throw new RuntimeException();
        }
    }

    private Position[] parseUserBattleshipInputLine(String line) throws ParseException {
        var parser = new BattleshipInputLineParser(line);
        parser.validateBattleshipInputLine();
        return parser.parse();
    }

    private void handleParsingException(ParseException e) {
        System.out.println(INVALID_BATTLESHIP_INPUT_LINE_FORMAT_MESSAGE);
        //TODO: use stackTrace features
        /*
        var stackTrace = e.getStackTrace();
        stackTrace[]
         */
        clearBattleships();
    }

    private void validateBattleshipPositions(Position[] positions) {
        if (!isBattleshipInBounds(positions)) {
            throw new InputMismatchException(BATTLESHIP_OUT_OF_BOUNDS_MESSAGE);
        } else if (isAnyOverlappingBattleship(positions)) {
            throw new InputMismatchException(BATTLESHIPS_OVERLAP_MESSAGE);
        }
    }

    private void handleInvalidSelectedPosition(int length, InputMismatchException ipse) {
        System.out.println(INVALID_BATTLESHIP_SELECTED_MESSAGE);
        System.out.println(ipse.getLocalizedMessage());
        tryPlaceBattleship(length);
    }

    @Override
    public Position selectTarget() {
        var userInputLine = fetchUserInputLine();
        return tryParseUserTargetInputLine(userInputLine);
    }

    private String fetchUserInputLine() {
        System.out.println(SELECT_TARGET_MESSAGE);
        return scanner.nextLine();
    }

    //TODO: refactor this
    private String fetchUserInputLine(int length) {
        String battleshipName;
        if (length == SUBMARINE_LENGTH) {
            battleshipName = "SUBMARINE";
        } else if (length == CRUISER_LENGTH) {
            battleshipName = "CRUISER";
        } else if (length == AIRCRAFT_CARRIER_LENGTH) {
            battleshipName = "AIRCRAFT CARRIER";
        } else {
            throw new RuntimeException("Invalid length");
        }
        var userMessage = String.format(SELECT_BATTLESHIP_MESSAGE, battleshipName);
        System.out.println(userMessage);
        return scanner.nextLine();
    }

    private boolean isBattleshipInBounds(Position[] positions) {
        return Arrays.stream(positions)
                .allMatch(board::isWithinRange);
    }

    private boolean isAnyOverlappingBattleship(Position[] battleshipPositions) {
        return Arrays.stream(battleshipPositions)
                .anyMatch(pos -> board.isAnySurroundingBattleship(pos.GetVerticalPosition(),
                                                                  pos.GetHorizontalPosition()));
    }

    //TODO: refactor this
    private Position tryParseUserTargetInputLine(String line) {
        try {
            var parser = new TargetInputLineParser(line);
            return parser.parse();
        } catch (ParseException e) {
            handleInvalidFormat();
            return new Position(0,0); //TODO: remove this
        }
    }
    private void handleInvalidFormat() {
        //TODO: implement this
        throw new UnsupportedOperationException();
    }
}
