package battleship;

public class Gameboard {
    public final int SIZE = 10;
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

    public void fireAt(Position cellPosition) {
        if (isWithinRange(cellPosition)) {
            fireAtGameboardCell(cellPosition);
        } else {
            throwCellOutOfRangeException(cellPosition);
        }
    }

    private void fireAtGameboardCell(Position cellPosition) {

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
}
