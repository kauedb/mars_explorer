package br.com.kauedb.mars_explorer.domain;

/**
 *
 */
public interface Direction {
    Direction getLeft();

    Direction getRight();

    boolean isPositiveDirection();

    boolean isNegativeDirection();

    boolean isXDirection();

    boolean isYDirection();
}
