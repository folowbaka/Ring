package combattant;
import java.util.*;

/**
 * Le guerrier est un combattant axé sur la force physique et la dextérité.
 * <p>
 *La classe Guerrier herite de Combattant cependant elle a des contraintes spécifiques en plus des contraintes de Combattant
 *concernant la forcePhysique, l'intelligence, la dexterité et la concentration.
 *</p>
 */
public class Guerrier extends Combattant{
    
	/**
	 * Constructeur de Guerrier.
	 * 
	 * @param nom
	 * 			Le nom du Guerrier.
	 */
	public Guerrier(String nom) {
		super(nom);
	}
	
	/**
	 * Constructeur par défaut de Guerrier.
	 * 
	 */
	public Guerrier(){
		super();
	}
	/**
	 * Permet de verifier si la contraintes liée aux combattants est  respectées plus la contrainte spécifique aux guerriers.
	 * <p>
	 * La contrainte des guerriers est : la forcePhysique est supérieure ou égale à la dexterite +10 et la dexterite est supérieure ou égale à l'intelligence et l'intelligence +10 est supérieure ou égale à la concentration.
	 * </p>   
	 * @return true si la contrainte des  combattants et la contrainte des guerriers sont respectées, false sinon.
	 */
	public boolean caracteristique(){
		if(super.caracteristique()){
			if(this.getForcePhysique()>=this.getDexterite()+10 && this.getDexterite()>=this.getIntelligence() && this.getIntelligence()+10>=this.getConcentration())
				return true;
		}
		return false;
	}
}
