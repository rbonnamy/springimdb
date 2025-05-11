package fr.dgn.imdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dgn.imdb.daos.FilmDao;
import fr.dgn.imdb.daos.GenreDao;
import fr.dgn.imdb.daos.LieuDao;
import fr.dgn.imdb.daos.PaysDao;
import fr.dgn.imdb.dtos.FilmDto;
import fr.dgn.imdb.dtos.PersonneDto;
import fr.dgn.imdb.dtos.RoleDto;
import fr.dgn.imdb.entites.Film;
import fr.dgn.imdb.entites.Genre;
import fr.dgn.imdb.entites.Lieu;
import fr.dgn.imdb.entites.Pays;
import fr.dgn.imdb.entites.Personne;
import fr.dgn.imdb.entites.Role;
import fr.dgn.imdb.mappers.FilmMapper;
import jakarta.transaction.Transactional;

@Service
public class FilmService {

	@Autowired
	private FilmDao dao;
	@Autowired
	private LieuDao lieuDao;
	@Autowired
	private PaysDao paysDao;
	@Autowired
	private GenreDao genreDao;
	@Autowired
	private PersonneService personneService;
	@Autowired
	private RoleService roleService;
	
	@Transactional
	public void traiterFilm(FilmDto filmDto) {
				
		Film film = FilmMapper.toEntity(filmDto);

		if (film.getPays()!=null) {
			Pays paysDb = paysDao.updateOrCreate(film.getPays());
			film.setPays(paysDb);
		}
		
		if (film.getLieuTournage()!=null) {
			Pays paysDb = paysDao.updateOrCreate(film.getLieuTournage().getPays());
			film.getLieuTournage().setPays(paysDb);
			Lieu lieuDb = lieuDao.updateOrCreate(film.getLieuTournage());
			film.setLieuTournage(lieuDb);
		}
		dao.updateOrCreate(film);
		
		for (PersonneDto personneDto: filmDto.getCastingPrincipal()) {
			Personne personneDb = personneService.traiter(personneDto);
			film.getActeurs().add(personneDb);
		}
		
		for (PersonneDto realisateurDto: filmDto.getRealisateurs()) {
			Personne realisateurDb = personneService.traiter(realisateurDto);
			film.getRealisateurs().add(realisateurDb);
		}
		
		for (RoleDto roleDto : filmDto.getRoles()) {
			Role role = roleService.traiter(roleDto);
			film.getRoles().add(role);
		}
		
		for (String genreDto: filmDto.getGenres()) {
			Genre genre = new Genre(genreDto);
			Genre genreDb = genreDao.updateOrCreate(genre);
			film.getGenres().add(genreDb);
		}
	}
}
