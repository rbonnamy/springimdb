package fr.dgn.imdb.daos;

import org.springframework.stereotype.Component;

import fr.dgn.imdb.entites.Lieu;
import jakarta.persistence.TypedQuery;

@Component
public class LieuDao extends AbstractDao<Lieu, Integer> {

	public void update(Lieu lieuDb, Lieu lieu) {
		lieuDb.setVille(lieu.getVille());
		lieuDb.setPays(lieu.getPays());
		lieuDb.setRegion(lieu.getRegion());
	}

	@Override
	public Lieu findByCriteria(Lieu bean) {
		TypedQuery<Lieu> query = em.createQuery("from Lieu p JOIN FETCH p.pays WHERE p.ville=:ville AND p.region=:region AND p.pays=:pays", Lieu.class);
		query.setParameter("ville", bean.getVille());
		query.setParameter("region", bean.getRegion());
		query.setParameter("pays", bean.getPays());
		return query.getResultStream().findFirst().orElse(null);
	}

}
