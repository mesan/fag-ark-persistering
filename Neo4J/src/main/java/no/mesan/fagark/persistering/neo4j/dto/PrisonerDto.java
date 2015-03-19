package no.mesan.fagark.persistering.neo4j.dto;

import java.util.Set;


public class PrisonerDto {

	private Long id;
	private String name;

	private Set<Long> friends;
	//private Set<Prisoner> enemies;

	public PrisonerDto() {
	}

	public PrisonerDto(final Long id, final String name, final Set<Long> friends) {
		this.id = id;
		this.name = name;
		
		this.friends = friends;
		//enemies = new HashSet<>();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public Set<Long> getFriends() {
		return friends;
	}
	
	/*public Set<Prisoner> getEnemies() {
		return enemies;
	}*/

}
