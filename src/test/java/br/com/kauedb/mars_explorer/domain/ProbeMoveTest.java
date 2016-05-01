package br.com.kauedb.mars_explorer.domain;

import mockit.Injectable;
import mockit.Tested;
import org.junit.Test;

import static mockit.Deencapsulation.setField;
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
        final Position initialPosition = new Position(0, 0, CardinalDirection.NORTH);
        setField(probe, "position", initialPosition);

        probe.move(Movement.MOVE);
        assertThat(probe.getPosition(), is(new Position(0, 1, CardinalDirection.NORTH)));
    }

}
