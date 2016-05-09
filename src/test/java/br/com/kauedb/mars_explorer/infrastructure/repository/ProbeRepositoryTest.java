package br.com.kauedb.mars_explorer.infrastructure.repository;

import br.com.kauedb.mars_explorer.domain.Probe;
import br.com.kauedb.mars_explorer.test.IntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class ProbeRepositoryTest extends IntegrationTest {

    @Autowired
    private ProbeRepository probeRepository;

    @Test
    public void shouldSaveAndRetrieveProbe() {
        final Probe saved = probeRepository.save(Probe.builder().id(1).build());
        final Probe one = probeRepository.findOne(1);
        assertThat(saved, is(one));
    }

}