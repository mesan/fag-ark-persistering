package no.mesan.fagark.persistering.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;

@SpringBootApplication
public class PrisonerRepo {

	@Configuration
	@EnableNeo4jRepositories(basePackages = "no.mesan.fagark.persistering.neo4j")
	static class ApplicationConfig extends Neo4jConfiguration {

		public ApplicationConfig() {
			setBasePackage("no.mesan.fagark.persistering.neo4j");
		}

		@Bean
		GraphDatabaseService graphDatabaseService() {
	        return new SpringRestGraphDatabase("http://docker0:7474/db/data/");
		}
	}

	public static void main(String[] args) throws Exception {

		SpringApplication.run(PrisonerRepo.class, args);

	}

}
