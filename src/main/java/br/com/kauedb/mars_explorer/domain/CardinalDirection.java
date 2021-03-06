package br.com.kauedb.mars_explorer.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public enum CardinalDirection implements Direction {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W"),;

    private final static Map<Direction, Map<Movement, Direction>> DIRECTION_MAP = new HashMap<>();
    private static final Map<String, Direction> DIRECTION_COMMANDS = new HashMap<>();

    static {
        DIRECTION_MAP.put(CardinalDirection.NORTH, new HashMap<Movement, Direction>() {{
            put(Movement.LEFT, CardinalDirection.WEST);
            put(Movement.RIGHT, CardinalDirection.EAST);
        }});
        DIRECTION_MAP.put(CardinalDirection.SOUTH, new HashMap<Movement, Direction>() {{
            put(Movement.LEFT, CardinalDirection.EAST);
            put(Movement.RIGHT, CardinalDirection.WEST);
        }});
        DIRECTION_MAP.put(CardinalDirection.EAST, new HashMap<Movement, Direction>() {{
            put(Movement.LEFT, CardinalDirection.NORTH);
            put(Movement.RIGHT, CardinalDirection.SOUTH);
        }});
        DIRECTION_MAP.put(CardinalDirection.WEST, new HashMap<Movement, Direction>() {{
            put(Movement.LEFT, CardinalDirection.SOUTH);
            put(Movement.RIGHT, CardinalDirection.NORTH);
        }});
    }

    static {
        for (CardinalDirection direction : CardinalDirection.values()) {
            DIRECTION_COMMANDS.put(direction.getAlias(), direction);
        }
    }

    private final String alias;

    CardinalDirection(String alias) {
        this.alias = alias;
    }

    public static Direction getByAlias(final String alias) {
        return DIRECTION_COMMANDS.get(alias);
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public Direction turn(Movement movement) {
        return DIRECTION_MAP.get(this).get(movement);
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
