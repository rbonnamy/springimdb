package fr.dgn.imdb.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Personne implements Identifiable<String> {
	
	@Id
	private String id;
	private String identite;
	private String url;
	private LocalDate dateNaissance;
	
	@ManyToOne
	@JoinColumn(name="id_lieu_naissance")
	private Lieu lieuNaissance;
	
	private String height;
	
	@ManyToMany
	@JoinTable(name = "casting_principal",
			joinColumns= @JoinColumn(name="ID_ACTEUR", referencedColumnName="ID"),
			inverseJoinColumns= @JoinColumn(name="ID_FILM", referencedColumnName="ID"))
	private List<Film> films = new ArrayList<>();

	/** Getter
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/** Getter
	 * @return the identite
	 */
	public String getIdentite() {
		return identite;
	}
	/** Setter
	 * @param identite the identite to set
	 */
	public void setIdentite(String identite) {
		this.identite = identite;
	}
	/** Getter
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/** Setter
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/** Getter
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	/** Setter
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	/** Getter
	 * @return the lieuNaissance
	 */
	public Lieu getLieuNaissance() {
		return lieuNaissance;
	}
	/** Setter
	 * @param lieuNaissance the lieuNaissance to set
	 */
	public void setLieuNaissance(Lieu lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	/** Getter
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}
	/** Setter
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}
	/** Getter
	 * @return the films
	 */
	public List<Film> getFilms() {
		return films;
	}
	/** Setter
	 * @param films the films to set
	 */
	public void setFilms(List<Film> films) {
		this.films = films;
	}
}
