package no.mesan.fagark.persistering.neo4j.dto;

import java.util.Set;

import no.mesan.fagark.persistering.neo4j.vo.Percent;

public class PrisonerDto {

	private Long id;
	private String name;

	private Set<Long> friends;
	private Set<Long> enemies;

	private Percent health;
	private boolean isDangerous;
	private Percent hunger;
	private Percent thirst;
	private Percent aggression;
	private Percent sosializable;

	public PrisonerDto() {
	}

	public PrisonerDto(final Long id,
			final String name,
			final Percent health,
			final boolean isDangerous,
			final Percent hunger,
			final Percent thirst,
			final Percent aggression,
			final Percent sosializable,
			final Set<Long> friends,
			final Set<Long> enemies) {
		this.id = id;
		this.name = name;

		this.health = health;
		this.isDangerous = isDangerous;
		this.hunger = hunger;
		this.thirst = thirst;
		this.aggression = aggression;
		this.sosializable = sosializable;

		this.friends = friends;
		this.enemies = enemies;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Percent getHealth() {
		return health;
	}

	public boolean isDangerous() {
		return isDangerous;
	}

	public Percent getHunger() {
		return hunger;
	}

	public Percent getThirst() {
		return thirst;
	}

	public Percent getAggression() {
		return aggression;
	}

	public Percent getSosializable() {
		return sosializable;
	}

	public Set<Long> getFriends() {
		return friends;
	}

	public Set<Long> getEnemies() {
		return enemies;
	}

}
