package no.mesan.fagark.persistering.neo4j.domain;

import no.mesan.fagark.persistering.neo4j.dto.PrisonerDto;

public class PrisonerBuilder {

	private Long nodeId;
	private String name;

	public static PrisonerBuilder builder() {
		return new PrisonerBuilder();
	}

	public static PrisonerBuilder buildFrom(final PrisonerDto prisonerDto) {
		return builder().nodeId(prisonerDto.getId())
				.name(prisonerDto.getName());
	}

	public Prisoner build() {
		return new Prisoner(nodeId, name);
	}

	public PrisonerBuilder nodeId(final Long nodeId) {
		this.nodeId = nodeId;
		return this;
	}

	public PrisonerBuilder name(final String name) {
		this.name = name;
		return this;
	}

}
