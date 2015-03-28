package combattant;

import java.util.*;

/**
 * L'Athlète est un combattant polyvalent.
 *<p> 
 *La classe Athlete herite de Combattant cependant elle a des contraintes spécifiques en plus des contraintes de Combattant
 *concernant la forcePhysique, l'intelligence, la dexterité et la concentration.
 * </p>
 *
 */
public class Athlete extends Combattant {
    
	public static final int CONTRAINTE = 20;
	
	/**
	 * Constructeur d'Athlete.
	 * 
	 * @param nom
	 * 			Le nom de l'athlète.
	 */
	public Athlete(String nom) {
		super(nom);
	}
	
	/**
	 * Constructeur par défaut.
	 */
	public Athlete(){
		super();
	}
	
	/**
	 * Permet de verifier si les contraintes liées à l'ahlète  sont respectées
	 * 
	 * @return true si la contrainte général à tout les combattants et la contrainte spécifique aux athlètes (la forcePhysique, la dexterité, l'intelligence et la concentration doivent être supérieures ou égales à 20) sont respectées.
	 * 
	 */
	public boolean caracteristique(){
		if(super.caracteristique()){
			if(this.getForcePhysique()>=Athlete.CONTRAINTE && this.getDexterite()>=Athlete.CONTRAINTE && this.getIntelligence()>=Athlete.CONTRAINTE && this.getConcentration()>=Athlete.CONTRAINTE)
				return true;
		}
		return false;
	}
}
