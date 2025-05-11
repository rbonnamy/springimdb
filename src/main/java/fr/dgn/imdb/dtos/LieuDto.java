package fr.dgn.imdb.dtos;

import java.util.Objects;

public class LieuDto {
	private String ville;
	private String etatDept;
	private String pays;
	
	@Override
	public int hashCode() {
		return Objects.hash(etatDept, pays, ville);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LieuDto other = (LieuDto) obj;
		return Objects.equals(etatDept, other.etatDept) && Objects.equals(pays, other.pays)
				&& Objects.equals(ville, other.ville);
	}
	
	/** Getter
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/** Setter
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/** Getter
	 * @return the etatDept
	 */
	public String getEtatDept() {
		return etatDept;
	}
	/** Setter
	 * @param etatDept the etatDept to set
	 */
	public void setEtatDept(String etatDept) {
		this.etatDept = etatDept;
	}
	/** Getter
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}
	/** Setter
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

}
