package br.com.kauedb.mars_explorer.domain;

import java.util.Arrays;

/**
 *
 */
public enum CardinalDirection implements Direction {
    NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");

    private final String alias;

    CardinalDirection(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public boolean isPositiveDirection() {
        return Arrays.asList(NORTH, EAST).contains(this);
    }

    @Override
    public boolean isNegativeDirection() {
        return Arrays.asList(SOUTH, WEST).contains(this);
    }

    @Override
    public boolean isXDirection() {
        return Arrays.asList(WEST, EAST).contains(this);
    }

    @Override
    public boolean isYDirection() {
        return Arrays.asList(NORTH, SOUTH).contains(this);
    }

}
