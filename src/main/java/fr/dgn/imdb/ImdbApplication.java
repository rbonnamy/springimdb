package fr.dgn.imdb;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.dgn.imdb.dtos.FilmDto;
import fr.dgn.imdb.services.FilmService;

@SpringBootApplication
public class ImdbApplication implements CommandLineRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ImdbApplication.class);
	
	@Autowired
	private FilmService filmService;

	public static void main(String[] args) {
		SpringApplication.run(ImdbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		FilmDto[] filmsDtos = mapper.readValue(new File("src/main/resources/films.json"), FilmDto[].class);
				
		int compteur = 0;
		for (FilmDto filmDto: filmsDtos) {
			LOGGER.info(++compteur+" -> " + filmDto.getNom());
			filmService.traiterFilm(filmDto);
		}
		
	}

}
