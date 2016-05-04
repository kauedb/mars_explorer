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

        if (direction.isXDirection()) {
            return moveX();
        } else {
            return moveY();
        }

    }

    private DirectedPosition moveY() {
        if (direction.isPositiveDirection()) {
            return DirectedPosition.completeBuilder().x(this.x).y(this.y + 1).direction(this.direction).build();
        } else {
            return DirectedPosition.completeBuilder().x(this.x).y(this.y - 1).direction(this.direction).build();
        }
    }

    private DirectedPosition moveX() {
        if (direction.isPositiveDirection()) {
            return DirectedPosition.completeBuilder().x(this.x + 1).y(this.y).direction(this.direction).build();
        } else {
            return DirectedPosition.completeBuilder().x(this.x - 1).y(this.y).direction(this.direction).build();
        }
    }

    public DirectedPosition changeDirection(Movement movement) {
        final Direction newDirection;
        if (Movement.LEFT.equals(movement)) {
            newDirection = this.direction.getLeft();
        } else if (Movement.RIGHT.equals(movement)) {
            newDirection = this.direction.getRight();
        } else {
            newDirection = this.direction; // don't move
        }
        return DirectedPosition.completeBuilder().x(this.x).y(this.y).direction(newDirection).build();
    }
}
