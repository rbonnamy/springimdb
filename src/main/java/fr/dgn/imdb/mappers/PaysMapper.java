package fr.dgn.imdb.mappers;

import fr.dgn.imdb.dtos.PaysDto;
import fr.dgn.imdb.entites.Pays;

public class PaysMapper {

	public static Pays toEntity(PaysDto dto) {
		if (dto==null) {
			return null;
		}
		Pays bean = new Pays();
		bean.setNom(dto.getNom().trim());
		bean.setUrl(dto.getUrl().trim());
		return bean;
	}

}
