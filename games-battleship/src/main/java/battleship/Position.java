package battleship;

import java.security.NoSuchAlgorithmException;

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

    public Position[] getSurroundingPositions(int[] xLimits, int[] yLimits) {
        if (isTopLeftCorner(x, y, xLimits, yLimits)) {
            throw new NoSuchAlgorithmException();
        } else if (isTopRightCorner(x, y, xLimits, yLimits) ) {
            throw new NoSuchAlgorithmException();
        } else if (isDownLeftCorner(x, y, xLimits, yLimits)) {
            throw new NoSuchAlgorithmException();
        } else if (isDownRightCorner(x, y, xLimits, yLimits)) {
            throw new NoSuchAlgorithmException();
        } else {
            throw new NoSuchAlgorithmException();
        }

    }

    private static boolean isTopLeftCorner(int x, int y, int[] xLimits, int[] yLimits) {
        return x < xLimits[1]  
            && x > xLimits[0]
            && y < yLimits[1]
            && y > yLimits[1];
    }

    private static boolean isTopRightCorner(int x, int y, int[] xLimits, int[] yLimits) {
        return true;
    }

    private static boolean isDownLeftCorner(int x, int y, int[] xLimits, int[] yLimits) {
        return true;
    }

    private static boolean isDownRightCorner(int x, int y, int[] xLimits, int[] yLimits) {
        return true;
    }
}
