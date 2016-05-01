package br.com.kauedb.mars_explorer.domain;

import java.util.Objects;

/**
 *
 */
public class Position {

    private final Integer x;
    private final Integer y;
    private final Direction direction;

    public Position(Integer x, Integer y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(x, position.x) &&
                Objects.equals(y, position.y) &&
                Objects.equals(direction, position.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }
}
