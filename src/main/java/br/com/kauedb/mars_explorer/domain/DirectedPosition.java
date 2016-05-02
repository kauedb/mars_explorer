package br.com.kauedb.mars_explorer.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 *
 */
@Value
@EqualsAndHashCode(callSuper = true)
public class DirectedPosition extends Position {
    Direction direction;

    @Builder(builderMethodName = "completeBuilder")
    public DirectedPosition(Integer x, Integer y, Direction direction) {
        super(x, y);
        this.direction = direction;
    }
}
