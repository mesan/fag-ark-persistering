package no.mesan.fagark.persistering.neo4j.repository;

import no.mesan.fagark.persistering.neo4j.domain.Prisoner;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Component;

@Component
public interface PrisonerRepository extends GraphRepository<Prisoner> {
	
	public Prisoner findByName(String name);
	
}
