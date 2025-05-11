package fr.dgn.imdb.dtos;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fr.dgn.imdb.deserializers.AnneeSortieDeserializer;
import fr.dgn.imdb.deserializers.ToDoubleDeserializer;

public class FilmDto {

	private String id;
	private PaysDto pays;
	private String nom;
	private String url;
	@JsonDeserialize(using = ToDoubleDeserializer.class)
	private Double rating;
	private String plot;
	private String langue;
	@JsonDeserialize(using = AnneeSortieDeserializer.class)
	private Integer anneeSortie;
	private LieuDto lieuTournage;
	private List<PersonneDto> realisateurs;
	private Set<PersonneDto> castingPrincipal;
	private Set<RoleDto> roles;
	private Set<String> genres;
	
	@Override
	public String toString() {
		return "id=" + id + ", nom=" + nom + ", rating=" + rating + ", langue=" + langue + ", anneeSortie="
				+ anneeSortie+", lieu de tournage="+lieuTournage;
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
	 * @return the pays
	 */
	public PaysDto getPays() {
		return pays;
	}
	/** Setter
	 * @param pays the pays to set
	 */
	public void setPays(PaysDto pays) {
		this.pays = pays;
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
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}
	/** Setter
	 * @param rating the rating to set
	 */
	public void setRating(Double rating) {
		this.rating = rating;
	}
	/** Getter
	 * @return the plot
	 */
	public String getPlot() {
		return plot;
	}
	/** Setter
	 * @param plot the plot to set
	 */
	public void setPlot(String plot) {
		this.plot = plot;
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
	 * @return the lieuTournage
	 */
	public LieuDto getLieuTournage() {
		return lieuTournage;
	}
	/** Setter
	 * @param lieuTournage the lieuTournage to set
	 */
	public void setLieuTournage(LieuDto lieuTournage) {
		this.lieuTournage = lieuTournage;
	}
	/** Getter
	 * @return the realisateurs
	 */
	public List<PersonneDto> getRealisateurs() {
		return realisateurs;
	}
	/** Setter
	 * @param realisateurs the realisateurs to set
	 */
	public void setRealisateurs(List<PersonneDto> realisateurs) {
		this.realisateurs = realisateurs;
	}
	/** Getter
	 * @return the castingPrincipal
	 */
	public Set<PersonneDto> getCastingPrincipal() {
		return castingPrincipal;
	}
	/** Setter
	 * @param castingPrincipal the castingPrincipal to set
	 */
	public void setCastingPrincipal(Set<PersonneDto> castingPrincipal) {
		this.castingPrincipal = castingPrincipal;
	}
	/** Getter
	 * @return the roles
	 */
	public Set<RoleDto> getRoles() {
		return roles;
	}
	/** Setter
	 * @param roles the roles to set
	 */
	public void setRoles(Set<RoleDto> roles) {
		this.roles = roles;
	}
	/** Getter
	 * @return the genres
	 */
	public Set<String> getGenres() {
		return genres;
	}
	/** Setter
	 * @param genres the genres to set
	 */
	public void setGenres(Set<String> genres) {
		this.genres = genres;
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
	
}
