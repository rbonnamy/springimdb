package fr.dgn.imdb.daos;

import org.springframework.stereotype.Component;

import fr.dgn.imdb.entites.Genre;

@Component
public class GenreDao extends AbstractDao<Genre, String> {

	@Override
	public void update(Genre beanDb, Genre nvBean) {
		
	}

	@Override
	public Genre findByCriteria(Genre bean) {
		return findById(Genre.class, bean.getId());
	}

}
