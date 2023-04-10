package battleship.Player;

import battleship.Gameboard;
import battleship.Position;

public abstract class AbstractPlayer implements Player {
    protected final Gameboard board;

    public AbstractPlayer() {
        board = new Gameboard();
    }

    @Override
    public void fireAt(Position target) {
        board.fireAt(target);
    }

    @Override
    public String getFiringResultMessage() {
        return board.getFiringResultMessage();
    }

    @Override
    public boolean isDefeated() {
        var isAnyBattleship = board.isAnyBattleship();
        return !isAnyBattleship;
    }
}
