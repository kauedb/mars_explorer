package br.com.kauedb.mars_explorer.infrastructure.repository;

import br.com.kauedb.mars_explorer.domain.Probe;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ProbeRepository {
    private static final Map<Integer, Probe> PROBES = new HashMap<>();

    public Probe find(Integer id) {
        return PROBES.get(id);
    }

    public Probe save(Integer id, Probe probe) {
        PROBES.put(id, probe);
        return probe;
    }


}
