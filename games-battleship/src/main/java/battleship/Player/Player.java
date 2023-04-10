package battleship.Player;

import battleship.Position;

public interface Player {
    int AIRCRAFT_CARRIER_LENGTH = 5;
    int CRUISER_LENGTH = 3;
    int SUBMARINE_LENGTH = 2;

    void placeBattleships();
    Position selectTarget();
    boolean isDefeated();
    void fireAt(Position target);
    String getFiringResultMessage();
}

