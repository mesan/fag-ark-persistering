package no.mesan.fagark.persistering.neo4j.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "HAS_ENEMY")
public class Enemyship {

	@GraphId
	Long id;

	@StartNode
	private Prisoner enemy1;
	@EndNode
	private Prisoner enemy2;

	Enemyship() {
	}

	public Enemyship(Long id, Prisoner enemy1, Prisoner enemy2) {
		this.id = id;
		this.enemy1 = enemy1;
		this.enemy2 = enemy2;
	}

	public static Enemyship from(Prisoner enemy1, Prisoner enemy2) {
		return new Enemyship(null, enemy1, enemy2);
	}

	public Long getId() {
		return id;
	}

	public Prisoner getEnemy1() {
		return enemy1;
	}

	public Prisoner getEnemy2() {
		return enemy2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enemy1 == null) ? 0 : enemy1.hashCode());
		result = prime * result + ((enemy2 == null) ? 0 : enemy2.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Enemyship other = (Enemyship) obj;
		if (enemy1 == null) {
			if (other.enemy1 != null) {
				return false;
			}
		} else if (!enemy1.equals(other.enemy1)) {
			return false;
		}
		if (enemy2 == null) {
			if (other.enemy2 != null) {
				return false;
			}
		} else if (!enemy2.equals(other.enemy2)) {
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
