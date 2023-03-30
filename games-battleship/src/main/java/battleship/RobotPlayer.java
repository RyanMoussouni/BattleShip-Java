package battleship;

public class RobotPlayer extends AbstractPlayer {

    @Override
    public Position selectTarget() {
        var randomX = (int)(Math.random() * board.SIZE);
        var randomY = (int)(Math.random() * board.SIZE);

        return new Position(randomX, randomY);
    }
}
