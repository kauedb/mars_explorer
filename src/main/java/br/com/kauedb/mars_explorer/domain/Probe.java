package br.com.kauedb.mars_explorer.domain;

import br.com.kauedb.mars_explorer.infrastructure.exception.MovingBeyondLimitException;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.extern.java.Log;

/**
 *
 */
@Value
@Log
public class Probe {
    static Position LOWER_LIMIT = Position.builder().x(0).y(0).build();
    @NonFinal
    Position position;
    Position upperLimit;

    public void move(Movement movement) throws MovingBeyondLimitException {
        position = DirectedPosition.completeBuilder().x(0).y(1).direction(CardinalDirection.NORTH).build();

        if (position.biggerThen(upperLimit)) {
            throw new MovingBeyondLimitException();
        }
    }

}
