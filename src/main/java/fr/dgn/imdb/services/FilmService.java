package fr.dgn.imdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dgn.imdb.daos.FilmDao;
import fr.dgn.imdb.dtos.FilmDto;
import fr.dgn.imdb.dtos.PersonneDto;
import fr.dgn.imdb.dtos.RoleDto;
import fr.dgn.imdb.entites.Film;
import fr.dgn.imdb.entites.Genre;
import fr.dgn.imdb.entites.Personne;
import fr.dgn.imdb.entites.Role;
import fr.dgn.imdb.mappers.FilmMapper;
import fr.dgn.imdb.mappers.PersonneMapper;
import fr.dgn.imdb.mappers.RoleMapper;
import jakarta.transaction.Transactional;

@Service
public class FilmService {

	@Autowired
	private FilmDao dao;
	
	@Transactional
	public void traiterFilm(FilmDto filmDto) {
				
		Film film = FilmMapper.toEntity(filmDto);
	
		for (PersonneDto personneDto: filmDto.getCastingPrincipal()) {
			Personne personne = PersonneMapper.toEntity(personneDto);
			film.getActeurs().add(personne);
		}
		
		for (PersonneDto realisateurDto: filmDto.getRealisateurs()) {
			Personne personne = PersonneMapper.toEntity(realisateurDto);
			film.getRealisateurs().add(personne);
		}
		
		for (RoleDto roleDto : filmDto.getRoles()) {
			Role role = RoleMapper.toEntity(roleDto);
			Personne personne = PersonneMapper.toEntity(roleDto.getActeur());
			if (personne!=null) {
				role.getActeurs().add(personne);
			}
			film.getRoles().add(role);
		}
		
		for (String genreDto: filmDto.getGenres()) {
			Genre genre = new Genre(genreDto);
			film.getGenres().add(genre);
		}
		
		dao.merge(film);
	}
}
