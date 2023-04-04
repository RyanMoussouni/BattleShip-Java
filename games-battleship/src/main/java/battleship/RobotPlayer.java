package battleship;

import java.util.ArrayList;
import java.util.List;

public class RobotPlayer extends AbstractPlayer {

    @Override
    public void placeBattleships() {
        placeBattleshipRandomly(5);
        placeBattleshipRandomly(4);
        placeBattleshipRandomly(3);
        placeBattleshipRandomly(3);
        placeBattleshipRandomly(2);
    }

    private void placeBattleshipRandomly(int length) {
        var isHorizontal = isRandomOrientationHorizontal();
        var prow = selectRandomProw(length, isHorizontal);
        board.setBattleship(prow, isHorizontal, length);
    }

    private boolean isRandomOrientationHorizontal() {
        return ((int) (Math.random()*2) == 1);
    }

    private Position selectRandomProw(int length, boolean isHorizontalOrientation) {
        var maximalPossibleProwX = isHorizontalOrientation ? board.SIZE
                : board.SIZE - length;
        var maximalPossibleProwY = isHorizontalOrientation ? board.SIZE - length
                : board.SIZE;

        List<Position> candidates = new ArrayList<>();
        for (int i=0; i<board.SIZE - maximalPossibleProwY; i++) {
            for (int j=0; j<board.SIZE - length*maximalPossibleProwX; j++) {
                candidates.add(new Position(j, i));
            }
        }

        var randomIndex = (int) (Math.random() * candidates.size());
        return candidates.get(randomIndex);
    }

    @Override
    public Position selectTarget() {
        var randomX = (int)(Math.random() * board.SIZE);
        var randomY = (int)(Math.random() * board.SIZE);

        return new Position(randomX, randomY);
    }
}
