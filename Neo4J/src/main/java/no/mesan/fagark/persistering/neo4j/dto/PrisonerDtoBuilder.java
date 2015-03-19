package no.mesan.fagark.persistering.neo4j.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import no.mesan.fagark.persistering.neo4j.domain.Prisoner;

public class PrisonerDtoBuilder {

	private Long id;
	private String name;

	Set<Long> friendIds;

	public static PrisonerDtoBuilder builder() {
		return new PrisonerDtoBuilder();
	}

	public static PrisonerDtoBuilder buildFrom(final Prisoner prisoner) {

		Set<Prisoner> friends = prisoner.getFriends();

		Set<Long> friendsIds = new HashSet<>();
		if (friends != null) {
			friendsIds.addAll(prisoner.getFriends()
									.stream()
									.map(Prisoner::getNodeId)
									.collect(Collectors.toSet()));

		}

		return builder().id(prisoner.getNodeId())
						.name(prisoner.getName())
						.friends(friendsIds);
	}

	public PrisonerDto build() {
		if (friendIds.isEmpty()) {
			friendIds = new HashSet<>();
		}

		return new PrisonerDto(id, name, friendIds);
	}

	public PrisonerDtoBuilder id(final Long id) {
		this.id = id;
		return this;
	}

	public PrisonerDtoBuilder name(final String name) {
		this.name = name;
		return this;
	}

	public PrisonerDtoBuilder friends(final Set<Long> friends) {
		this.friendIds = friends;
		return this;
	}

}
