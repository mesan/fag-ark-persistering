package no.mesan.fagark.persistering.neo4j.dto;

import java.util.Set;

public class PrisonerDto {

	private Long id;
	private String name;

	private Set<Long> friends;
	private Set<Long> enemies;

	private Integer health;
	private boolean isDangerous;
	private Integer hunger;
	private Integer thirst;
	private Integer aggression;
	private Integer sosializable;

	public PrisonerDto() {
	}

	public PrisonerDto(final Long id,
			final String name,
			final Integer health,
			final boolean isDangerous,
			final Integer hunger,
			final Integer thirst,
			final Integer aggression,
			final Integer sosializable,
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

	public Integer getHealth() {
		return health;
	}

	public boolean isDangerous() {
		return isDangerous;
	}

	public Integer getHunger() {
		return hunger;
	}

	public Integer getThirst() {
		return thirst;
	}

	public Integer getAggression() {
		return aggression;
	}

	public Integer getSosializable() {
		return sosializable;
	}

	public Set<Long> getFriends() {
		return friends;
	}

	public Set<Long> getEnemies() {
		return enemies;
	}

}
