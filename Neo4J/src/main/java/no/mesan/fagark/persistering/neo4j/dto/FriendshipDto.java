package no.mesan.fagark.persistering.neo4j.dto;

import no.mesan.fagark.persistering.neo4j.domain.Friendship;

public class FriendshipDto {

	private Long id;

	private PrisonerDto friend1;
	private PrisonerDto friend2;

	public FriendshipDto() {
	}

	public FriendshipDto(Long id, PrisonerDto friend1, PrisonerDto friend2) {
		this.id = id;
		this.friend1 = friend1;
		this.friend2 = friend2;
	}

	public static FriendshipDto from(Friendship friendship) {

		PrisonerDto p1 = PrisonerDtoBuilder.buildFrom(friendship.getFriend1()).build();
		PrisonerDto p2 = PrisonerDtoBuilder.buildFrom(friendship.getFriend2()).build();

		return new FriendshipDto(friendship.getId(), p1, p2);
	}

	public Long getId() {
		return id;
	}

	public PrisonerDto getFriend1() {
		return friend1;
	}

	public PrisonerDto getFriend2() {
		return friend2;
	}

}
