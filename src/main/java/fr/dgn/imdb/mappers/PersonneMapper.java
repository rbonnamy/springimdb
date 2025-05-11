package fr.dgn.imdb.mappers;

import java.util.HashMap;
import java.util.Map;

import fr.dgn.imdb.dtos.PersonneDto;
import fr.dgn.imdb.entites.Personne;
import fr.dgn.imdb.utils.DateUtils;

public class PersonneMapper {

	static Map<String, Personne> cachePersonnes = new HashMap<>();
	
	public static Personne toEntity(PersonneDto dto) {
		
		if (cachePersonnes.get(dto.getId())!=null) {
			return cachePersonnes.get(dto.getId());
		}
		
		Personne bean = new Personne();
		bean.setId(dto.getId());
		bean.setIdentite(dto.getIdentite());
		if (dto.getNaissance()!=null) {
			bean.setLieuNaissance(LieuMapper.toEntity(dto.getNaissance().getLieuNaissance()));
			bean.setDateNaissance(DateUtils.parse(dto.getNaissance().getDateNaissance().trim()));
		}
		bean.setHeight(dto.getHeight());
		bean.setUrl(dto.getUrl());
		
		cachePersonnes.put(dto.getId(), bean);
		
		return bean;
	}
}
