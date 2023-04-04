package battleship;

public interface Player {
    void placeBattleships();
    Position selectTarget();
    boolean isDefeated();
    void fireAt(Position target);
}

