package no.mesan.fagark.persistering.neo4j.service;

import no.mesan.fagark.persistering.neo4j.domain.Prisoner;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrisonerController {

	@RequestMapping(method=RequestMethod.GET, value="/prisoner")
	public Prisoner getPrisoner(@RequestParam(value="name") String name) {
		return new Prisoner(name);
	}
	
}
