package battleship;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        SetHorizontalPosition(x);
        SetVerticalPosition(y);
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

    public boolean equals(Position other) {
        return other.GetHorizontalPosition() == this.GetHorizontalPosition()
            && other.GetVerticalPosition() == this.GetVerticalPosition();
    }

    public boolean horizontallyEquals(Position other) {
        return this.y == other.GetHorizontalPosition();
    }

    public boolean verticallyEquals(Position other) {
        return this.x == other.GetVerticalPosition();
    }

    public Position[] getSurroundingPositions(Position topLeft, Position bottomRight) {
        Position positionToTheLeft = new Position(x, y-1);
        Position positionToTheRight = new Position(x, y+1);
        Position positionAbove = new Position(x-1, y);
        Position positionBelow = new Position(x+1, y);
        
        if (isTopLeftCorner(topLeft, bottomRight)) {
            return new Position[] {
                positionBelow,
                positionToTheRight
            };
        } else if (isTopRightCorner(topLeft, bottomRight) ) {
            return new Position[] {
                positionToTheLeft,
                positionBelow
            };
        } else if (isBottomLeftCorner(topLeft, bottomRight)) {
            return new Position[] {
                positionAbove,
                positionToTheRight
            };
        } else if (isBottomRightCorner(topLeft, bottomRight)) {
            return new Position[] {
                positionToTheLeft,
                positionAbove
            };
        } else if (isUpperLine(topLeft, bottomRight)) { 
            return new Position[] {
                positionBelow,
                positionToTheLeft,
                positionToTheRight
            };
        } else if (isBottomLine(topLeft, bottomRight)) {
            return new Position[] {
                positionAbove,
                positionToTheRight,
                positionToTheLeft
            };
        } else if (isLeftColumn(topLeft, bottomRight)) {
            return new Position[] {
                positionAbove,
                positionBelow,
                positionToTheRight
            };
        } else if (isRightColumn(topLeft, bottomRight)) {
            return new Position[] {
                positionToTheRight,
                positionBelow,
                positionAbove
            };
        } else { //isInCentralPart
            return new Position[] {
                positionAbove,
                positionBelow,
                positionToTheLeft,
                positionToTheRight
            };
        }
    }

    public boolean isTopLeftCorner(Position topLeft, Position bottomRight) {
        return this.equals(topLeft);
    }

    public boolean isTopRightCorner(Position topLeft, Position bottomRight) {
        Position topRight = new Position(topLeft.GetHorizontalPosition(), bottomRight.GetVerticalPosition());
        return this.equals(topRight);
    }

    public boolean isBottomLeftCorner(Position topLeft, Position bottomRight) {
        Position bottomLeft = new Position(bottomRight.GetHorizontalPosition(), topLeft.GetVerticalPosition());
        return this.equals(bottomLeft);
    }

    public boolean isBottomRightCorner(Position topLeft, Position bottomRight) {
        return this.equals(bottomRight);
    }

    public boolean isUpperLine(Position topLeft, Position bottomRight) {
        return this.horizontallyEquals(topLeft);
    }

    public boolean isBottomLine(Position topLeft, Position bottomRight) {
        return this.horizontallyEquals(bottomRight);
    }

    public boolean isLeftColumn(Position topLeft, Position bottomRight) {
        return this.verticallyEquals(topLeft);
    }

    public boolean isRightColumn(Position topLeft, Position bottomRight) {
        return this.verticallyEquals(bottomRight);
    }
}
