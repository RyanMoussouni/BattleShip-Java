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

    public Position[] getSurroundingPositions(Position topLeft, Position bottomRight) {
        if (isTopLeftCorner(topLeft, bottomRight)) {
            throw new NoSuchAlgorithmException();
        } else if (isTopRightCorner(topLeft, bottomRight) ) {
            throw new NoSuchAlgorithmException();
        } else if (isBottomLeftCorner(topLeft, bottomRight)) {
            throw new NoSuchAlgorithmException();
        } else if (isBottomRightCorner(topLeft, bottomRight)) {
            throw new NoSuchAlgorithmException();
        } else { //isInCentralPart
            throw new NoSuchAlgorithmException();
        }

    }

    public boolean isTopLeftCorner(Position topLeft, Position bottomRight) {
        return x == xLimits[1]  
            && x == xLimits[0]
            && y < yLimits[1]
            && y > yLimits[1];
    }

    public boolean isTopRightCorner(Position topLeft, Position bottomRight) {
        return x == xLimits[1]  
            && x == xLimits[0]
            && y < yLimits[0]
            && y > yLimits[1];
    }

    public boolean isBottomLeftCorner(Position topLeft, Position bottomRight) {
        return x == xLimits[1]  
            && x == xLimits[0]
            && y < yLimits[0]
            && y > yLimits[1];
    }

    public boolean isBottomRightCorner(Position topLeft, Position bottomRight) {
        return x == xLimits[1]  
            && x == xLimits[0]
            && y < yLimits[0]
            && y > yLimits[1];
    }
}
