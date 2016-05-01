package br.com.kauedb.mars_explorer.domain;

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
}
