package br.com.kauedb.mars_explorer.application;

import br.com.kauedb.mars_explorer.domain.DirectedPosition;
import br.com.kauedb.mars_explorer.domain.Movement;
import br.com.kauedb.mars_explorer.domain.Probe;
import br.com.kauedb.mars_explorer.infrastructure.exception.InvalidMovementException;
import br.com.kauedb.mars_explorer.infrastructure.exception.MovingBeyondLimitException;
import br.com.kauedb.mars_explorer.infrastructure.exception.PositionRequiredException;
import br.com.kauedb.mars_explorer.infrastructure.exception.ProbeNotFoundException;
import br.com.kauedb.mars_explorer.infrastructure.repository.ProbeRepositoryCustom;
import lombok.Builder;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ProbeApplication {

    private final ProbeRepositoryCustom probeRepository;

    @Autowired
    public ProbeApplication(final ProbeRepositoryCustom probeRepository) {
        this.probeRepository = probeRepository;
    }


    public Probe commandProbe(Integer probeId, Command command) throws MovingBeyondLimitException, InvalidMovementException, ProbeNotFoundException, PositionRequiredException {

        final Probe probe = probeRepository.find(probeId);
        if (probe == null) {
            throw new ProbeNotFoundException();
        }
        applyMovements(command, probe);

        return probe;
    }

    private void applyMovements(Command command, Probe probe) throws MovingBeyondLimitException, InvalidMovementException, PositionRequiredException {
        for (char m : command.getMovements().toCharArray()) {
            final Movement movement = Movement.getByAlias(String.valueOf(m));
            if (movement == null) {
                throw new InvalidMovementException();
            }
            probe.move(movement);
        }
    }

    public UpperLimit setUpperLimit(Integer probeId, UpperLimit upperLimit) {
        return null;
    }

    public DirectedPosition setPosition(Integer probeId, Position initialPosition) {
        return null;
    }

    @Value
    @Builder
    public static class Command extends Resource<Command> {
        String movements;
        int probeId;
    }

    @Value
    @Builder
    public static class Position extends Resource<Position> {
        int x;
        int y;
        String direction;
    }

    @Value
    @Builder
    public static class UpperLimit extends Resource<UpperLimit> {
        int x;
        int y;
    }


}
