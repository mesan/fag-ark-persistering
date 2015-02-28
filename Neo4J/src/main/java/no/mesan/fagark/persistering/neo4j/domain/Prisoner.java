package no.mesan.fagark.persistering.neo4j.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Prisoner {

	@GraphId
	private Long nodeId;
	
	private final String name;

	public Prisoner(String name) {
		this.name = name;
	}
	
	public Long getNodeId() {
		return nodeId;
	}

	public String getName() {
		return name;
	}

}
