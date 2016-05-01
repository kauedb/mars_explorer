package br.com.kauedb.mars_explorer.domain;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 */
public class ProbeMoveTest {

    @Tested
    private Probe probe;

    @Injectable
    private Position initialPosition;


    @Test
    public void shouldMoveNorthHeadingNorth() {
        new Expectations() {{
            initialPosition.getX();
            result = 0;
            initialPosition.getY();
            result = 0;
            initialPosition.getDirection();
            result = CardinalDirection.NORTH;
        }};
        probe.move(Movement.MOVE);
        assertThat(probe.getPosition(), is(new Position(0, 1, CardinalDirection.NORTH)));
    }

}
