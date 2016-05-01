package br.com.kauedb.mars_explorer.domain;

/**
 *
 */
public enum Movement {
    LEFT("L"), RIGHT("R"), MOVE("M");

    private final String alias;

    Movement(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
}
