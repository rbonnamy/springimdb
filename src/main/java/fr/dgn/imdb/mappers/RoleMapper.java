package fr.dgn.imdb.mappers;

import fr.dgn.imdb.dtos.RoleDto;
import fr.dgn.imdb.entites.Role;

public class RoleMapper {

	public static Role toEntity(RoleDto dto) {
		
		Role bean = new Role();
		bean.setPersonnage(dto.getCharacterName());
		return bean;
	}
}
