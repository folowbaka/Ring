package capacite;

import java.io.Serializable;

import combattant.Combattant;
/**
 *CorpsACorps est la classe représentant toutes les capacités de corps à corps du jeu.Elle implémente l'interface Capacite.
 *<p>
 *Une capacité de corps à corps est caractérisé par :
 *<ul>
 *<li>Une description de la capacité de corps à corps.</li>
 *<li><p>Un nom et des caractéristiques définis par l'utilisateur lors de la création de la capacité.</p></li>
 *</p>
 */
public class CorpsACorps implements Capacite, Serializable {
    
	private int impact;
	private int parade;
	private int maniabilite;
	private int protection;
	private String description;
	private String nom;
    
	/**
	 * Constructeur champs à champs de CorpsACorps.
	 * 
	 * @param impact
	 * 				l'impact de la capacité de corps à corps.
	 * @param parade
	 * 				La parade de la capacité de corps à corps.
	 * @param maniabilite
	 * 				La maniabilite de la capacité de corps à corps.
	 * @param protection
	 *				La protection de la capacité de corps à corps.
	 * @param nom
	 * 			Le nom de la capacité de corps à corps.
	 */
	public CorpsACorps(int impact, int parade, int maniabilite, int protection, String nom) {
		this.impact = impact;
		this.parade = parade;
		this.maniabilite = maniabilite;
		this.protection = protection;
		this.setNom(nom);
	}
    
	/**
	 * Constructeur par défaut de CorpsACorps.
	 */
	public CorpsACorps() {
		this.impact = 0;
		this.parade = 0;
		this.maniabilite = 0;
		this.protection = 0;
	}
    
    /**
     * Retourne l'etat de la capcité de corps à corps sous forme d'une chaine de caractères.
     */
	public String toString() {
		return "[nom" + nom + ", impact=" + impact + ", parade=" + parade
        + ", maniabilite=" + maniabilite + ", protection=" + protection
        + "\n[ description=" + description + "]";
	}
    
	/**
	 * Retourne la l'impact de la capacité de corps à corps.
	 * 
	 * @return L'impact de CorpsACorps sous forme d'entier.
	 */
	public int getImpact() {
		return impact;
	}
    
	/**
	 * Met à jour l'impact de la capacité de corps à corps.
	 * 
	 * @param impact
	 * 			Le nouveaux impact de CorpsACorps.
	 * 				
	 */
	public void setImpact(int impact) {
		this.impact = impact;
	}
    
	/**
	 * Retourne la parade de la capacité de corps à corps.
	 * 
	 * @return La parade de CorpsACorps sous forme d'entier.
	 */
	public int getParade() {
		return parade;
	}
    
	/**
	 * Met à jour la parade de la capacité de corps à corps.
	 * 
	 * @param parade
	 * 				La nouvelle parade de la capacité de corps à corps.
	 */
	public void setParade(int parade) {
		this.parade = parade;
	}
    
	/**
	 * Retourne la maniabilite de la capacité de corps à corps.
	 * 
	 * @return La maniabillite  de CorpsAcorps sous forme d'entier.
	 */
	public int getManiabilite() {
		return maniabilite;
	}
    
	/**
	 * Met à jour la maniabilite de la capacite de corps à corps. 
	 * 
	 * @param maniabilite
	 * 					La nouvelle maniabilite de CorpsACorps
	 */
	public void setManiabilite(int maniabilite) {
		this.maniabilite = maniabilite;
	}
    
	/**
	 * Retourne la protection de la capacité de corps à corps.
	 * 
	 * @return La protection de CorpsACorps sous forme d'entier.
	 */
	public int getProtection() {
		return protection;
	}
    
	/**
	 * Met à jour la protection de la capacité de corps à corps.
	 * 
	 * @param protection
	 * 					La nouvelle protection de CorpsACorps.
	 */
	public void setProtection(int protection) {
		this.protection = protection;
	}
    
	/**
	 * Retourne la description de la capacité de corps à corps.
	 * 
	 * @return La description de CorpsACorps sous forme d'une chaine de caractères.
	 */
	public String getDescription() {
		return description;
	}
    
	/**
	 * Met à jour la description de la capacité de corps à corps.
	 * 
	 * @param description
	 * 					La nouvelle description de CorpsACorps
	 */
	public void setDescription(String description) {
		this.description = description;
	}
    
	/**
	 * 
	 */
	public boolean categorie(int categorie,Combattant joueur) {
		return false;
	}
    
	/**
	 * Calcule la probabilité de réussite de l'action de la capacité de corps à corps.
	 * 
	 * @return true si l'action réussi, false sinon.
	 */
	public boolean reussite(Combattant joueur) {
		int pro=(int)((joueur.getDexterite()*this.maniabilite)/10000);
		return Math.random()<=pro;
	}
    
	/**
	 * Modifier la description par "Une arme,armure au corps À corps".
	 */
	public void description() {
		this.setDescription("Une arme, armure au corps Ã  corps");
	}
 
	public int capacite(int coup,Combattant joueur) {
		return 0;
	}
   
	/**
	 * Retourne le nom de la capacité de corps à corps.
	 * 
	 * @return Le nom de CorpsACorps.
	 */
	public String getNom() {
		return nom;
	}
    
	/**
	 * Met à jour le nom de la capacité de corps à corps.
	 * 
	 * @param nom
	 * 			Le nouveaux nom de CorpsACorps.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Modifier le nom de la capacité de corps à corps par "Corps A Corps".
	 */
	public void nom(){
		this.nom="Corps A Corps";
	}
}
