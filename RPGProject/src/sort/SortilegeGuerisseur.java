package sort;
import capacite.*;
import combattant.Combattant;

/**
 * SortilegeGuerisseur répresente tous les sortilèges guerisseurs du jeu.Elle hérite de Sort.
 *
 */
public class SortilegeGuerisseur extends Sort {
    
	/**
	 * Constructeur champs à champs de SortilegeGuerisseur.
	 * 
	 * @param facilite
	 * 				La facilite du sortilège guerisseur.
	 * @param efficacite
	 * 				L'efficacite du sortilège guerisseur.
	 * @param description
	 * 				La description du sortilège gurisseur.
	 */
	public SortilegeGuerisseur(int facilite, int efficacite, String description) {
		super(facilite, efficacite, description);
	}
	
	/**
	 * Constructeur par défaut de SortilegeGuerisseur.
	 */
	public SortilegeGuerisseur() {
		super();
		this.description();
		this.nom();
	}
	
	/**
	 * Retourne La catégorie auquel appartient sortilège guerisseur.
	 * 
	 * @return La catégorie soin  sous forme d'une chaine de caractères.
	 */
	public String categorie() {
		return "Categorie : "+Capacite.SOIN+"-"+Capacite.Categorie[Capacite.SOIN];
	}
    
	/**
	 * Modifie la description par "C'est le remède des magiciens".
	 */
	public void description(){
		this.setDescription("C'est le remÃ¨de des magiciens ");
	}
    /**
     * Retourne l'etat du sortilege guerisseur.
     * 
     * @return L'etat du sortilège guerisseur  sous forme d'une chaine de caractères.
     */
	public String toString(){
		String s = "Sortilege guerisseur :";
		s+=super.toString();
		return s;
	}
	
	/**
	 * Retourne le nombre de catégorie auquel appartient le sortilège guerisseur".
	 * 
	 * @return 1.
	 */
	public int nbCategorie(){
		return 1;
	}

	/**
	 * Verifie si le coup appartient à soin.
	 *
	 * @return  true  si la categorie est soin, false sinon.
	 */
	public boolean categorie(int categorie,Combattant joueur) {
		if(categorie==Capacite.SOIN){
			this.capacite(categorie,joueur);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Modifie le nom du sortilège guerisseur par "Sortilège Guerisseur".
	 * 
	 */
	public void nom(){
		this.setNom("SortilÃ¨ge Guerisseur");
	}
}