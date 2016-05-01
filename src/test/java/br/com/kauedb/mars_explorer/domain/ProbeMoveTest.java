package br.com.kauedb.mars_explorer.domain;

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

    @Test
    public void shouldMoveNorthHeadingNorth() {
        final Position initialPosition = Position.builder().x(0).y(0).direction(CardinalDirection.NORTH).build();
        setField(probe, "position", initialPosition);

        probe.move(Movement.MOVE);
        assertThat(probe.getPosition(), is(Position.builder().x(0).y(1).direction(CardinalDirection.NORTH).build()));
    }

}
