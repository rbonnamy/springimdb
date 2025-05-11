package fr.dgn.imdb.mappers;

import fr.dgn.imdb.dtos.FilmDto;
import fr.dgn.imdb.entites.Film;

public class FilmMapper {

	public static Film toEntity(FilmDto dto) {
		Film film = new Film();
		film.setId(dto.getId());
		film.setNom(dto.getNom().trim());
		film.setAnneeSortie(dto.getAnneeSortie());
		if (dto.getPlot()!=null) {
			film.setResume(dto.getPlot().trim());
		}
		if (dto.getLangue()!=null) {
			film.setLangue(dto.getLangue().trim());
		}
		film.setNote(dto.getRating());
		film.setPays(PaysMapper.toEntity(dto.getPays()));
		film.setLieuTournage(LieuMapper.toEntity(dto.getLieuTournage()));
		return film;
	}

}
