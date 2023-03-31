package battleship;

import java.text.ParseException;
import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {
    private final Scanner scanner;
    private static final int ASCII_ENCODING_ZERO = 30;
    private static final int ASCII_ENCODING_NINE = 39;

    public HumanPlayer() {
        super();
        scanner = new Scanner(System.in);
    }

    @Override
    public Position selectTarget() {
        var userInputLine = fetchUserInputLine();
        return tryParseUserInputLine(userInputLine);
    }

    private Position tryParseUserInputLine(String line) {
        try {
            return parseUserInputLine(line);
        } catch (ParseException e) { //TODO: find a better exception to use
            handleInvalidFormat();
        }
    }

    private Position parseUserInputLine(String line) throws ParseException {
        if (!isTwoDigitNumber(line)) {
            throw new ParseException("Unable to read input: you did not provide a two digit number.", 0);
        } else {
            int firstDigit = Integer.parseInt(line.substring(0, 1));
            int secondDigit = Integer.parseInt(line.substring(1,2));
            return new Position(firstDigit, secondDigit);
        }
    }

    private boolean isTwoDigitNumber(String line) {
        var isOfLengthTwo = line.length() == 2;
        var firstCharacter = line.charAt(0);
        var secondCharacter = line.charAt(1);
        return isOfLengthTwo
            && isDigit(firstCharacter)
            && isDigit(secondCharacter);
    }

    private static boolean isDigit(char c) {
        var encoding = encodeToASCII(c);
        return encoding <= ASCII_ENCODING_NINE
            && encoding >= ASCII_ENCODING_ZERO;
    }

    private static int encodeToASCII(char c) {
        return c;
    }
}
