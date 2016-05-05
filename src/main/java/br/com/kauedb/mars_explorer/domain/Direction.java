package br.com.kauedb.mars_explorer.domain;

/**
 *
 */
public interface Direction {
    Direction turn(Movement movement);

    boolean isPositiveDirection();

    boolean isNegativeDirection();

    boolean isXDirection();

    boolean isYDirection();
}
