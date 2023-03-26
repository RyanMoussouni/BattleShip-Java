package battleship;

public class Gameboard {
    public final int SIZE = 10;
    private Cell[][] grid;

    public Gameboard() {
        SetGridWithWater();
    }

    private void SetGridWithWater() {
        for (int i = 0; i<SIZE; i++) {
            for (int j = 0; j<SIZE; j++) {
                grid[i][j] = Cell.WATER;
            }
        }
    }

    public void FireAt() {
    }

    public boolean isWithinRange(Position p) {
        int x = p.GetHorizontalPosition();
        int y = p.GetVerticalPosition();
        return (x >= 0) && (x < SIZE) 
               && (y >= 0) && (y < SIZE);
    }
}
