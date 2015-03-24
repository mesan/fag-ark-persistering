package no.mesan.fagark.persistering.neo4j.domain;

import java.util.HashSet;
import java.util.Set;

import no.mesan.fagark.persistering.neo4j.vo.Percent;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Prisoner {

	@GraphId
	private Long nodeId;

	@Indexed(unique = true)
	private String name;

	private Percent health;
	private boolean isDangerous;
	private Percent hunger;
	private Percent thirst;
	private Percent aggression;
	private Percent sosializable;

	@Fetch
	@RelatedTo(type = "HAS_FRIEND", direction = Direction.BOTH)
	private Set<Prisoner> friends;

	@Fetch
	@RelatedTo(type = "HAS_ENEMY", direction = Direction.BOTH)
	private Set<Prisoner> enemies;

	public Prisoner() {
	}

	public Prisoner(final Long nodeId,
			final String name,
			final Percent health,
			final boolean isDangerous,
			final Percent hunger,
			final Percent thirst,
			final Percent aggression,
			final Percent sosializable) {
		this.nodeId = nodeId;
		this.name = name;

		friends = new HashSet<>();
		enemies = new HashSet<>();
	}

	public Long getNodeId() {
		return nodeId;
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

	public Set<Prisoner> getFriends() {
		return friends;
	}

	public Set<Prisoner> getEnemies() {
		return enemies;
	}

	@Override
	public String toString() {
		return "Prisoner [nodeId=" + nodeId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Prisoner other = (Prisoner) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (nodeId == null) {
			if (other.nodeId != null) {
				return false;
			}
		} else if (!nodeId.equals(other.nodeId)) {
			return false;
		}
		return true;
	}

}
