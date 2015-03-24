package no.mesan.fagark.persistering.neo4j.repository;

import no.mesan.fagark.persistering.neo4j.domain.Enemyship;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Component;

@Component
public interface EnemyshipRepository extends GraphRepository<Enemyship> {

}
