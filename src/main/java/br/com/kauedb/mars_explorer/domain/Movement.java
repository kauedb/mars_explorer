package br.com.kauedb.mars_explorer.domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public enum Movement {
    LEFT("L"), RIGHT("R"), MOVE("M");

    private static final Map<String, Movement> MOVEMENT_COMMANDS = new HashMap<>();

    static {
        for (Movement movement : Movement.values()) {
            MOVEMENT_COMMANDS.put(movement.getAlias(), movement);
        }
    }

    private final String alias;

    Movement(String alias) {
        this.alias = alias;
    }

    public static Movement getByAlias(final String alias) {
        return MOVEMENT_COMMANDS.get(alias);
    }

    public String getAlias() {
        return alias;
    }

}