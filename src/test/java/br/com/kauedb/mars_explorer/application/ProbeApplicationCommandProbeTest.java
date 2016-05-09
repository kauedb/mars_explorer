package br.com.kauedb.mars_explorer.application;

import br.com.kauedb.mars_explorer.domain.CardinalDirection;
import br.com.kauedb.mars_explorer.domain.DirectedPosition;
import br.com.kauedb.mars_explorer.domain.Probe;
import br.com.kauedb.mars_explorer.infrastructure.repository.ProbeRepositoryCustom;
import mockit.Injectable;
import mockit.Tested;
import org.testng.annotations.Test;

import static mockit.Deencapsulation.setField;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class ProbeApplicationCommandProbeTest {

    @Tested
    private ProbeApplication probeApplication;

    @Injectable
    private ProbeRepositoryCustom probeRepository;

    @Test
    public void shouldCommandProbe() throws Throwable {
        setField(probeApplication, "probeRepository", new ProbeRepositoryCustom());

        final ProbeApplication.Command command = ProbeApplication.Command.builder()
                .upperLimitX(5).upperLimitY(5)
                .x(1).y(1).direction("N")
                .movements("MLMRM")
                .probeId(1)
                .build();
        final Probe probe = probeApplication.commandProbe(probeId, command);
        assertThat(probe.getPosition(), is(DirectedPosition.completeBuilder()
                        .x(0)
                        .y(3)
                .direction(CardinalDirection.NORTH)
                        .build()
        ));
    }

}