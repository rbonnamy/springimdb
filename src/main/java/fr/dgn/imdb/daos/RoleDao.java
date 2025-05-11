package fr.dgn.imdb.daos;

import org.springframework.stereotype.Component;

import fr.dgn.imdb.entites.Role;
import jakarta.persistence.TypedQuery;

@Component
public class RoleDao extends AbstractDao<Role, Integer> {
	
	@Override
	public Role findByCriteria(Role bean) {
		TypedQuery<Role> query = em.createQuery("from Role r JOIN FETCH r.acteurs WHERE r.personnage=:personnage", Role.class);
		query.setParameter("personnage", bean.getPersonnage());
		return query.getResultStream().findFirst().orElse(null);
	}
	
	public void update(Role roleDb, Role role) {
	}

}
