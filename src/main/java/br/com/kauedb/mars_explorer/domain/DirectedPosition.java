package br.com.kauedb.mars_explorer.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

/**
 *
 */
@Value
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DirectedPosition extends Position {
    Direction direction;

    @Builder(builderMethodName = "completeBuilder")
    public DirectedPosition(Integer x, Integer y, Direction direction) {
        super(x, y);
        this.direction = direction;
    }

    public DirectedPosition move() {
        final DirectedPosition newPosition = direction.isXDirection() ? moveX() : moveY();
        return newPosition;
    }

    private DirectedPosition moveY() {
        final Integer newY = direction.isPositiveDirection() ? this.y + 1 : this.y - 1;
        return DirectedPosition.completeBuilder().x(this.x).y(newY).direction(this.direction).build();
    }

    private DirectedPosition moveX() {
        final Integer newX = direction.isPositiveDirection() ? this.x + 1 : this.x - 1;
        return DirectedPosition.completeBuilder().x(newX).y(this.y).direction(this.direction).build();
    }

    public DirectedPosition changeDirection(Movement movement) {
        final Direction newDirection = this.direction.turn(movement);
        return DirectedPosition.completeBuilder().x(this.x).y(this.y).direction(newDirection).build();
    }
}
