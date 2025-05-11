package fr.dgn.imdb.dtos;

import java.util.Objects;

public class PersonneDto {

	private String id;
	private String identite;
	private String url;
	private NaissanceDto naissance;
	private String height;
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonneDto other = (PersonneDto) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "id=" + id + ", identite=" + identite + ", " + naissance + ", height=" + height;
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
	 * @return the naissance
	 */
	public NaissanceDto getNaissance() {
		return naissance;
	}
	/** Setter
	 * @param naissance the naissance to set
	 */
	public void setNaissance(NaissanceDto naissance) {
		this.naissance = naissance;
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
}
