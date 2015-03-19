package no.mesan.fagark.persistering.neo4j.repository;

import no.mesan.fagark.persistering.neo4j.domain.Friendship;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Component;

@Component
public interface FriendshipRepository extends GraphRepository<Friendship> {

}
