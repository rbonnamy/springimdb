package fr.dgn.imdb.mappers;

import java.util.HashMap;
import java.util.Map;

import fr.dgn.imdb.dtos.PaysDto;
import fr.dgn.imdb.entites.Pays;

public class PaysMapper {
	
	static Map<String, Pays> cache = new HashMap<>();

	public static Pays toEntity(PaysDto dto) {
		if (dto==null) {
			return null;
		}
		if (cache.get(dto.getNom().trim())!=null) {
			return cache.get(dto.getNom().trim());
		}
		Pays bean = new Pays();
		bean.setNom(dto.getNom().trim());
		bean.setUrl(dto.getUrl().trim());
		cache.put(dto.getNom().trim(), bean);
		return bean;
	}
	
	public static Pays toEntity(String nom) {
		if (nom==null) {
			return null;
		}
		if (cache.get(nom.trim())!=null) {
			return cache.get(nom.trim());
		}
		Pays bean = new Pays();
		bean.setNom(nom.trim());
		cache.put(nom.trim(), bean);
		return bean;
	}


}
