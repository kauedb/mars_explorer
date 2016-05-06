package br.com.kauedb.mars_explorer.domain;

/**
 *
 */
public interface Direction {
    String getAlias();

    Direction turn(Movement movement);

    boolean isPositiveDirection();

    boolean isNegativeDirection();

    boolean isXDirection();

    boolean isYDirection();
}
