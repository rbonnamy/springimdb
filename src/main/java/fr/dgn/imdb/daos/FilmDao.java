package fr.dgn.imdb.daos;

import org.springframework.stereotype.Component;

import fr.dgn.imdb.entites.Film;
import jakarta.persistence.TypedQuery;

@Component
public class FilmDao extends AbstractDao<Film, String> {

	@Override
	public Film findByCriteria(Film bean) {
		TypedQuery<Film> query = em.createQuery("SELECT DISTINCT f from Film f LEFT JOIN FETCH f.genres JOIN FETCH f.acteurs JOIN FETCH f.roles LEFT JOIN FETCH f.realisateurs WHERE f.id=:id", Film.class);
		query.setParameter("id", bean.getId());
		return query.getResultStream().findFirst().orElse(null);
	}
	
	@Override
	public void update(Film filmDb, Film film) {
		filmDb.setAnneeSortie(film.getAnneeSortie());
		filmDb.setLangue(film.getLangue());
		filmDb.setNote(film.getNote());
		filmDb.setResume(film.getResume());
		filmDb.setNom(film.getNom());
		filmDb.setPays(film.getPays());
		filmDb.setLieuTournage(film.getLieuTournage());
	}

}
