package fr.dgn.imdb.entites;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Film implements Identifiable<String> {

	@Id
	private String id;
	
	private String nom;
	
	@Column(name="annee_sortie")
	private Integer anneeSortie;
	
	@Column(length = 9000)
	private String resume;
	
	private Double note;
	
	private String langue;
	
	@ManyToOne
	@JoinColumn(name="id_lieu_tournage")
	private Lieu lieuTournage;
	
	@ManyToOne
	@JoinColumn(name="id_pays_origine")
	private Pays pays;
	
	@ManyToMany
	@JoinTable(name = "casting_principal",
			joinColumns= @JoinColumn(name="ID_FILM", referencedColumnName="ID"),
			inverseJoinColumns= @JoinColumn(name="ID_ACTEUR", referencedColumnName="ID"))
	private Set<Personne> acteurs = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "genre_par_film",
			joinColumns= @JoinColumn(name="ID_FILM", referencedColumnName="ID"),
			inverseJoinColumns= @JoinColumn(name="ID_GENRE", referencedColumnName="ID"))
	private Set<Genre> genres = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "role_par_film",
			joinColumns= @JoinColumn(name="ID_FILM", referencedColumnName="ID"),
			inverseJoinColumns= @JoinColumn(name="ID_ROLE", referencedColumnName="ID"))
	private Set<Role> roles = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "realisateur_par_film",
			joinColumns= @JoinColumn(name="ID_FILM", referencedColumnName="ID"),
			inverseJoinColumns= @JoinColumn(name="ID_REALISATEUR", referencedColumnName="ID"))
	private Set<Personne> realisateurs = new HashSet<>();

	@Override
	public int hashCode() {
		return Objects.hash(anneeSortie, id, langue, nom, note, resume);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(anneeSortie, other.anneeSortie) && Objects.equals(id, other.id)
				&& Objects.equals(langue, other.langue) && Objects.equals(nom, other.nom)
				&& Objects.equals(note, other.note) && Objects.equals(resume, other.resume) 
				&& Objects.equals(lieuTournage, other.lieuTournage) && Objects.equals(pays, other.pays);
	}

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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the anneeSortie
	 */
	public Integer getAnneeSortie() {
		return anneeSortie;
	}

	/** Setter
	 * @param anneeSortie the anneeSortie to set
	 */
	public void setAnneeSortie(Integer anneeSortie) {
		this.anneeSortie = anneeSortie;
	}

	/** Getter
	 * @return the resume
	 */
	public String getResume() {
		return resume;
	}

	/** Setter
	 * @param resume the resume to set
	 */
	public void setResume(String resume) {
		this.resume = resume;
	}

	/** Getter
	 * @return the note
	 */
	public Double getNote() {
		return note;
	}

	/** Setter
	 * @param note the note to set
	 */
	public void setNote(Double note) {
		this.note = note;
	}

	/** Getter
	 * @return the langue
	 */
	public String getLangue() {
		return langue;
	}

	/** Setter
	 * @param langue the langue to set
	 */
	public void setLangue(String langue) {
		this.langue = langue;
	}

	/** Getter
	 * @return the pays
	 */
	public Pays getPays() {
		return pays;
	}

	/** Setter
	 * @param pays the pays to set
	 */
	public void setPays(Pays pays) {
		this.pays = pays;
	}

	/** Getter
	 * @return the lieuTournage
	 */
	public Lieu getLieuTournage() {
		return lieuTournage;
	}

	/** Setter
	 * @param lieuTournage the lieuTournage to set
	 */
	public void setLieuTournage(Lieu lieuTournage) {
		this.lieuTournage = lieuTournage;
	}

	/** Getter
	 * @return the acteurs
	 */
	public Set<Personne> getActeurs() {
		return acteurs;
	}

	/** Setter
	 * @param acteurs the acteurs to set
	 */
	public void setActeurs(Set<Personne> acteurs) {
		this.acteurs = acteurs;
	}

	/** Getter
	 * @return the genres
	 */
	public Set<Genre> getGenres() {
		return genres;
	}

	/** Setter
	 * @param genres the genres to set
	 */
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	/** Getter
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/** Setter
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/** Getter
	 * @return the realisateurs
	 */
	public Set<Personne> getRealisateurs() {
		return realisateurs;
	}

	/** Setter
	 * @param realisateurs the realisateurs to set
	 */
	public void setRealisateurs(Set<Personne> realisateurs) {
		this.realisateurs = realisateurs;
	}

	
}
