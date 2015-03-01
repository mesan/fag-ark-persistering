package no.mesan.fagark.persistering.neo4j.dto;

import no.mesan.fagark.persistering.neo4j.domain.Prisoner;

public class PrisonerDtoBuilder {

	private Long id;
	private String name;
	
	public static PrisonerDtoBuilder builder() {
		return new PrisonerDtoBuilder();
	}
	
	public static PrisonerDtoBuilder buildFrom(final Prisoner prisoner) {
		return builder()
				.id(prisoner.getNodeId())
				.name(prisoner.getName());
	}
	
	public PrisonerDto build() {
		return new PrisonerDto(id, name);
	}
	
	public PrisonerDtoBuilder id(final Long id) {
		this.id = id;
		return this;
	}
	
	public PrisonerDtoBuilder name(final String name) {
		this.name = name;
		return this;
	}
	
}
