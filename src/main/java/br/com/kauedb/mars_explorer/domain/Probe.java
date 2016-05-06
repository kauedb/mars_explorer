package br.com.kauedb.mars_explorer.domain;

import br.com.kauedb.mars_explorer.infrastructure.exception.MovingBeyondLimitException;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.extern.java.Log;

/**
 *
 */
@Value
@Log
@Builder
public class Probe {
    static Position LOWER_LIMIT = Position.builder().x(0).y(0).build();
    @NonFinal
    DirectedPosition position;
    Position upperLimit;

    public void move(Movement movement) throws MovingBeyondLimitException {

        if (movement.equals(Movement.MOVE)) {
            position = position.move();
        } else {
            position = position.changeDirection(movement);
        }

        if (position.biggerThen(upperLimit)) {
            throw new MovingBeyondLimitException();
        }

        if (position.lesserThen(LOWER_LIMIT)) {
            throw new MovingBeyondLimitException();
        }
    }

}
