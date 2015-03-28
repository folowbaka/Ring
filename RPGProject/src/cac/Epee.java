package cac;

import java.util.Scanner;

import capacite.*;
import combattant.*;
/**
 * Epee represente une épee dans le jeu.Elle hérite de CorpsACorps.
 *
 */
public class Epee extends CorpsACorps {
	
	/**
	 * Constructeur champs à champs d'Epee.
	 * 
	 * @param impact
	 * 				L' impact d'Epee.
	 * @param parade
	 * 				La parade d'Epee.
	 * @param maniabilite
	 * 				La maniabilite d'Epee.
	 * @param protection
	 * 				La protection d'Epee.
	 */
	public Epee(int impact, int parade, int maniabilite, int protection) {
		super(impact, parade, maniabilite, protection,"Epee");
	}
	/**
	 * Constructeur par défaut d'Epee.
	 */
	public Epee() {
		super();
		this.description();
		this.nom();
	}
	/**
	 * Retourne le nombre de catégories auquel l'épée appartient.
	 * 
	 * @return 2.
	 */
	public int nbCategorie(){
		return 2;
	}
	/**
	 * Retourne les catégories de l'epée.
	 * 
	 * @return Les catégories de l'epée sous forme d'une chaine de caractères.
	 */
	public String categorie(){
		return "Categorie : \n"+Capacite.ATTAQUE+"-"+Capacite.Categorie[Capacite.ATTAQUE]+"\n"+Capacite.PARADE+"-"+Capacite.Categorie[Capacite.PARADE];
	}
	/**
	 * Calcule l'attaque avec l'epée.
	 * 
	 * @param joueur
	 * 				Le combattant possédant l'épée.
	 * 
	 * @return La puissance de l'attaque sous forme d'entier.
	 */
	public int efficaciteAttaque(Combattant joueur){
		return ((joueur.getForcePhysique()* this.getImpact())/100);
	}
	/**
	 * Calcule la parade avec l'épée.
	 * 
	 * @param joueur
	 * 				Le combattant possédant l'épée.
	 * @return L 'efficacité de la parade sous forme d'entier.
	 */
	public int efficaciteParade(Combattant joueur){
		return ((joueur.getForcePhysique()* this.getParade())/100);
	}
	
	/**
	 * Modifie la description de l'épée par"A la fois arme offensive et defensife son efficacitée est divisiée par 3 en cas de parade d'un sortilege".
	 */
	public void description(){
		this.setDescription("A la fois arme offensive et defensive son efficacitÃ© est divisÃ©e en par 3 en cas de parade d'un sortilege");
	}
	
	/**
	 * Retourne l'etat de l'épée.
	 * 
	 * @return L'état de l'épée sous forme d'une chaine de caractères.
	 */
	public String toString(){
		String s = "EpÃ©e :";
		s+=super.toString();
		return s;
	}
	
	/**
	 * Retourne le nom de l'épée.
	 * 
	 * @return Le nom de l'épée sous forme d'une chaine de caractères.
	 * 
	 */
	public String getNom(){
		this.setNom("Epee");
		return "Epee";
	}
	/**
	 * Utilisation de l'épée soit en attaque ou parade.
	 * 
	 * @return La puissance de l'attaque ou l'efficacite de la parade sous forme d'un entier,0 sinon.
	 */
	public int capacite(int coup,Combattant joueur){
		if(this.reussite(joueur)){
			if(coup==Capacite.ATTAQUE)
				return this.efficaciteAttaque(joueur);
			else if(coup==Capacite.PARADE)
				return this.efficaciteParade(joueur);
		}
		return 0;
	}
    
	/**
	 * Verifie si le coup est une attaque ou une parade et l'effectue.
	 * 
	 * @return true si le coup appartient a la categorie attaque ou parade, false sinon.
	 */
	public boolean categorie(int categorie,Combattant joueur) {
		if(categorie==Capacite.ATTAQUE || categorie==Capacite.PARADE){
			this.capacite(categorie,joueur);
			return true;
		}
		else
			return false;
	}
	
	/**
	 *Verifie la contrainte liée aux épées.
	 *<b>La contrainte est : l'impact + la parade +la maniabilite <=100 et l'impact,la parade et la maniabilite >=20.</b> 
	 *
	 * @return true si la contrainte est respectée, false sinon.
	 */
	public boolean caracteristique(){
		if(this.getImpact()+this.getParade()+this.getManiabilite()<=100 && this.getImpact()>=20 && this.getParade()>=20 && this.getManiabilite()>=20){
			return true;
		}
		return false;
	}
	/**
	 * Modifie le nom par "Epée".
	 */
	public void nom(){
		this.setNom("EpÃ©e");
	}
}
