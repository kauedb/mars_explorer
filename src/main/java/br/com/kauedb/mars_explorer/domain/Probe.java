package br.com.kauedb.mars_explorer.domain;

import lombok.Data;

/**
 *
 */
@Data
public class Probe {
    Position position;

    public void move(Movement movement) {
        position = Position.builder().x(0).y(1).direction(CardinalDirection.NORTH).build();
    }

}
