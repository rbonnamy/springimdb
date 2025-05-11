package fr.dgn.imdb.daos;

import org.springframework.stereotype.Component;

import fr.dgn.imdb.entites.Personne;
import jakarta.persistence.TypedQuery;

@Component
public class PersonneDao extends AbstractDao<Personne, String> {

	@Override
	public Personne findByCriteria(Personne bean) {
		TypedQuery<Personne> query = em.createQuery("from Personne p JOIN FETCH p.lieuNaissance l JOIN FETCH l.pays WHERE p.id=:id", Personne.class);
		query.setParameter("id", bean.getId());
		return query.getResultStream().findFirst().orElse(null);
	}
	
	@Override
	public void update(Personne beanDb, Personne nvBean) {
		beanDb.setIdentite(nvBean.getIdentite());
		beanDb.setHeight(nvBean.getHeight());
		beanDb.setDateNaissance(nvBean.getDateNaissance());
		beanDb.setLieuNaissance(nvBean.getLieuNaissance());
		beanDb.setUrl(nvBean.getUrl());	
	}

}
