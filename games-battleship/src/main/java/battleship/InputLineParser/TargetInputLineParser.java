package battleship.InputLineParser;

import battleship.Position;

import java.text.ParseException;

public class TargetInputLineParser extends AbstractInputLineParser<Position> {
    private static final String PARSING_EXCEPTION_MESSAGE = "Unable to read input: you did not provide a two digit number.";

    public TargetInputLineParser(String rawLine) {
        super(rawLine);
    }

    public Position parse() throws ParseException {
        if (!isTwoDigitNumber(rawLine)) {
            throw new ParseException(PARSING_EXCEPTION_MESSAGE, 0);
        } else {
            int firstDigit = Integer.parseInt(rawLine.substring(0, 1));
            int secondDigit = Integer.parseInt(rawLine.substring(1, 2));
            return new Position(firstDigit, secondDigit);
        }
    }

    private boolean isTwoDigitNumber(String line) {
        var isOfLengthTwo = line.length() == 2;
        var firstCharacter = line.charAt(0);
        var secondCharacter = line.charAt(1);
        return isOfLengthTwo
                && Character.isDigit(firstCharacter)
                && Character.isDigit(secondCharacter);
    }
}
