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

    }

    public Position getPosition() {
        return position;
    }

}
