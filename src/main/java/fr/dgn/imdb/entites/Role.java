package fr.dgn.imdb.entites;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Role implements Identifiable<Integer> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String personnage;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "role_par_acteur",
				joinColumns= @JoinColumn(name="ID_ROLE", referencedColumnName="id"),
				inverseJoinColumns= @JoinColumn(name="ID_ACTEUR", referencedColumnName="id"))
	private Set<Personne> acteurs = new HashSet<>();
	
	
	@Override
	public String toString() {
		return "Role [personnage=" + personnage + ", acteurs=" + acteurs + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(acteurs, personnage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(acteurs, other.acteurs) && Objects.equals(personnage, other.personnage);
	}


	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
	public Set<Personne> getActeurs() {
		return acteurs;
	}

	/** Setter
	 * @param acteurs the acteurs to set
	 */
	public void setActeurs(Set<Personne> acteurs) {
		this.acteurs = acteurs;
	}
}
