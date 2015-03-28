package dialogueConsole;

import java.util.*;

import combattant.*;

/**
 * ClassConsole g�re les diverses affectations des caract�ristiques des divers combattants du  jeu par l'utilisateur.
 *
 */
public class ClassConsole {
	private Athlete ath=new Athlete();
	private Guerrier gr= new Guerrier();
	private Mage mg = new Mage();
	private CapacitesConsole cc = new CapacitesConsole();
	
	/**
	 * Permet de choisir le type de combattant entre mage,guerrier et athl�te.
	 * 
	 * @return Le Combattant choisi.
	 */
	public Combattant init(){
		Combattant j = null ;
		Scanner sc = new Scanner(System.in);
		int choix=0;
    	do{
			System.out.println("Choisir classe:\n1-Guerrier\n2-Athlète\n3-Mage\n");
            
			choix=sc.nextInt();
		}while(choix<0|| choix>3);
    	try{
            j = this.init(choix,j);
    	}catch(Exception e){
    		System.out.println("Saisie incorrecte !");
    		j = this.init(choix,j);
    	}
    	return j;
	}
	
	/**
	 * Instancie le combattant choisi.
	 * 
	 * @param choix
	 * 			Le choix du combattant.
	 * @param j
	 * 		Le combattant � intancier.
	 *
	 * @return Le combattant instanci�.
	 */
	public Combattant init(int choix,Combattant j){
        
    	switch(choix){
            case 1: this.initGuerrier();
                j=new Combattant(this.gr);
                break;
            case 2:this.initAthlete();
                j=new Combattant(this.ath);
                break;
            default:this.initMage();
                j=new Combattant(this.mg);
                break;
        }
		j.vitaliteCombattant();
		cc.initChoixCap(j);
    	return j;
    }
	
	/**
	 * Instancie un Athlete en demandant � l'utilisateur  d'attribuer les caract�ristiques  en respectant les contraintes.
	 * 
	 */
	public void initAthlete(){
		System.out.println("Vous venez de choisir la classe Athlète.\n\nVeuillez entrer le nom de votre combattant");
		Scanner sc = new Scanner(System.in);
		String nom = sc.next();
		this.ath.setNom(nom);
		System.out.println("Faites en sorte que tout les aptitudes soit inférieur ou égale à 100\nContrainte d'un Athlete : Chaque aptitude soit supérieur ou égale à 20\n");
		do{
			System.out.println("Veuillez entrer une valeur de l'aptitude force\nforce : ");
			int fp = sc.nextInt();
			this.ath.setForcePhysique(fp);
			System.out.println("Veuillez entrer une valeur de l'aptitude dexterité\ndexterité : ");
			int dx = sc.nextInt();
			this.ath.setDexterite(dx);
			System.out.println("Veuillez entrer une valeur de l'aptitude intelligence\nintelligence : ");
			int in = sc.nextInt();
			this.ath.setIntelligence(in);
			System.out.println("Veuillez entrer une valeur de l'aptitude concentration\nconcentration : ");
			int co = sc.nextInt();
			this.ath.setConcentration(co);
			this.ath.setExperience(1);
		}while(!this.ath.caracteristique());
		System.out.println(this.ath);
		System.out.println("Vous gagnez un point d'experience !!\nVotre personnage "+this.ath.getNom()+" est créé !");
	}
	
	/**
	 * Instancie un Guerrier en demandant � l'utilisateur  d'attribuer les caract�ristiques  en respectant les contraintes.
	 * 
	 */
	public void initGuerrier(){
		System.out.println("Vous venez de choisir la classe Guerrier.\n\nVeuillez entrer le nom de votre combattant");
		Scanner sc = new Scanner(System.in);
		String nom = sc.next();
		this.gr.setNom(nom);
		System.out.println("Faites en sorte que tout les aptitudes soit inférieur ou égale à 100\nContrainte d'un guerrier : force>=dexterité+10>=intelligence+10>=concentration\n");
		do{
			System.out.println("Veuillez entrer une valeur de l'aptitude force\nforce : ");
			this.gr.setForcePhysique(sc.nextInt());
			System.out.println("Veuillez entrer une valeur de l'aptitude dexterité\ndexterité : ");
			this.gr.setDexterite(sc.nextInt());
			System.out.println("Veuillez entrer une valeur de l'aptitude intelligence\nintelligence : ");
			this.gr.setIntelligence(sc.nextInt());
			System.out.println("Veuillez entrer une valeur de l'aptitude concentration\nconcentration : ");
			this.gr.setConcentration(sc.nextInt());
			this.gr.setExperience(1);
		}while(!this.gr.caracteristique());
		System.out.println("Vous gagnez un point d'experience !!\nVotre personnage "+this.gr.getNom()+" est créé !");
		
	}
	
	/**
	 * Instancie un Mage en demandant � l'utilisateur  d'attribuer les caract�ristiques  en respectant les contraintes.
	 * 
	 */
	public void initMage(){
		System.out.println("Vous venez de choisir la classe Mage.\n\nVeuillez entrer le nom de votre combattant");
		Scanner sc = new Scanner(System.in);
		String nom = sc.next();
		this.mg.setNom(nom);
		System.out.println("Faites en sorte que tout les aptitudes soit inférieur ou égale à 100\nContrainte d'un Mage : intelligence>=max(force,dexterité)+15 et concentration>=(force,dexterité)+15\n");
		do{
			System.out.println("Veuillez entrer une valeur de l'aptitude force\nforce : ");
			this.mg.setForcePhysique(sc.nextInt());
			System.out.println("Veuillez entrer une valeur de l'aptitude dexterité\ndexterité : ");
			this.mg.setDexterite(sc.nextInt());
			System.out.println("Veuillez entrer une valeur de l'aptitude intelligence\nintelligence : ");
			this.mg.setIntelligence(sc.nextInt());
			System.out.println("Veuillez entrer une valeur de l'aptitude concentration\nconcentration : ");
			this.mg.setConcentration(sc.nextInt());
			this.mg.setExperience(1);
		}while(!this.mg.caracteristique());
		System.out.println("Vous gagnez un point d'experience !!\nVotre personnage "+this.mg.getNom()+" est créé !");
	}
}
