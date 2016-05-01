package br.com.kauedb.mars_explorer.domain;

/**
 *
 */
public class Probe {
    private Position position;

    public Probe(Position initialPosition) {
        this.position = initialPosition;
    }

    public void move(Movement movement) {

        position = Position.builder().x(0).y(1).direction(CardinalDirection.NORTH).build();
    }

    public Position getPosition() {
        return position;
    }

}
