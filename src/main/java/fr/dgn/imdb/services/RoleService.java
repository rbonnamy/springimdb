package fr.dgn.imdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dgn.imdb.daos.RoleDao;
import fr.dgn.imdb.dtos.RoleDto;
import fr.dgn.imdb.entites.Personne;
import fr.dgn.imdb.entites.Role;
import fr.dgn.imdb.mappers.RoleMapper;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PersonneService personneService;
	
	public Role traiter(RoleDto roleDto) {
		
		Role role = RoleMapper.toEntity(roleDto);
		Personne acteurDb = personneService.traiter(roleDto.getActeur());
		
		Role roleDb = roleDao.updateOrCreate(role);
		
		roleDb.getActeurs().add(acteurDb);
		
		return roleDb;
	}
}
