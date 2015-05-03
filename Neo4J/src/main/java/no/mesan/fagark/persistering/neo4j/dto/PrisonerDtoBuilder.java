package no.mesan.fagark.persistering.neo4j.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import no.mesan.fagark.persistering.neo4j.domain.Prisoner;

public class PrisonerDtoBuilder {

	private Long id;
	private String name;

	private Integer health;
	private boolean isDangerous;
	private Integer hunger;
	private Integer thirst;
	private Integer aggression;
	private Integer sosializable;

	Set<Long> friendIds;
	Set<Long> enemyIds;

	public static PrisonerDtoBuilder builder() {
		return new PrisonerDtoBuilder();
	}

	public static PrisonerDtoBuilder buildFrom(final Prisoner prisoner) {

		final Set<Prisoner> friends = prisoner.getFriends();
		final Set<Prisoner> enemies = prisoner.getEnemies();

		Set<Long> fIds = new HashSet<>();
		if (friends != null) {
			fIds.addAll(prisoner.getFriends()
					.stream()
					.map(Prisoner::getNodeId)
					.collect(Collectors.toSet()));

		}

		Set<Long> eIds = new HashSet<>();
		if (enemies != null) {
			eIds.addAll(prisoner.getFriends()
					.stream()
					.map(Prisoner::getNodeId)
					.collect(Collectors.toSet()));

		}

		return builder().id(prisoner.getNodeId())
				.name(prisoner.getName())
				.health(prisoner.getHealth())
				.isDangerous(prisoner.isDangerous())
				.hunger(prisoner.getHunger())
				.thirst(prisoner.getThirst())
				.aggression(prisoner.getAggression())
				.sosializable(prisoner.getSosializable())
				.friends(fIds)
				.enemies(eIds);
	}

	public PrisonerDto build() {
		if (friendIds == null) {
			friendIds = new HashSet<>();
		}

		if (enemyIds == null) {
			enemyIds = new HashSet<>();
		}

		return new PrisonerDto(id,
				name,
				health,
				isDangerous,
				hunger,
				thirst,
				aggression,
				sosializable,
				friendIds,
				enemyIds);
	}

	public PrisonerDtoBuilder id(final Long id) {
		this.id = id;
		return this;
	}

	public PrisonerDtoBuilder name(final String name) {
		this.name = name;
		return this;
	}

	public PrisonerDtoBuilder health(final Integer health) {
		this.health = health;
		return this;
	}

	public PrisonerDtoBuilder isDangerous(final Boolean isDangerous) {
		this.isDangerous = isDangerous;
		return this;
	}

	public PrisonerDtoBuilder hunger(final Integer hunger) {
		this.hunger = hunger;
		return this;
	}

	public PrisonerDtoBuilder thirst(final Integer thirst) {
		this.thirst = thirst;
		return this;
	}

	public PrisonerDtoBuilder aggression(final Integer aggression) {
		this.aggression = aggression;
		return this;
	}

	public PrisonerDtoBuilder sosializable(final Integer sosializable) {
		this.sosializable = sosializable;
		return this;
	}

	public PrisonerDtoBuilder friends(final Set<Long> friends) {
		this.friendIds = friends;
		return this;
	}

	public PrisonerDtoBuilder enemies(final Set<Long> enemies) {
		this.enemyIds = enemies;
		return this;
	}

}
