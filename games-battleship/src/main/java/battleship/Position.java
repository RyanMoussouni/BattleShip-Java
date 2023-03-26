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
        if (isTopLeftCorner(xLimits, yLimits)) {
            throw new NoSuchAlgorithmException();
        } else if (isTopRightCorner(xLimits, yLimits) ) {
            throw new NoSuchAlgorithmException();
        } else if (isDownLeftCorner(xLimits, yLimits)) {
            throw new NoSuchAlgorithmException();
        } else if (isDownRightCorner(xLimits, yLimits)) {
            throw new NoSuchAlgorithmException();
        } else { //isInCentralPart
            
            throw new NoSuchAlgorithmException();
        }

    }

    public boolean isTopLeftCorner(int[] xLimits, int[] yLimits) {
        return x < xLimits[1]  
            && x > xLimits[0]
            && y < yLimits[1]
            && y > yLimits[1];
    }

    public boolean isTopRightCorner(int[] xLimits, int[] yLimits) {
        return x < xLimits[]
    }

    public boolean isDownLeftCorner(int[] xLimits, int[] yLimits) {
        return true;
    }

    public boolean isDownRightCorner(int[] xLimits, int[] yLimits) {
        return true;
    }
}
