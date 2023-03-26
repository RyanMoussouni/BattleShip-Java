package battleship;

public class Gameboard {
    public final int SIZE = 10;
    public final String IS_MISSED_MESSAGE = "Missed!";
    public final String IS_HIT_MESSAGE = "Hit!";
    public final String IS_SINKED_MESSAGE = "Sinked!";
    private String fireResultMessage = "No fire was intented";
    private Cell[][] grid;

    public Gameboard() {
        setGridWithWater();
    }

    private void setGridWithWater() {
        for (int i = 0; i<SIZE; i++) {
            for (int j = 0; j<SIZE; j++) {
                grid[i][j] = Cell.WATER;
            }
        }
    }

    public void setBattleShipAt(Position cellPosition) {
        int x = cellPosition.GetHorizontalPosition();
        int y = cellPosition.GetVerticalPosition();
        grid[x][y] = Cell.BATTLESHIP;
    }
    
    public void setWaterAt(Position cellPosition) {
        int x = cellPosition.GetHorizontalPosition();
        int y = cellPosition.GetVerticalPosition();
        grid[x][y] = Cell.WATER;
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

    private void updateFireResultMessage(Position cellPosition) {
        if (isLastBattleshipPartAt(cellPosition)) {
            fireResultMessage = IS_SINKED_MESSAGE;
        } else if (isBattleshipAt(cellPosition)) {
            fireResultMessage = IS_HIT_MESSAGE;
        } else {
            fireResultMessage = IS_SINKED_MESSAGE;
        }
    }

    public boolean isBattleshipAt(Position cellPosition) {
        int x = cellPosition.GetHorizontalPosition();
        int y = cellPosition.GetVerticalPosition();
        return grid[x][y] == Cell.BATTLESHIP;
    }

    private boolean isLastBattleshipPartAt(Position cellPosition) {
        int
        return grid[]
    }

    private void hitAt(Position cellPosition) {
        int x = cellPosition.GetHorizontalPosition();
        int y = cellPosition.GetVerticalPosition();
        grid[x][y] = Cell.WATER;
    }
}
