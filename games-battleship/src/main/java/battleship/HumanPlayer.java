package battleship;

import java.text.ParseException;
import java.util.InputMismatchException;
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
    public void placeBattleships() {
        trySelectBattleship(5);
        trySelectBattleship(4);
        trySelectBattleship(3);
        trySelectBattleship(3);
        trySelectBattleship(2);
    }

    private void trySelectBattleship(int length) {
        try {
            selectBattleship(length);
        } catch (ParseException pe) {
            handleInvalidFormat();
        } catch (InputMismatchException ime) {
            handleInputOutOfBounds();
        }
    }

    private void selectBattleship(int length) {
        var userInputLine = fetchUserInputLine();
        var battleshipPosition = tryParseUserBattleshipInputLine(userInputLine);
        board.setBattleship(battleshipPosition);
    }

    @Override
    public Position selectTarget() {
        var userInputLine = fetchUserInputLine();
        return tryParseUserTargetInputLine(userInputLine);
    }

    private String fetchUserInputLine() {
        return scanner.nextLine();
    }

    private Position[] tryParseUserBattleshipInputLine(String line) {
        try {
            return parseUserBattleshipInputLine(line);
        } catch (ParseException e) {
            handleInvalidFormat();
            return new Position[] { new Position(0, 0) };
        }
    }

    private Position[] parseUserBattleshipInputLine(String line) {
        return new Position[] { new Position(5,5)};
    }

    //TODO: refactor this
    private Position tryParseUserTargetInputLine(String line) {
        try {
            return parseUserTargetInputLine(line);
        } catch (ParseException e) {
            handleInvalidFormat();
            return new Position(0,0); //TODO: remove this
        }
    }

    private Position parseUserTargetInputLine(String line) throws ParseException {
        if (!isTwoDigitNumber(line)) {
            throw new ParseException("Unable to read input: you did not provide a two digit number.", 0);
        } else {
            int firstDigit = Integer.parseInt(line.substring(0, 1));
            int secondDigit = Integer.parseInt(line.substring(1,2));
            return new Position(firstDigit, secondDigit);
        }
    }

    private void handleInvalidFormat() {
        //TODO: implement this
        throw new UnsupportedOperationException();
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
