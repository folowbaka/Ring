package sort;
import capacite.*;
import combattant.Combattant;

/**
 * SortilegeDefensif représente tous les sortilèges défensifs du jeu.Elle hérite de Sort.
 *
 */
public class SortilegeDefensif extends Sort {
    /**
     * Constructeur champs à champs de SortilegeDefensif.
     * 
     * @param facilite
     * 				La facilite du sortilège défensif
     * @param efficacite
     * 				L'efficacite du sortilège défensif.
     * @param description
     * 				La description du sortilège défensif.
     */
	public SortilegeDefensif(int facilite, int efficacite, String description) {
		super(facilite, efficacite, description);
	}
    
	/**
	 * Constructeur par défaut de SortilegeDefensif.
	 */
	public SortilegeDefensif() {
		super();
		this.description();
		this.nom();
	}
    /**
     * Retourne l'etat du sortilège défensif.
     * 
     * @return L'etat du sortilège défensif sous forme d'une chaine de caractères.
     */
	public String toString(){
		String s = "Sortilege defensif : ";
		s+=super.toString();
		return s;
	}
	
	/**
	 * Retourne la catégorie auquel appartient  le sortilège défensif.
	 * 
	 * @return La catégorie auquel appartien le sortilège défensif sous forme d'une chaine de caractères.
	 */
	public String categorie() {
		return "Categorie : "+Capacite.PARADE+"-"+Capacite.Categorie[Capacite.PARADE];
	}
    
    /**
     * Modifie la description du sortilège défensif par "Bouclier des attaques magiques,son efficacitée est divisée par 3 si l'lattaque ne l'est pas ".
     */
	public void description(){
		this.setDescription("Bouclier des attaques magiques, son efficacitÃ© est divisÃ©e par 3 si l'attaque ne l'est pas ");
	}
	
	/**
	 * Retourne le nombre de catégories auquel appartient le sortilége défensif.
	 * 
	 * @return 1.
	 */
	public int nbCategorie(){
		return 1;
	}
	
	/**
	 * Verifie que l'action est une parade et effectue la parade si oui.
	 * 
	 * @return true si l'action est une parade, false sinon 
	 */
	public boolean categorie(int categorie,Combattant joueur) {
		if(categorie==Capacite.PARADE){
			joueur.parade(this.capacite(categorie,joueur));
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Modifie le nom par "Sortilège Defensif"	 
	 */
	public void nom(){
		this.setNom("SortilÃ¨ge Defensif");
	}
}