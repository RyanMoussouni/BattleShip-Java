package battleship;

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
    public boolean isDefeated() {
        var isAnyBattleship = board.isAnyBattleship();
        return !isAnyBattleship;
    }
}
