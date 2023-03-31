package battleship;

public class Game {
    private final Player[] players;
    private boolean isOver;
    private boolean isFirstPlayerAttacking;

    public Game() {
        players = new Player[] { new HumanPlayer(),
                                 new RobotPlayer() };
        isOver = false;
        isFirstPlayerAttacking = true;
    }

    public void play(){
        while (!isOver) {
            playTurn();
            updateAttacker();
            updateIsOver();
        }
    }

    //TODO: check if overloading is appropriate here
    private void playTurn() {
        Player firstPlayer = players[0];
        Player secondPlayer = players[1];
        if (isFirstPlayerAttacking) {
            playTurn(firstPlayer, secondPlayer);
        } else {
            playTurn(secondPlayer, firstPlayer);
        }
    }

    private void playTurn(Player attacker, Player defendant) {
        Position target = attacker.selectTarget();
        defendant.fireAt(target);
    }

    private void updateAttacker() {
        isFirstPlayerAttacking = !isFirstPlayerAttacking;
    }

    private void updateIsOver() {
        isOver = players[0].isDefeated() || players[1].isDefeated();
    }
}
