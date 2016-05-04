package br.com.kauedb.mars_explorer.domain;

import mockit.Injectable;
import mockit.Tested;
import org.testng.annotations.Test;

import static mockit.Deencapsulation.setField;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 */
public class ProbeChangeDirectionTest {

    @Tested
    private Probe probe;

    @Injectable
    private DirectedPosition position;

    @Injectable
    private Position upperLimit;

    @Test
    public void shouldChangeDirectionToLeft() throws Throwable {
        final Position initialPosition = DirectedPosition.completeBuilder().x(0).y(0).direction(CardinalDirection.NORTH).build();
        setField(probe, "position", initialPosition);
        final Position upperLimit = Position.builder().x(0).y(0).build();
        setField(probe, "upperLimit", upperLimit);

        probe.move(Movement.LEFT);
        assertThat(probe.getPosition(), is(DirectedPosition.completeBuilder().x(0).y(0).direction(CardinalDirection.WEST).build()));
    }

    @Test
    public void shouldChangeDirectionToRight() throws Throwable {
        final Position initialPosition = DirectedPosition.completeBuilder().x(0).y(0).direction(CardinalDirection.NORTH).build();
        setField(probe, "position", initialPosition);
        final Position upperLimit = Position.builder().x(0).y(0).build();
        setField(probe, "upperLimit", upperLimit);

        probe.move(Movement.RIGHT);
        assertThat(probe.getPosition(), is(DirectedPosition.completeBuilder().x(0).y(0).direction(CardinalDirection.EAST).build()));
    }

}
