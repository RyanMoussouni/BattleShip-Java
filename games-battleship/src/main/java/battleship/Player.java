package battleship;

public interface Player {
    Position selectTarget();
    boolean isDefeated();
    void fireAt(Position target);
}

