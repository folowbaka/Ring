package sort;
import capacite.*;
import combattant.Combattant;

/**
 * 
 *SortilegeOffensif représente tous les sortilèges offensifs du jeu.Elle hérite de Sort.
 *
 */
public class SortilegeOffensif extends Sort{
    
	/**
	 * Consctructeur champs à champs.
	 * 
	 * @param facilite
	 * 				La facilite du sortilège offensif.
	 * @param efficacite
	 * 				L'efficacite du sortilège offensif.
	 * @param description
	 * 				La description de sortilège offensif.
	 */
	public SortilegeOffensif(int facilite, int efficacite, String description) {
		super(facilite, efficacite, description);
	}
    
	/**
	 * Constructeur par défaut de SortilegeOffensif.
	 */
	public SortilegeOffensif() {
		super();
		this.description();
		this.nom();
	}
	
	/**
	 * Retourne le nombre de catégories auquel appartien le sortilège offensif
	 * 
	 * @return 1.
	 */
	public int nbCategorie(){
		return 1;
	}
	
	/**
	 * Retourne la catégorie auquel appartient le sortilège offensif.
	 * 
	 * @return La categorie attaque sous forme d'une chaine de caractères.
	 */
	public String categorie(){
		return "Categorie : "+Capacite.ATTAQUE+"-"+Capacite.Categorie[Capacite.ATTAQUE];
	}
	
	/**
	 * Modife la description par "C'est l'arme des magiciens".
	 */
	public void description(){
		this.setDescription("C'est l'arme des magiciens ");
	}
    
	/**
	 * Retourne l'etat du sortilege offensif.
	 * 
	 * @return L'etat du sortilège offensif sous forme d'une chaine de caractères.
	 */
	public String toString(){
		String s = "Sortilege offensif :";
		s+=super.toString();
		return s;
	}
	
	/**
	 * Verifie que l'action est une attaque et effectue l'attaque si oui.
	 * 
	 * @return true si l'action est une attaque, false sinon 
	 */
	public boolean categorie(int categorie,Combattant joueur) {
		if(categorie==Capacite.ATTAQUE){
			this.capacite(categorie,joueur);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Modifie le nom du sortilège offensif par "Sortilège Offensif".
	 */
	public void nom(){
		this.setNom("SortilÃ¨ge Offensif");
	}
}