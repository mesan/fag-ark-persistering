package no.mesan.fagark.persistering.neo4j.domain;

import no.mesan.fagark.persistering.neo4j.dto.PrisonerDto;

public class PrisonerBuilder {

	private Long nodeId;
	private String name;

	private Integer health;
	private boolean isDangerous;
	private Integer hunger;
	private Integer thirst;
	private Integer aggression;
	private Integer sosializable;

	public static PrisonerBuilder builder() {
		return new PrisonerBuilder();
	}

	public static PrisonerBuilder buildFrom(final PrisonerDto prisonerDto) {
		return builder().nodeId(prisonerDto.getId())
				.name(prisonerDto.getName())
				.health(prisonerDto.getHealth())
				.isDangerous(prisonerDto.isDangerous())
				.hunger(prisonerDto.getHunger())
				.thirst(prisonerDto.getThirst())
				.aggression(prisonerDto.getAggression())
				.sosializable(prisonerDto.getSosializable());
	}

	public Prisoner build() {
		return new Prisoner(nodeId,
				name,
				health,
				isDangerous,
				hunger,
				thirst,
				aggression,
				sosializable);
	}

	public PrisonerBuilder nodeId(final Long nodeId) {
		this.nodeId = nodeId;
		return this;
	}

	public PrisonerBuilder name(final String name) {
		this.name = name;
		return this;
	}

	public PrisonerBuilder health(final Integer health) {
		this.health = health;
		return this;
	}

	public PrisonerBuilder isDangerous(final boolean isDangerous) {
		this.isDangerous = isDangerous;
		return this;
	}

	public PrisonerBuilder hunger(final Integer hunger) {
		this.hunger = hunger;
		return this;
	}

	public PrisonerBuilder thirst(final Integer thirst) {
		this.thirst = thirst;
		return this;
	}

	public PrisonerBuilder aggression(final Integer aggression) {
		this.aggression = aggression;
		return this;
	}

	public PrisonerBuilder sosializable(final Integer sosializable) {
		this.sosializable = sosializable;
		return this;
	}

}
