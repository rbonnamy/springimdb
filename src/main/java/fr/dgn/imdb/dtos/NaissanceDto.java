package fr.dgn.imdb.dtos;

public class NaissanceDto {

	private String dateNaissance;
	private String lieuNaissance;
	
	@Override
	public String toString() {
		return "dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance;
	}
	/** Getter
	 * @return the dateNaissance
	 */
	public String getDateNaissance() {
		return dateNaissance;
	}
	/** Setter
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	/** Getter
	 * @return the lieuNaissance
	 */
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	/** Setter
	 * @param lieuNaissance the lieuNaissance to set
	 */
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	
}
