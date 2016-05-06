package br.com.kauedb.mars_explorer.application;

import br.com.kauedb.mars_explorer.domain.*;
import br.com.kauedb.mars_explorer.infrastructure.exception.MovingBeyondLimitException;
import lombok.Builder;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ProbeApplication {

    private static final Map<Integer, Probe> PROBES = new HashMap<>();

    public CurrentPosition commandProbe(Command command) throws MovingBeyondLimitException {

        Probe probe = PROBES.get(command.getProbeId());

        if (probe == null) {
            probe = Probe.builder()
                    .upperLimit(Position.builder()
                            .x(command.getUpperLimitX())
                            .y(command.getUpperLimitY())
                            .build())
                    .position(DirectedPosition.completeBuilder()
                            .x(command.getX()).y(command.getY())
                            .direction(CardinalDirection.getByAlias(command.getDirection()))
                            .build())
                    .build();
            PROBES.put(command.getProbeId(), probe);
        }

        for (char m : command.getMovements().toCharArray()) {
            final Movement movement = Movement.getByAlias(String.valueOf(m));
            probe.move(movement);
        }

        return CurrentPosition.builder()
                .x(probe.getPosition().getX())
                .y(probe.getPosition().getY())
                .direction(probe.getPosition().getDirection().getAlias())
                .build();
    }

    @Value
    @Builder
    public static class Command {
        int upperLimitX;
        int upperLimitY;
        int x;
        int y;
        String direction;
        String movements;
        int probeId;
    }

    @Value
    @Builder
    public static class CurrentPosition {
        int x, y;
        String direction;
    }
}
