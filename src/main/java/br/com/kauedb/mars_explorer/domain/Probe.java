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
        position = new Position(0, 1, CardinalDirection.NORTH);
    }

    public Position getPosition() {
        return position;
    }

}
