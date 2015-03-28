package cac;

import java.util.Scanner;

import capacite.*;
import combattant.*;

/**
 * Bouclier represente un bouclier dans le jeu.Elle hérite de CorpsACorps.
 *
 */
public class Bouclier extends CorpsACorps{
    /**
     * Constructeur champs à champs de Bouclier.
     * 
     * @param impact
     * 				L'impact du bouclier.
     * @param parade
     * 				La parade du bouclier.
     * @param maniabilite
     * 				La maniabilite du bouclier.
     * @param protection
     * 				La protection du bouclier.
     */
	public Bouclier(int impact, int parade, int maniabilite, int protection) {
		super(impact, parade, maniabilite, protection,"Bouclier");
	}
	
	/**
	 * Constructeur par défaut de Bouclier.
	 */
	public Bouclier() {
		super();
		this.description();
		this.nom();
	}
	
	/**
	 * Verifie que l'action est une parade et effectue la parade si oui.
	 * 
	 * @return true si l'action est une parade, false sinon 
	 */
	public boolean categorie(int categorie,Combattant joueur) {
		if(categorie==Capacite.PARADE){
			this.capacite(joueur);
			return true;
		}
		else
			return false;
	}
    /**
     * Calcule l'Impact  du bouclier.
     * 
     * @param joueur
     * 				Le combattant possédant le bouclier.
     * @return L"Impact sous forme d'entier.
     */
	public int efficacite(Combattant joueur){
		return ((joueur.getForcePhysique()* this.getProtection())/100);
	}
	
	/**
	 * Modifie la description par "Son efficacitée est divisée par 3  si l'attaque est un sortilége ".
	 */
	public void description(){
		this.setDescription("Son efficacitÃ© est divisÃ© par 3 si l'attaque est un sortilÃ¨ge ");
	}
    /**
     * Retourne l'etat du bouclier.
     * 
     * @return L'etat du bouclier sous forme d'une chaine de caractères.
     */
	public String toString(){
		String s = "Bouclier :";
		s+=super.toString();
		return s;
	}
	
	/**
	 * Utilisation du bouclier.
	 * @param joueur
	 * 			Le combattant possèdant le bouclier.
	 * @return La reduction du bouclier sous forme d'entier si l'utilisation du bouclier réussie, 0 sinon
	 */
	public int capacite(Combattant joueur){
		if(this.reussite(joueur)){
			return this.efficacite(joueur);
		}
		return 0;
	}
	/**
	 * <b>Verifie si la contrainte liée aux boucliers est respectée.</b>
	 * <b>protection et maniabilite <=20 et protection + maniabilite <=100.
	 * @return true si la contrainte est respecté, false sinon.
	 */
	public boolean caracteristique(){
		if(this.getProtection()+this.getManiabilite()<=100 && this.getManiabilite()>=20 && this.getProtection()>=20){
			return true;
		}
		return false;
	}
	/**
	 * Retourne le nombre de categories auquel le bouclier appartient.
	 * 
	 * @return 1.
	 */
	public int nbCategorie(){
		return 1;
	}
	/**
	 * Modifier le nom par " Bouclier".
	 */
	public void nom(){
		this.setNom("Bouclier");
	}
}