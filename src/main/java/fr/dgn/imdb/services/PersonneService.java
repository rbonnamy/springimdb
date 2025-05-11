package fr.dgn.imdb.services;

import fr.dgn.imdb.daos.PersonneDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dgn.imdb.daos.LieuDao;
import fr.dgn.imdb.daos.PaysDao;
import fr.dgn.imdb.dtos.PersonneDto;
import fr.dgn.imdb.entites.Lieu;
import fr.dgn.imdb.entites.Pays;
import fr.dgn.imdb.entites.Personne;
import fr.dgn.imdb.mappers.PersonneMapper;

@Service
public class PersonneService {

	@Autowired
	private LieuDao lieuDao;
	@Autowired
	private PaysDao paysDao;
	@Autowired
	private PersonneDao acteurDao;
	
	public Personne traiter(PersonneDto acteurDto) {
		
		Personne personne = PersonneMapper.toEntity(acteurDto);

		if (personne.getLieuNaissance()!=null) {
			if (personne.getLieuNaissance().getPays()!=null) {
				Pays paysDb = paysDao.updateOrCreate(personne.getLieuNaissance().getPays());
				personne.getLieuNaissance().setPays(paysDb);
			}
			Lieu lieuNaissanceDb = lieuDao.updateOrCreate(personne.getLieuNaissance());
			personne.setLieuNaissance(lieuNaissanceDb);
		}
		
		return acteurDao.updateOrCreate(personne);
	}
}
