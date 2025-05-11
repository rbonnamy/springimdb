package fr.dgn.imdb.daos;

import org.springframework.stereotype.Component;

import fr.dgn.imdb.entites.Pays;
import jakarta.persistence.TypedQuery;

@Component
public class PaysDao extends AbstractDao<Pays, String> {

	@Override
	public Pays findByCriteria(Pays bean) {
		TypedQuery<Pays> query = em.createQuery("from Pays p WHERE p.nom=:nom", Pays.class);
		query.setParameter("nom", bean.getNom());
		return query.getResultStream().findFirst().orElse(null);
	}
	
	public void update(Pays paysDb, Pays pays) {
		paysDb.setNom(pays.getNom());
		if (pays.getUrl() != null) {
			paysDb.setUrl(pays.getUrl());
		}
	}

}
