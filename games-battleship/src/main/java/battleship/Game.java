package battleship;

import battleship.Player.Player;
import battleship.Player.HumanPlayer;
import battleship.Player.RobotPlayer;

import java.util.Arrays;

public class Game {
    private static final String IS_HUMAN_PLAYER_TURN_MESSAGE = "It's your turn to attack!";
    private static final String IS_ROBOT_PLAYER_TURN_MESSAGE = "It's the robot's turn to attack!";
    private static final String WINNING_MESSAGE = "You've won! Congrats!";
    private static final String GAME_OVER_MESSAGE = "You've lost!";
    private final Player[] players;
    private boolean isOver;
    private boolean isHumanPlayerAttacking;

    public Game() {
        players = new Player[] { new HumanPlayer(),
                                 new RobotPlayer() };
        isOver = false;
        isHumanPlayerAttacking = true;
    }

    public void play(){
        startGame();
        while (!isOver) {
            playTurn();
            switchAttacker();
            updateGameStatus();
        }
        endGame();
    }

    private void startGame() {
        Arrays.stream(players)
            .forEach(Player::placeBattleships);
    }


    private void playTurn() {
        Player humanPlayer = players[0];
        Player robotPlayer = players[1];
        if (isHumanPlayerAttacking) {
            System.out.println(IS_HUMAN_PLAYER_TURN_MESSAGE);
            playTurn(humanPlayer, robotPlayer);
        } else {
            System.out.println(IS_ROBOT_PLAYER_TURN_MESSAGE);
            playTurn(robotPlayer, humanPlayer);
        }
    }

    private void playTurn(Player attacker, Player defendant) {
        Position target = attacker.selectTarget();
        defendant.fireAt(target);
        System.out.println(defendant.getFiringResultMessage());
    }

    private void switchAttacker() {
        isHumanPlayerAttacking = !isHumanPlayerAttacking;
    }

    private void updateGameStatus() {
        isOver = players[0].isDefeated() || players[1].isDefeated();
    }

    private void endGame() {
        if (isHumanPlayerAttacking) {
            System.out.println(WINNING_MESSAGE);
        } else {
            System.out.println(GAME_OVER_MESSAGE);
        }
    }
}
