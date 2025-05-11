package fr.dgn.imdb.entites;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lieu",
indexes = {
  @Index(
    name = "idx_lieu_ville_etat_pays",
    columnList = "ville,region,id_pays"
  )
}
)
public class Lieu implements Identifiable<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String ville;
	
	private String region;
	
	@ManyToOne
	@JoinColumn(name="id_pays")
	private Pays pays;
	
	@Override
	public int hashCode() {
		return Objects.hash(pays, region, ville);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lieu other = (Lieu) obj;
		return Objects.equals(pays, other.pays) && Objects.equals(region, other.region)
				&& Objects.equals(ville, other.ville);
	}

	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/** Setter
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
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
	
	
}
