package br.com.kauedb.mars_explorer.domain;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class CardinalDirectionChangeDirectionTest {

    @DataProvider
    public Object[][] directionAndLeft() {
        return new Object[][]{
                {CardinalDirection.NORTH, CardinalDirection.WEST},
                {CardinalDirection.WEST, CardinalDirection.SOUTH},
                {CardinalDirection.SOUTH, CardinalDirection.EAST},
                {CardinalDirection.EAST, CardinalDirection.NORTH},
        };
    }

    @Test(dataProvider = "directionAndLeft")
    public void shouldGetLeftDirection(Direction direction, Direction left) {
        assertThat(direction.getLeft(), is(left));
    }

    @DataProvider
    public Object[][] directionAndRight() {
        return new Object[][]{
                {CardinalDirection.NORTH, CardinalDirection.EAST},
                {CardinalDirection.EAST, CardinalDirection.SOUTH},
                {CardinalDirection.SOUTH, CardinalDirection.WEST},
                {CardinalDirection.WEST, CardinalDirection.NORTH},
        };
    }

    @Test(dataProvider = "directionAndRight")
    public void shouldGetRightDirection(Direction direction, Direction right) {
        assertThat(direction.getRight(), is(right));
    }

}