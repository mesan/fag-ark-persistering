package no.mesan.fagark.persistering.neo4j.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "HAS_FRIEND")
public class Friendship {

	@GraphId
	Long id;

	@StartNode
	private Prisoner friend1;
	@EndNode
	private Prisoner friend2;

	Friendship() {
	}

	public Friendship(Long id, Prisoner f1, Prisoner f2) {
		this.id = id;
		friend1 = f1;
		friend2 = f2;
	}
	
	public static Friendship from(Prisoner f1, Prisoner f2) {
		return new Friendship(null, f1, f2);
	}

	public Long getId() {
		return id;
	}

	public Prisoner getFriend1() {
		return friend1;
	}

	public Prisoner getFriend2() {
		return friend2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friend1 == null) ? 0 : friend1.hashCode());
		result = prime * result + ((friend2 == null) ? 0 : friend2.hashCode());
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
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
		Friendship other = (Friendship) obj;
		if (friend1 == null) {
			if (other.friend1 != null) {
				return false;
			}
		} else if (!friend1.equals(other.friend1)) {
			return false;
		}
		if (friend2 == null) {
			if (other.friend2 != null) {
				return false;
			}
		} else if (!friend2.equals(other.friend2)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
