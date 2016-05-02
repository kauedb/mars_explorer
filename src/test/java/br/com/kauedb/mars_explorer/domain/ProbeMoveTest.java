package br.com.kauedb.mars_explorer.domain;

import br.com.kauedb.mars_explorer.infrastructure.exception.MovingBeyondLimitException;
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
    private Position position;

    @Injectable
    private Position upperLimit;

    @Test
    public void shouldMoveNorthHeadingNorth() throws Throwable {
        final Position initialPosition = DirectedPosition.completeBuilder().x(0).y(0).direction(CardinalDirection.NORTH).build();
        setField(probe, "position", initialPosition);
        final Position upperLimit = Position.builder().x(1).y(1).build();
        setField(probe, "upperLimit", upperLimit);

        probe.move(Movement.MOVE);
        assertThat(probe.getPosition(), is(DirectedPosition.completeBuilder().x(0).y(1).direction(CardinalDirection.NORTH).build()));
    }


    @Test(expected = MovingBeyondLimitException.class)
    public void shouldNotMoveBeyondUpperLimit() throws Throwable {
        final Position initialPosition = DirectedPosition.completeBuilder().x(0).y(1).direction(CardinalDirection.NORTH).build();
        setField(probe, "position", initialPosition);
        final Position upperLimit = Position.builder().x(0).y(0).build();
        setField(probe, "upperLimit", upperLimit);

        probe.move(Movement.MOVE);
    }
}