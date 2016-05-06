package br.com.kauedb.mars_explorer.application;

import mockit.Tested;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class ProbeApplicationCommandProbeTest {

    @Tested
    private ProbeApplication probeApplication;

    @Test
    public void shouldCommandProbe() throws Throwable {
        final ProbeApplication.Command command = ProbeApplication.Command.builder()
                .upperLimitX(5).upperLimitY(5)
                .x(1).y(1).direction("N")
                .movements("MLMRM").build();
        final ProbeApplication.CurrentPosition currentPosition = probeApplication.commandProbe(command);
        assertThat(currentPosition, is(
                ProbeApplication.CurrentPosition.builder()
                        .x(0)
                        .y(3)
                        .direction("N")
                        .build()
        ));
    }

}