package battleship;

import org.junit.Test;
import org.junit.Assert;

import battleship.Player.RobotPlayer;

public class RobotPlayerTest {

    //TODO: this test is not that clean; is it really what we want
    @Test
    public void selectPosition_should_return_no3equalTargets_when_called_3times() {
        // Arrange
        var player = new RobotPlayer();
        var target1 = player.selectTarget();
        var target2 = player.selectTarget();
        var target3 = player.selectTarget();

        // Act

        // Assert
        Assert.assertFalse(target1.equals(target2)
                                 && target2.equals(target3));
    }

    @Test
    public void isDefeated_should_return_true_when_noBattleship() {
        // Arrange  // should be filled with water, so no battleship
        var player = new RobotPlayer();

        // Act

        // Assert
        Assert.assertTrue(player.isDefeated());
    }
}
