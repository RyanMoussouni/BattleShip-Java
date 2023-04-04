package battleship;

import org.junit.Test;
import org.junit.Assert;

public class GameboardTest {

    @Test
    public void isWithinRange_should_return_true_when_size10_for_Cell16() {
        // Arrange
        var gameboard = new Gameboard();
        var cellPosition = new Position(1,6);

        // Act

        // Assert
        Assert.assertTrue(gameboard.isWithinRange(cellPosition));
    }

    @Test
    public void isWaterAt_should_return_true_when_onlyWater_for_cell01() {
        // Arrange
        var gameboard = new Gameboard();
        var cellPosition = new Position(0,1);

        // Act

        // Assert
        Assert.assertTrue(gameboard.isWaterAt(cellPosition) == Cell.WATER);
    }

    @Test
    public void isAnyBattleShip_should_return_false_when_onlyWater() {
        // Arrange
        var gameboard = new Gameboard();

        // Act

        // Assert
        Assert.assertFalse(gameboard.isAnyBattleship());
    }
}