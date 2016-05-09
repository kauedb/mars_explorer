package br.com.kauedb.mars_explorer.view.endpoints;

import br.com.kauedb.mars_explorer.application.ProbeApplication;
import br.com.kauedb.mars_explorer.domain.Position;
import br.com.kauedb.mars_explorer.domain.Probe;
import br.com.kauedb.mars_explorer.infrastructure.exception.InvalidMovementException;
import br.com.kauedb.mars_explorer.infrastructure.exception.MovingBeyondLimitException;
import br.com.kauedb.mars_explorer.infrastructure.exception.PositionRequiredException;
import br.com.kauedb.mars_explorer.infrastructure.exception.ProbeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 *
 */
@RestController
@RequestMapping("/probe")
public class ProbeEndpoints {

    private final ProbeApplication probeApplication;

    @Autowired
    public ProbeEndpoints(final ProbeApplication probeApplication) {
        this.probeApplication = probeApplication;
    }

    @RequestMapping(value = "/{id}/upperLimit", method = RequestMethod.POST)
    public ProbeApplication.UpperLimit setUpperLimit(@PathVariable("id") final Integer probeId, final ProbeApplication.UpperLimit upperLimit) throws MovingBeyondLimitException, InvalidMovementException, ProbeNotFoundException, PositionRequiredException {

        return probeApplication.setUpperLimit(probeId, upperLimit);
    }

    @RequestMapping(value = "/{id}/position", method = RequestMethod.POST)
    public Position setPosition(@PathVariable("id") final Integer probeId, final ProbeApplication.Position position) throws MovingBeyondLimitException, InvalidMovementException, ProbeNotFoundException, PositionRequiredException {

        return probeApplication.setPosition(probeId, position);
    }


    @RequestMapping(value = "/{id}/command", method = RequestMethod.POST)
    public ResponseEntity<ProbeApplication.Command> move(@PathVariable("id") final Integer probeId, final ProbeApplication.Command command) throws MovingBeyondLimitException, InvalidMovementException, ProbeNotFoundException, PositionRequiredException {

        final Probe probe = probeApplication.commandProbe(probeId, command);
        final ProbeApplication.Command result = ProbeApplication.Command.builder()
                .build();
        result.add(linkTo(methodOn(Probe.class).getPosition()).withSelfRel());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
