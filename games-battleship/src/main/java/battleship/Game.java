package battleship;

public class Game {
    private Player[] players;
    private boolean isFirstPlayerTurn;
    private boolean isFinished;

    public Game() {
        players = new Player[] {new HumanPlayer(), new RobotPlayer()};
        isFirstPlayerTurn = true;
        isFinished = false;
    }
}
