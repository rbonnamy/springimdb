package fr.dgn.imdb.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "role",
indexes = {
  @Index(
    name = "idx_role_personnage",
    columnList = "personnage"
  )
}
)
public class Role implements Identifiable<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String personnage;
	
	@ManyToMany
	@JoinTable(name = "role_par_acteur",
				joinColumns= @JoinColumn(name="ID_ROLE", referencedColumnName="ID"),
				inverseJoinColumns= @JoinColumn(name="ID_ACTEUR", referencedColumnName="ID"))
	private List<Personne> acteurs = new ArrayList<>();

	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter
	 * @return the personnage
	 */
	public String getPersonnage() {
		return personnage;
	}

	/** Setter
	 * @param personnage the personnage to set
	 */
	public void setPersonnage(String personnage) {
		this.personnage = personnage;
	}

	/** Getter
	 * @return the acteurs
	 */
	public List<Personne> getActeurs() {
		return acteurs;
	}

	/** Setter
	 * @param acteurs the acteurs to set
	 */
	public void setActeurs(List<Personne> acteurs) {
		this.acteurs = acteurs;
	}
}
