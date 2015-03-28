package combattant;
import java.util.Scanner;

/**
 * Le mage est un combattant axé sur l'intelligence et la concentration.
 * <p>
 *La classe Mage herite de Combattant cependant elle a des contraintes spécifiques en plus des contraintes de Combattant
 *concernant la forcePhysique, l'intelligence, la dextérité et la concentration.
 *</p>
 */
public class Mage extends Combattant{
    
	/**
	 * Constructeur de Mage.
	 * @param nom
	 * 			Le nom du mage.
	 */
	public Mage(String nom) {
		super(nom);
	}
	
	/**
	 * Constructeur par défaut de mage.
	 */
	public Mage() {
		super();
	}
	/**
	 * Permet de verifier si la contraintes liée aux combattants est  respectées plus la contrainte spécifique aux mages.
	 * <p>
	 * La contrainte des mages est : l'intelligence et la concentration sont supérieures ou égales  au maximun entre la force et la dexterite +15.
	 * </p>   
	 * @return true si la contrainte des  combattants et la contrainte des mages sont respectées, false sinon.
	 */
	public boolean caracteristique(){
		if(super.caracteristique()){
			if(this.getIntelligence()>= (Math.max(this.getForcePhysique(),this.getDexterite())+15) && this.getConcentration()>=(Math.max(this.getForcePhysique(),this.getDexterite())+15))
				return true;
		}
		return false;
	}
}
