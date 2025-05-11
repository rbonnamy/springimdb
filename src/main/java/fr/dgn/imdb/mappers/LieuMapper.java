package fr.dgn.imdb.mappers;

import fr.dgn.imdb.dtos.LieuDto;
import fr.dgn.imdb.entites.Lieu;

public class LieuMapper {

	public static Lieu toEntity(String chaine) {
		Lieu lieu = new Lieu();
		
		String[] elts = chaine.split(",", -1);
		String ville = "";
		String region = "";
		String pays = "";
		
		if (elts.length==2) {
			ville = elts[0];
			pays= elts[1];
		}
		else if (elts.length==3) {
			ville = elts[0];
			region = elts[1];
			pays = elts[2];
		}
		else if (elts.length>3) {
			for (int i=0; i<elts.length-2; i++) {
				ville+=elts[i]+" ";
			}
			region = elts[elts.length-2];
			pays = elts[elts.length-1];
		}
		lieu.setVille(ville.trim());
		lieu.setRegion(region.trim());
		lieu.setPays(PaysMapper.toEntity(pays.trim()));
		return lieu;
	}

	public static Lieu toEntity(LieuDto dto) {
		if (dto==null) {
			return null;
		}
		Lieu lieu = new Lieu();
		lieu.setRegion(dto.getEtatDept().trim());
		lieu.setVille(dto.getVille().trim());
		lieu.setPays(PaysMapper.toEntity(dto.getPays().trim()));
		return lieu;
	}
}
