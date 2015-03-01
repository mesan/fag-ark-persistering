package no.mesan.fagark.persistering.neo4j.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Prisoner {

	@GraphId
	private Long nodeId;

	private String name;

	/*
	 * @RelatedTo(type = "FRIEND", direction = Direction.OUTGOING) private
	 * 
	 * @Fetch Set<Prisoner> friends;
	 * 
	 * @RelatedTo(type = "ENEMY", direction = Direction.BOTH) private @Fetch
	 * Set<Prisoner> enemies;
	 */

	public Prisoner() {
	}

	public Prisoner(final Long nodeId, final String name) {
		this.nodeId = nodeId;
		this.name = name;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public String getName() {
		return name;
	}

	/*
	 * public void addFriend(Prisoner friend) { if (friends == null) { friends =
	 * new HashSet<Prisoner>(); } friends.add(friend); }
	 * 
	 * public void removeFriend(Prisoner prisoner) { if (friends != null) {
	 * friends.remove(prisoner); } }
	 * 
	 * public void addEnemy(Prisoner enemy) { if (enemies == null) { enemies =
	 * new HashSet<Prisoner>(); } enemies.add(enemy); }
	 * 
	 * public void removeEnemy(Prisoner prisoner) { if (enemies != null) {
	 * enemies.remove(prisoner); } }
	 * 
	 * public boolean isFriend(Prisoner prisoner) { return
	 * friends.contains(prisoner); }
	 * 
	 * public boolean isEnemy(Prisoner prisoner) { return
	 * enemies.contains(prisoner); }
	 */

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
