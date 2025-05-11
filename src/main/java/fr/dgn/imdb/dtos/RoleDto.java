package fr.dgn.imdb.dtos;

public class RoleDto {
	
	private String characterName;
	private PersonneDto acteur;
	
	
	
	@Override
	public String toString() {
		return "personnage=" + characterName + ", acteur=" + acteur.getIdentite();
	}
	/** Getter
	 * @return the characterName
	 */
	public String getCharacterName() {
		return characterName;
	}
	/** Setter
	 * @param characterName the characterName to set
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	/** Getter
	 * @return the acteur
	 */
	public PersonneDto getActeur() {
		return acteur;
	}
	/** Setter
	 * @param acteur the acteur to set
	 */
	public void setActeur(PersonneDto acteur) {
		this.acteur = acteur;
	}
	
}
