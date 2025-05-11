package fr.dgn.imdb.mappers;

import fr.dgn.imdb.dtos.PersonneDto;
import fr.dgn.imdb.entites.Personne;
import fr.dgn.imdb.utils.DateUtils;

public class PersonneMapper {

	public static Personne toEntity(PersonneDto dto) {
		
		Personne bean = new Personne();
		bean.setId(dto.getId());
		bean.setIdentite(dto.getIdentite());
		if (dto.getNaissance()!=null) {
			bean.setLieuNaissance(LieuMapper.toEntity(dto.getNaissance().getLieuNaissance()));
			bean.setDateNaissance(DateUtils.parse(dto.getNaissance().getDateNaissance().trim()));
		}
		bean.setHeight(dto.getHeight());
		bean.setUrl(dto.getUrl());
		return bean;
	}
}
