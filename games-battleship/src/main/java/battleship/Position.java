package battleship;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
    }

    public void SetHorizontalPosition(int x) {
        this.x = x;
    }

    public int GetHorizontalPosition() {
        return x;
    }

    public void SetVerticalPosition(int y) {
        this.y = y;
    }

    public int GetVerticalPosition() {
        return y;
    }
}
