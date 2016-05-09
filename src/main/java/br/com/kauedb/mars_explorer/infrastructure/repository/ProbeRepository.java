package br.com.kauedb.mars_explorer.infrastructure.repository;

import br.com.kauedb.mars_explorer.domain.Probe;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 */
public interface ProbeRepository extends MongoRepository<Probe, Integer> {
}
