package battleship;

import java.util.*;

public class Gameboard {
    public final int SIZE = 10;
    public final String IS_MISSED_MESSAGE = "Missed!";
    public final String IS_HIT_MESSAGE = "Hit!";
    public final String IS_SUNK_MESSAGE = "Sunk!";
    private String firingResultMessage = "No firing happened";
    private Cell[][] grid;

    public Gameboard() {
        setGridWithWater();
    }

    private void setGridWithWater() {
        grid = new Cell[SIZE][SIZE];
        for (int i = 0; i<SIZE; i++) {
            for (int j = 0; j<SIZE; j++) {
                grid[i][j] = Cell.WATER;
            }
        }
    }

    public String getFiringResultMessage() {
        return this.firingResultMessage;
    }

    public void fireAt(Position cellPosition) {
        if (isWithinRange(cellPosition)) {
            fireAtGameboardCell(cellPosition); //TODO: find a better name, somehow
        } else {
            throwCellOutOfRangeException(cellPosition);
        }
    }

    private void fireAtGameboardCell(Position cellPosition) {
        if (isBattleshipAt(cellPosition)) {
            updateFireResultMessage(cellPosition);
            hitAt(cellPosition); //TODO: side effect
        }
    }

    private void updateFireResultMessage(Position cellPosition) {
        if (isLastBattleshipPartAt(cellPosition)) {
            firingResultMessage = IS_SUNK_MESSAGE;
        } else if (isBattleshipAt(cellPosition)) {
            firingResultMessage = IS_HIT_MESSAGE;
        } else {
            firingResultMessage = IS_MISSED_MESSAGE;
        }
    }

    /** Two battleships can't stick together */
    private boolean isLastBattleshipPartAt(Position cellPosition) {
        Position topLeftCorner = new Position(0,0);
        Position bottomRightCorner = new Position(SIZE, SIZE);
        Position[] surroundingPositions = cellPosition.getSurroundingPositions(topLeftCorner, bottomRightCorner);

        return Arrays.stream(surroundingPositions)
            .allMatch(this::isWaterAt);
    }

    private void throwCellOutOfRangeException(Position cellPosition) {
        String message = String.format("The provided cell of position (%d %d) is out of range",
                                       cellPosition.GetHorizontalPosition(),
                                       cellPosition.GetVerticalPosition());
        throw new IllegalArgumentException(message);
    }

    public boolean isWithinRange(Position cellPosition) {
        int x = cellPosition.GetHorizontalPosition();
        int y = cellPosition.GetVerticalPosition();
        return (x >= 0) && (x < SIZE) 
               && (y >= 0) && (y < SIZE);
    }

    public boolean isBattleshipAt(Position cellPosition) {
        int x = cellPosition.GetHorizontalPosition();
        int y = cellPosition.GetVerticalPosition();
        return grid[x][y] == Cell.BATTLESHIP;
    }

    public boolean isWaterAt(Position cellPosition) {
        int x = cellPosition.GetHorizontalPosition();
        int y = cellPosition.GetVerticalPosition();
        return grid[x][y] == Cell.WATER;
    }

    private void hitAt(Position cellPosition) {
        int x = cellPosition.GetHorizontalPosition();
        int y = cellPosition.GetVerticalPosition();
        grid[x][y] = Cell.WATER;
    }
}
