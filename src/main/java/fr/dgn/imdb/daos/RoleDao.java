package fr.dgn.imdb.daos;

import org.springframework.stereotype.Component;

import fr.dgn.imdb.entites.Role;

@Component
public class RoleDao extends AbstractDao<Role, Integer> {
	
	@Override
	public Role findByCriteria(Role bean) {
		
		return findById(Role.class, bean.getId());
	}
	
	public void update(Role roleDb, Role role) {
	}

}
