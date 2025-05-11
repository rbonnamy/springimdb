package fr.dgn.imdb.daos;

import org.springframework.stereotype.Component;

import fr.dgn.imdb.entites.Genre;
import jakarta.persistence.TypedQuery;

@Component
public class GenreDao extends AbstractDao<Genre, Integer> {

	@Override
	public void update(Genre beanDb, Genre nvBean) {
		
	}

	@Override
	public Genre findByCriteria(Genre bean) {
		TypedQuery<Genre> query = em.createQuery("from Genre p WHERE p.nom=:nom", Genre.class);
		query.setParameter("nom", bean.getNom());
		return query.getResultStream().findFirst().orElse(null);
	}

}
