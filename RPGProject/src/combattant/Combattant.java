package combattant;
import java.util.*;

import java.io.*;
import capacite.*;

/**
 * RPGProject est un programme qui consiste Ã  retranscrire un combat entre deux joueurs
 * @version 2.7
 * <b>Combattant est la classe représentant un combattant du jeu.</b>
 * <p>
 * Un combattant est caractérisé par les information suivantes :
 * <ul>
 * <li>Une vitalite maximal correspondant a la vitalite initialisé en début de combat et qui ne change pas tout le long du combat</li>
 * <li>Une vitalite correspondant aux points de vie du Combattant qui est initialisé au début du combat</li>
 * <li>Une experience qui augmente ou diminue selon le résultat du combat</li>
 * <li>Une liste de capacités qu'il peut utiliser en combat</li>
 * </ul>
 * </p>
 * <p>
 * De plus, un Combattant possède des caractérisques telle qu'une intelligence, une dexterite, une concentration
 * une forcePhysique et un nom qui sont définis par le joueur lors de la création.
 * </p>  
 * @author Galante David & Ahmed Mahmoud Nassim
 * @version 2.7
*/
public class Combattant implements Serializable{
    
	private int vitaliteMax;
    private int vitalite ;
    private int intelligence ;
    private int dexterite;
    private int concentration ;
    private int experience ;
    private int forcePhysique ;
    private String nom ;
    private boolean capituler = false;
    private ArrayList<Capacite> capacite = new ArrayList<Capacite>();
    private int parade=0;
    private static ArrayList <Combattant>sauvegarde = new ArrayList<Combattant>();
    public static final int XPMAX=20;
	public static final int XPMIN=1;
    
    
 
    /**
     * Constructeur champs à champs du Combattant.
     * 
     * @param vitalite 
     *					La vitalite du combattant.
     * @param intelligence
     * 					L"intelligence du combattant.
     * @param dexterite
     * 					La dexterite du combattant.
     * @param concentration
     *					La concentration du combattant.
     * @param experience
     * 					L'experience du combattant.
     * @param forcePhysique
     * 					La force Physique du combattant.
     * @param nom
     * 					Le nom du combattant.
     */
    public Combattant(int vitalite, int intelligence, int dexterite,
                      int concentration, int experience, int forcePhysique, String nom) {
        this.intelligence = intelligence;
        this.dexterite = dexterite;
        this.concentration = concentration;
        this.experience = experience;
        this.forcePhysique = forcePhysique;
        this.nom = nom;
        this.vitalite = vitalite;
        this.vitaliteMax=this.vitalite;
    }
    /**
     * Constructeur par recopie.
     * 
     * @param combattant
     * 				Le Combattant qui est copié.
     */
    public Combattant(Combattant combattant){
    	this.intelligence=combattant.intelligence;
    	this.dexterite = combattant.dexterite;
        this.concentration = combattant.concentration;
        this.experience = combattant.experience;
        this.forcePhysique = combattant.forcePhysique;
        this.nom = new String(combattant.nom);
        this.vitalite = combattant.vitalite;
        this.vitaliteMax=this.vitalite;
        this.capacite = new ArrayList<Capacite>(combattant.capacite);
    }
    
    /**
     * Retourne la liste de capacités du combattant.
     * 
     * @return La liste de capacités du combattant sous forme d'une collection de capacités
     */
    public ArrayList<Capacite> getCapacite() {
		return capacite;
	}
    
    /**
     * Met à jour la liste de capacités du combattant.
     * 
     * @param capacite
     * 					La nouvel liste de capacités.
     */
	public void setCapacite(ArrayList<Capacite> capacite) {
		this.capacite = capacite;
	}
	
	/**
	 * Met à jour une capacité dans la liste de capacités du combattant.
	 * 
	 * @param capacite
	 * 					La nouvel capacité
	 * @param i
	 * 			Le rang de la capacité à  mettre jour.
	 */
	public void setCapacite(Capacite capacite , int i){
		this.capacite.set(i, capacite);
	}
	
	/**
	 * Retourne une capacité dans la liste de  capacités du combattant.
	 * 
	 * @param i
	 * 			Le rang de la capacité qui doit être retournée.
	 * @return  Une capacité dans la liste de capacités du combattant.
	 */
	public Capacite getCapacite(int i){
		return this.capacite.get(i);
	}
	
	/**
	 * Constructeur Combattant.
	 * 
	 * @param nom Le nom du combattant.
	 */
	public Combattant (String nom){
        this.intelligence = 0;
        this.dexterite = 0;
        this.concentration = 0;
        this.experience = 0;
        this.forcePhysique = 0;
        this.nom = nom;
        this.vitalite = 0;
        this.vitaliteMax=this.vitalite;
    }
	
	/**
	 * Constructeur par défaut de Combattant.
	 */
    public Combattant(){
        this.intelligence = 0;
        this.dexterite = 0;
        this.concentration = 0;
        this.experience = 0;
        this.forcePhysique = 0;
        this.nom = "defaut";
        this.vitalite = 0;
        this.vitaliteMax=this.vitalite;
    }
    
    
    /**
     * Retourne un boolean en fonction de la partie, si elle est finie ou non.
     * 
     * @return false si le combattant a captituler ou si il n'a plus de points de vies, true sinon.
     */
    public boolean finPartie(){
        if(this.capituler==true || this.vitalite<=0){
            return false ;
        }
        return true;
    }
    
    /**
     * Retourne si le combattant à capituler ou non.
     * 
     * @return capituler du combattant.
     */
    public boolean getCapituler() {
        return capituler;
    }
    
    /**
     * Met a jour capituler du combattant.
     * 
     * @param capituler
     */
    public void setCapituler(boolean capituler) {
        this.capituler = capituler;
    }
    
    /**
     * Retourne le nombre de points de vie du combattant.
     * 
     * @return La vitalite du combattant.
     */
    public int getVitalite() {
        return vitalite;
    }
    
    /**
     * Met à jour la vitalite du combattant.
     * 
     * @param vitalite
     * 				La nouvelle vitalite du combattant.
     */
    public void setVitalite(int vitalite) {
        this.vitalite = vitalite;
    }
    /**
     * Retourne l'intelligence du combattant.
     * 
     * @return l'intelligence du combattant sous forme d'entier.
     */
    public int getIntelligence() {
        return intelligence;
    }
    
    /**
     * Met à jour l'intelligence du combattant.
     * 
     * @param intelligence
     * 						La nouvelle intelligence du combattant.
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    
    /**
     * Retourne la dexterite du combattant.
     * 
     * @return  La dexterite du combattant sous forme d'entier.
     */
    public int getDexterite() {
        return dexterite;
    }
    
    /**
     * Met à jour la dexterite du combattant.
     * 
     * @param dexterite
     * 					La nouvelle dexterite du combattant.
     */
    public void setDexterite(int dexterite) {
        this.dexterite = dexterite;
    }
    
    /**
     * Retourne la concentration du combattant.
     * 
     * @return La concentration du combattant sous forme d'entier.
     */
    public int getConcentration() {
        return concentration;
    }
    
    /**
     * Met à jour la concentration du combattant.
     * 
     * @param concentration
     * 						La nouvelle concentration du combattant.
     */
    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }
    
    /**
     * Retourne l'experience du combattant.
     * 
     * @return L'experience du combattant sous forme d'entier.
     */
    public int getExperience() {
        return experience;
    }
    
    /**
     * Met à jour l'experience du combattant.
     * 
     * @param experience
     * 					La nouvelle experience du combattant.
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    /**
     * Retourne la force physique du combattant.
     * 
     * @return la forcePhysique du combattant sous forme d'entier.
     */
    public int getForcePhysique() {
        return forcePhysique;
    }
    
    /**
     * Met à jour la force physique du combattant.
     * 
     * @param forcePhysique
     * 						La nouvelle forcePhysique du combattant.
     */
    public void setForcePhysique(int forcePhysique) {
        this.forcePhysique = forcePhysique;
    }
    
    /**
     * Retourne le nom du combattant.
     * 
     * @return Le nom du combattant sous forme d'une chaine de caractères.
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Met à jour le nom du combattant.
     * 
     * @param nom
     * 			Le nouveaux nom du combattant.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Retourne l'etat du combattant sous forme d'une chaine de caractères.
     */
	public String toString() {
		return "Combattant [vitaliteMax=" + vitaliteMax + ", vitalite="
        + vitalite + ", intelligence=" + intelligence + ", dexterite="
        + dexterite + ", concentration=" + concentration
        + ", experience=" + experience + ", forcePhysique="
        + forcePhysique + ", nom=" + nom + ", capituler=" + capituler
        + ", capacite=" + capacite + ", parade=" + parade + "]";
	}
    
	/**
	 * Permet de verifier si les contraintes liées aux combattants sont respectées
	 * 
	 * @return true si la forcephysique + la dexterite + l'intelligence et la concentration  du combattant est inférieur ou égale à 100 + son experience.
	 */
	public boolean caracteristique(){
        if((this.forcePhysique+this.dexterite+this.intelligence+this.concentration)<=(100+this.getExperience()) && this.experience>=1 && this.experience<=20){
            return true;
        }
        return false;
    }
    
    /**
     * Initialise la vitalité et la vitaliteMax du combattant.
     */
    public void vitaliteCombattant(){
        this.vitalite=(200-this.forcePhysique-this.concentration-this.intelligence-this.dexterite)+this.experience*3;
        this.vitaliteMax=this.vitalite;
    }
    /**
     * Retourne le nombre de capacites que possède le combattant.
     * 
     * @return Le nombre de capacités sous forme d'entier.
     */
    public int nbCapacite(){
        if(this.experience/2>2)
            return this.experience/2;
        return 2;
    }
    
    /**
     * Soigne le combattant
     * 
     * @param soin
     * 			Le nombre de point de vie que le combattant récupere.
     */
    public void soin(int soin){
    	this.setParade(0);
    	if((this.getVitalite()+soin)<=this.getVitaliteMax())
    		this.setVitalite(this.getVitalite()+ soin);
    	else
    		this.setVitalite(this.getVitaliteMax());
    }
    
    /**
     * Permet au combattant de faire une parade.
     * 
     * @param parade
     * 				Le nombre de dommages que le combattant pare.
     */
    public void parade(int parade){
    	if(this.parade>0){
    		this.setParade(this.parade);
    	}
    	this.setParade(parade);
    }
    
    /**
     * Supprime toute les capacités du combattant.
     */
    public void supprimerCapacite(){
		this.capacite.removeAll(capacite);
    }
    
    /**
     * Permet au combattant d'attaquer.
     * 
     * @param ennemi
     * 				Le combattant ciblé par l'attaque.
     * @param degat
     * 				Le dommages qui seront infligés.
     */
    public void attaque(Combattant ennemi,int degat){
    	this.setParade(0);
    	if(degat>=ennemi.getParade())
    		degat-=ennemi.getParade();
   		else
   			degat=0;
    	if(degat>=ennemi.getVitalite())
    		ennemi.setVitalite(0);
    	else
    		ennemi.setVitalite(ennemi.getVitalite()-degat);
    }
    /**
     * Récupère les dégats,réductions ou soin de la capacité et coup choisis.
     * 
     * @param choix
     * 			Le choix de la capacité.
     * @param coup
     * 			Le type de coup choisi.
     * @return Les dégats,soins ou réduction sous forme d'entier.
     */
    public int degat(int choix,int coup){
    	return this.getCapacite().get(choix).capacite(coup,this);
    }
    
    /**
     * 
     * @param choix
     * @param coup
     * @return
     */
    public boolean choixCategorie(int choix,int coup){
    	return this.getCapacite().get(choix).categorie(coup,this);
    }
    
    /**
     * Permet de lancer une attaque,parade ou un soin sur le combattant ennemi
     * 
     * @param ennemi
     * 				Le combattant ennemi.
     * @param coup
     * 				Le type d'action effectué.
     * @param degat
     * 				La puissance de l'action effetué.
     */
    public void choixCapCat(Combattant ennemi,int coup,int degat){
    	if(coup==Capacite.ATTAQUE){
			this.attaque(ennemi, degat);
		}
		else if(coup==Capacite.PARADE){
			this.parade(degat);
		}
		else if(coup==Capacite.SOIN){
			this.soin(degat);
		}
    }
    
    /**
     * Permet de sauvegarder un combattant si il est vivant.
     * 
     * @return false si le combattant est mort, true sinon. 
     */
    public boolean sauvegarde(){
    	if(this.vitalite>0){
    		getSauvegarde().add(this);
    		FileOutputStream fichier = null;
    		try{
    			fichier = new FileOutputStream("combattants.txt");
     			ObjectOutputStream objet = new ObjectOutputStream(fichier);
    			objet.writeObject(Combattant.sauvegarde);
    			objet.close();
   				fichier.close();
    		}
    		catch(Exception e){  e.printStackTrace();   	}
    		return true;
    	}
    	return false;
    }
    
    /**
     * Initialise la liste de combattants avec un fichier contenant une liste de combattant.
     */
	@SuppressWarnings("unchecked")
	public static void lire(){
    	FileInputStream fichier = null;
    	try{
    		fichier = new FileInputStream("combattants.txt");
    		try{
    			ObjectInputStream ois = new ObjectInputStream(fichier);
    			Combattant.sauvegarde = (ArrayList<Combattant>)ois.readObject();
    			ois.close();
    			fichier.close();
    		}
    		catch(FileNotFoundException e){ e.printStackTrace();
    		}
    		catch(Exception e){
                e.printStackTrace();
    		}
    	}
    	catch(Exception e){   e.printStackTrace(); 	}
    }
	
    /**
     * Incremente l'expèrience du joueur  si elle est supérieur à l'expérience maximal.
     */
    public void incrExp(){
    	if(this.experience<XPMAX )
    	this.experience++;
    }
    
    /**
     * Decremente l'expérience du joueur si elle est supérieur à l'expérience minimum.
     */
    public void decrExp(){
    	if(this.experience>XPMIN)
        this.experience--;
    }
    
    /**
     * Supprime la dernière capacité de la liste de capacités.
     */
    public void perdreCap(){
    	this.capacite.remove(this.capacite.size());
    }
    
    /**
     * Retourne le nombre de dommages que réduit le combattant.
     * 
     * @return parade sous forme d'entier.
     */
	public int getParade() {
		return parade;
	}
    
	/**
	 * Met à jour le nombre de dommages que réduit le combattant.
	 * 
	 * @param parade
	 * 				La nouvelle valeur de parade.
	 */
	public void setParade(int parade) {
		this.parade = parade;
	}
    
	/**
	 * Retour la vitalite maximale du combattant.
	 * 
	 * @return vitaliteMax du combattant sous forme d'entier.
	 */
	public int getVitaliteMax() {
		return vitaliteMax;
	}
    
	/**
	 * Met à jour la vitalite maximal du combattant.
	 * 
	 * @param vitaliteMax
	 * 					La nouvelle vitaliteMax du combattant.
	 */
	public void setVitaliteMax(int vitaliteMax) {
		this.vitaliteMax = vitaliteMax;
	}
	
    /** Retourne la liste de combattants sauvegardés.
     * 
     * @return La liste de combattants
     */
	public static ArrayList <Combattant> getSauvegarde() {
		return sauvegarde;
	}
    
	/**
	 * Met à jour la liste de combattants sauvegardés.
	 * 
	 * @param sauvegarde
	 * 					La nouvelle liste de combattants.
	 */
	public static void setSauvegarde(ArrayList <Combattant> sauvegarde) {
		Combattant.sauvegarde = sauvegarde;
	}
    
    
}