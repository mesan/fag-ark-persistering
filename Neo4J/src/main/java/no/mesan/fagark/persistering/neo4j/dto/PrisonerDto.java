package no.mesan.fagark.persistering.neo4j.dto;

public class PrisonerDto {

	private Long id;
	private String name;

	public PrisonerDto() {
	}

	public PrisonerDto(final Long id, final String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
