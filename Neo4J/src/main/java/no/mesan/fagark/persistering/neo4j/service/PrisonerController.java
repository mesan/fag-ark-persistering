package no.mesan.fagark.persistering.neo4j.service;

import java.util.ArrayList;
import java.util.List;

import no.mesan.fagark.persistering.neo4j.domain.Prisoner;
import no.mesan.fagark.persistering.neo4j.domain.PrisonerBuilder;
import no.mesan.fagark.persistering.neo4j.dto.PrisonerDto;
import no.mesan.fagark.persistering.neo4j.dto.PrisonerDtoBuilder;
import no.mesan.fagark.persistering.neo4j.repository.PrisonerRepository;

import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/prisoner")
public class PrisonerController {

	@Autowired
	PrisonerRepository prisonerRepository;

	@Autowired
	GraphDatabase graphDatabase;

	@RequestMapping(method = RequestMethod.POST, value = "/insert")
	public PrisonerDto insertPrisoner(@RequestBody PrisonerDto prisoner) {

		if (prisoner.getName() == null) {
			throw new IllegalArgumentException("Prisoner must have a name.");
		}

		try (Transaction tx = graphDatabase.beginTx()) {
			final Prisoner toInsert = PrisonerBuilder.buildFrom(prisoner)
					.build();

			final Prisoner saved = prisonerRepository.save(toInsert);

			if (saved == null) {
				return null;
			}

			tx.success();

			final PrisonerDto dto = PrisonerDtoBuilder.buildFrom(saved).build();

			return dto;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findById")
	public PrisonerDto getPrisonerByNodeId(@RequestParam("nodeId") Long nodeId) {
		try (Transaction tx = graphDatabase.beginTx()) {
			final Prisoner result = prisonerRepository.findOne(nodeId);

			if (result == null) {
				return null;
			}

			tx.success();

			final PrisonerDto dto = PrisonerDtoBuilder.buildFrom(result)
					.build();

			return dto;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findByName")
	public PrisonerDto getPrisonerByName(@RequestParam("name") String name) {
		try (Transaction tx = graphDatabase.beginTx()) {
			final Prisoner result = prisonerRepository.findByName(name);

			if (result == null) {
				return null;
			}

			tx.success();

			PrisonerDto dto = PrisonerDtoBuilder.buildFrom(result).build();

			return dto;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findAll")
	public List<PrisonerDto> getAllPrisoners() {
		try (Transaction tx = graphDatabase.beginTx()) {
			final List<PrisonerDto> dtos = new ArrayList<PrisonerDto>();

			prisonerRepository.findAll().forEach(
					prisoner -> {
						final PrisonerDto dto = PrisonerDtoBuilder.buildFrom(
								prisoner).build();
						dtos.add(dto);
					});

			tx.success();

			return dtos;
		}
	}

}
