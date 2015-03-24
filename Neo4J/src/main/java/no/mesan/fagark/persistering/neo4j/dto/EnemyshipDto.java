package no.mesan.fagark.persistering.neo4j.dto;

import no.mesan.fagark.persistering.neo4j.domain.Enemyship;

public class EnemyshipDto {

	private Long id;

	private PrisonerDto enemy1;
	private PrisonerDto enemy2;

	public EnemyshipDto() {
	}

	public EnemyshipDto(Long id, PrisonerDto enemy1, PrisonerDto enemy2) {
		this.id = id;
		this.enemy1 = enemy1;
		this.enemy2 = enemy2;
	}

	public static EnemyshipDto from(Enemyship enemyship) {

		PrisonerDto p1 = PrisonerDtoBuilder.buildFrom(enemyship.getEnemy1()).build();
		PrisonerDto p2 = PrisonerDtoBuilder.buildFrom(enemyship.getEnemy2()).build();

		return new EnemyshipDto(enemyship.getId(), p1, p2);
	}

	public Long getId() {
		return id;
	}

	public PrisonerDto getEnemy1() {
		return enemy1;
	}

	public PrisonerDto getEnemy2() {
		return enemy2;
	}

}
