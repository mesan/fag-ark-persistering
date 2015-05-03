package no.mesan.fagark.persistering.neo4j.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import no.mesan.fagark.persistering.neo4j.domain.Enemyship;
import no.mesan.fagark.persistering.neo4j.domain.Friendship;
import no.mesan.fagark.persistering.neo4j.domain.Prisoner;
import no.mesan.fagark.persistering.neo4j.domain.PrisonerBuilder;
import no.mesan.fagark.persistering.neo4j.dto.EnemyshipDto;
import no.mesan.fagark.persistering.neo4j.dto.FriendshipDto;
import no.mesan.fagark.persistering.neo4j.dto.PrisonerDto;
import no.mesan.fagark.persistering.neo4j.dto.PrisonerDtoBuilder;
import no.mesan.fagark.persistering.neo4j.repository.EnemyshipRepository;
import no.mesan.fagark.persistering.neo4j.repository.FriendshipRepository;
import no.mesan.fagark.persistering.neo4j.repository.PrisonerRepository;

import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/prisoner")
public class PrisonerController {

	@Autowired
	PrisonerRepository prisonerRepository;

	@Autowired
	FriendshipRepository friendshipRepository;

	@Autowired
	EnemyshipRepository enemyshipRepository;

	@Autowired
	GraphDatabase graphDatabase;

	@RequestMapping(method = RequestMethod.POST, value = "/insert")
	public PrisonerDto insertPrisoner(@RequestBody PrisonerDto prisoner) {

		if (prisoner.getName() == null) {
			throw new IllegalArgumentException("Prisoner must have a name.");
		}
		
		try (Transaction tx = graphDatabase.beginTx()) {
			final Prisoner toInsert = PrisonerBuilder.buildFrom(prisoner).build();
			
			final Prisoner saved = prisonerRepository.save(toInsert);

			if (saved == null) {
				return null;
			}

			tx.success();

			final PrisonerDto dto = PrisonerDtoBuilder.buildFrom(saved).build();

			return dto;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findById")
	public PrisonerDto getPrisonerByNodeId(@RequestParam("nodeId") Long nodeId) {
		try (Transaction tx = graphDatabase.beginTx()) {
			final Prisoner result = prisonerRepository.findOne(nodeId);

			if (result == null) {
				return null;
			}

			tx.success();

			final PrisonerDto dto = PrisonerDtoBuilder.buildFrom(result).build();

			return dto;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findByName")
	public PrisonerDto getPrisonerByName(@RequestParam("name") String name) {
		try (Transaction tx = graphDatabase.beginTx()) {
			final Prisoner result = prisonerRepository.findByName(name);

			if (result == null) {
				return null;
			}

			tx.success();

			PrisonerDto dto = PrisonerDtoBuilder.buildFrom(result).build();

			return dto;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findAll")
	public List<PrisonerDto> getAllPrisoners() {
		try (Transaction tx = graphDatabase.beginTx()) {

			final List<PrisonerDto> dtos = new ArrayList<>();
			prisonerRepository.findAll().forEach(prisoner -> {
				final PrisonerDto dto = PrisonerDtoBuilder.buildFrom(prisoner).build();
				dtos.add(dto);
			});

			tx.success();

			return dtos;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addFriendship")
	public FriendshipDto addFriendship(@RequestBody FriendshipDto friends) {
		try (Transaction tx = graphDatabase.beginTx()) {

			Prisoner friend1 = prisonerRepository.findOne(friends.getFriend1().getId());
			if (friend1 == null) {
				throw new IllegalArgumentException("No prisoner with ID = " + friends.getFriend1() +
						" exists!");
			}

			Prisoner friend2 = prisonerRepository.findOne(friends.getFriend2().getId());
			if (friend2 == null) {
				throw new IllegalArgumentException("No prisoner with ID = " + friends.getFriend2() +
						" exists!");
			}

			Friendship friendship = Friendship.from(friend1, friend2);

			Friendship result = friendshipRepository.save(friendship);

			// Fetch the actual prisoners.
			Friendship ret = new Friendship(result.getId(),
					prisonerRepository.findOne(result.getFriend1().getNodeId()),
					prisonerRepository.findOne(result.getFriend2().getNodeId()));

			FriendshipDto dto = FriendshipDto.from(ret);

			tx.success();

			return dto;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findFriendsById")
	public Set<PrisonerDto> getFriends(@RequestParam("prisonerId") Long prisonerId) {
		try (Transaction tx = graphDatabase.beginTx()) {

			Set<PrisonerDto> friends = prisonerRepository.findOne(prisonerId)
					.getFriends()
					.stream()
					.map(p -> PrisonerDtoBuilder.buildFrom(p).build())
					.collect(Collectors.toSet());

			tx.success();

			return friends;

		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addEnemies")
	public EnemyshipDto addEnemyship(@RequestBody EnemyshipDto enemies) {
		try (Transaction tx = graphDatabase.beginTx()) {

			Prisoner enemy1 = prisonerRepository.findOne(enemies.getEnemy1().getId());
			if (enemy1 == null) {
				throw new IllegalArgumentException("No prisoner with ID = " + enemies.getEnemy1() +
						" exists!");
			}

			Prisoner enemy2 = prisonerRepository.findOne(enemies.getEnemy2().getId());
			if (enemy2 == null) {
				throw new IllegalArgumentException("No prisoner with ID = " + enemies.getEnemy2() +
						" exists!");
			}

			Enemyship enemyship = Enemyship.from(enemy1, enemy2);

			Enemyship result = enemyshipRepository.save(enemyship);

			// Fetch the actual prisoners.
			Enemyship ret = new Enemyship(result.getId(),
					prisonerRepository.findOne(result.getEnemy1().getNodeId()),
					prisonerRepository.findOne(result.getEnemy2().getNodeId()));

			EnemyshipDto dto = EnemyshipDto.from(ret);

			tx.success();

			return dto;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findEnemiesById")
	public Set<PrisonerDto> getEnemies(@RequestParam("prisonerId") Long prisonerId) {
		try (Transaction tx = graphDatabase.beginTx()) {

			Set<PrisonerDto> friends = prisonerRepository.findOne(prisonerId)
					.getEnemies()
					.stream()
					.map(p -> PrisonerDtoBuilder.buildFrom(p).build())
					.collect(Collectors.toSet());

			tx.success();

			return friends;

		}
	}

}
