package br.com.kauedb.mars_explorer.infrastructure.repository;

import br.com.kauedb.mars_explorer.domain.Probe;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Repository
public class ProbeRepositoryCustom {
    private static final Map<Integer, Probe> PROBES = new HashMap<>();

    static {
        PROBES.put(1, Probe.builder().build());
        PROBES.put(2, Probe.builder().build());
    }
    public Probe find(Integer id) {
        return PROBES.get(id);
    }

    public Probe save(Integer id, Probe probe) {
        PROBES.put(id, probe);
        return probe;
    }


}
