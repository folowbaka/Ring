package dialogueConsole;
import java.util.*;
import capacite.*;
import combattant.*;

public class CombattantConsole {
    private Combattant j1 = new Combattant() ;
    private Combattant j2 = new Combattant();
    private ClassConsole cl = new ClassConsole();
	private CapacitesConsole cc = new CapacitesConsole();
	private boolean jeu=true;
	
	/**
	 * Permet de lancer le combat.
	 */
    public void combat(){
    	boolean test = true;
    	int random = (int) (Math.random() * (2 - 0));
    	System.out.println(random);
        while(this.j1.finPartie() && this.j2.finPartie() && test){
            System.out.println("Nom :" +this.j1.getNom() +"; vie : "+this.j1.getVitalite());
            System.out.println("Nom :" +j2.getNom() +"; vie : "+j2.getVitalite());
        	if(this.j1.getExperience()<this.j2.getExperience() || (this.j1.getExperience()==this.j2.getExperience() && random==1))
            	test = this.tour(this.j2,this.j1);
            else
                test = this.tour(this.j1,this.j2);
        }
        System.out.println("Nom :" +this.j1.getNom() +"; vie : "+this.j1.getVitalite());
        System.out.println("Nom :" +j2.getNom()+"; vie : "+j2.getVitalite());
    }
    
    /**
     * Permet de lancer un tour de jeu.
     * 
     * @param joueur1
     * 			Le combattant du joueur 1.
     * @param joueur2
     * 			Le combattant du joueur 2.
     * @return false si le joueur 1 ou 2 a capitulé, true si le tour est fini.
     */
    public boolean tour(Combattant joueur1, Combattant joueur2){
    	int coupJ1=0,coupJ2=0,choixJ1=0,choixJ2=0,degatJ1=0,degatJ2=0,coupJ12=0,degatJ12=0,coupJ22=0,degatJ22=0,choixJ12=0,choixJ22=0;
    	System.out.println("\n---\t---Tour de "+joueur1.getNom()+" :\t---\t---\n");
    	int choixCapJ1 =this.choixCap();
    	if(choixCapJ1!=2){
    		choixJ1=this.choixCapacite(joueur1);
    		coupJ1=this.choixCategorie(joueur1,choixJ1);
    		degatJ1=this.choixDegat(joueur1,coupJ1,choixJ1,choixCapJ1);
    		
    		choixJ12=this.choixCapacite(joueur1);
    		coupJ12=this.choixCategorie(joueur1,choixJ12);
    		degatJ12=this.choixDegat(joueur1,coupJ12,choixJ12,choixCapJ1);
    		
    		System.out.println(choixJ1+"-"+coupJ1+"-"+degatJ1);
    		System.out.println(choixJ12+"-"+coupJ12+"-"+degatJ12);
    	}
    	else
    		return false;
    	System.out.println("\n---\t---Tour de "+joueur2.getNom()+" :\t---\t---\n");
    	int choixCapJ2 =this.choixCap();
    	if(choixCapJ2!=2){
    		
    		choixJ2=this.choixCapacite(joueur2);
    		coupJ2=this.choixCategorie(joueur2,choixJ2);
    		degatJ2 =this.choixDegat(joueur2,coupJ2,choixJ2,choixCapJ2);
    		
    		choixJ22=this.choixCapacite(joueur2);
    		coupJ22=this.choixCategorie(joueur2,choixJ22);
    		degatJ22=this.choixDegat(joueur2,coupJ22,choixJ22,choixCapJ2);
    		
    		System.out.println(choixJ2+"-"+coupJ2+"-"+degatJ2);
    		System.out.println(choixJ22+"-"+coupJ22+"-"+degatJ22);
    	}
    	else
    		return false;
    	
    	this.choixCapCat(joueur1, joueur2, coupJ1, coupJ2, degatJ1, degatJ2);
    	this.choixCapCat(joueur1, joueur2, coupJ12, coupJ22, degatJ12, degatJ22);
    	
    	System.out.println("Vie de "+joueur1.getNom()+" : (" + joueur1.getVitalite() + " / " + joueur1.getVitaliteMax() + ") | dommage rÃ©alisÃ© par "+joueur1.getNom()+" : "+degatJ1+" | parade : "+joueur1.getParade()+" |");
    	System.out.println("Vie de "+joueur2.getNom()+" : (" + joueur2.getVitalite() + " / " + joueur2.getVitaliteMax() + ") | dommage rÃ©alisÃ© par "+joueur2.getNom()+" : "+degatJ2+" | parade : "+joueur2.getParade()+" |");
        
    	return true;
    }
    
    /**
     * Applique les soins,attaques et parades de chaque combattant.
     * 
     * @param joueur1
     * 				Le combattant du joueur 1.
     * @param joueur2
     * 				Le combattant du joueur 2.
     * @param coupJ1
     * 				Le type de coup du combattant du joueur 1.
     * @param coupJ2
     * 				Le type de coup du combattant du joueur 2.
     * @param degatJ1
     * 				Les degats causés par l'attaque du joueur1 ou la reduction des degats de l'attaque du joueur 2 ou le nombre de points de vie que le joueur 1 récupère.
     * @param degatJ2
     * 				Les degats causés par l'attaque du joueur2 ou la reduction des degats de l'attaque du joueur 1 ou le nombre de points de vie que le joueur 2 récupère.
     */
    public void choixCapCat(Combattant joueur1,Combattant joueur2,int coupJ1,int coupJ2,int degatJ1,int degatJ2){
    	if(coupJ2==Capacite.PARADE){
    		joueur2.choixCapCat(joueur1,coupJ2 , degatJ2);
    		joueur1.choixCapCat(joueur2,coupJ1 , degatJ1);
    	}
    	else{
    		joueur1.choixCapCat(joueur2,coupJ1 , degatJ1);
    		joueur2.choixCapCat(joueur1,coupJ2 , degatJ2);
    	}
    }
    
    /**
     * Effectue l'action choisie par l'utilisateur.
     * 
     * @param joueur
     * 			Le combattant effectuant l'action.
     * @param coup
     * 			Le type de coup choisi.
     * @param choix
     * 			Le choix de la capacité.
     * @param choixCap
     * 			Le choix de l'action.
     * 
     * @return Les dégats,soins ou réductions.
     */
	public int choixDegat(Combattant joueur,int coup,int choix,int choixCap){
    	int degat=0;
    	if(choixCap==1){
    		degat=joueur.degat(choix,coup);
    	}
    	else{
    		joueur.setCapituler(true);
    	}
    	return degat;
    }
    
	/**
	 * Permet à l'utilisateur de choisir deux actions.
	 * 
	 * @return L'action choisie sous forme d'entier.
	 */
    public int choixCap(){
    	Scanner sc = new Scanner(System.in);
    	int coup=0;
        do{
            System.out.println("1-  Capacite\n2-  Capituler");
            coup = sc.nextInt();
        }while(coup<0 || coup>2);
        
        return coup;
    }
    
    /**
     * Permet de choisir la capacité à utiliser.
     * 
     * @param joueur
     * 			Le combattant choisisant la capacité.
     * 
     * @return Le choix de la capacité sous forme d'entier.
     */
    public int choixCapacite(Combattant joueur){
        Scanner sc = new Scanner(System.in);
        int choix=0;
        
        do{
            System.out.println("Choisissez votre capacitÃ© : ");
            for(int i=0; i<joueur.getCapacite().size();i++){
                System.out.print((i+1)+"-\t"+"capacite : ");
                System.out.println(joueur.getCapacite().get(i).getNom());
            }
            choix=sc.nextInt()-1;
            
        }while(choix<0 || choix>=joueur.getCapacite().size());
        
        System.out.println("Vous venez de choisir : "+ joueur.getCapacite().get(choix).getNom());
        return choix;
    }
    
    /**
     * Permet de choisir la catégorie du coup  à utiliser.
     * @param joueur
     * 				Le combattant choisissant le coup.
     * @param choix
     * 			Le choix du coup.
     * @return Le choix de la catégorie sous forme d'entier.
     */
    public int choixCategorie(Combattant joueur,int choix){
    	Scanner sc = new Scanner(System.in);
    	int coup=0;
        do{
            System.out.println("1-Attaque\n2-Parade\n3-Soin");
            coup=sc.nextInt();
            if(coup<3 &&!joueur.choixCategorie(choix,coup))
                System.out.println("Choisissez une bonne categorie");
        }while(!joueur.choixCategorie(choix,coup));
        
        return coup;
    }
    /**
     * Instancie le combattant choisi.
     * 
     * @param j
     * 		Le combattant à instancier.
     */
    public void choixCombattant(Combattant j){
    	j =cl.init();
    }
    
    /**
     * Le menu principal du jeu.
     */
    public void menu(){
    	Scanner sc = new Scanner(System.in);
    	int choix=0;
    	while(jeu){
            do{
                System.out.println("\n\n1-CrÃ©er votre Personnage\n2-Charger votre Personnage\n3-Quitter le Jeu");
                choix = sc.nextInt();
            }while((choix<0|| choix>3));
            
            if(choix==1){
            	
                this.j1 = new Combattant( cl.init());
                System.out.println("| "+j1.getNom()+" | vie : "+j1.getVitaliteMax()+" |");
                try{
                    this.menuCombat();
                }catch(Exception e){
                	System.out.println("Saisie incorrecte !");
            		this.menuCombat();
                }
            }
            else if(choix==2){
                
                try{
                	j1=new Combattant(this.lire());
                    this.menuChargeCombat();
                }catch(Exception e){
                	System.out.println("Saisie incorrecte !");
                	j1=new Combattant(this.lire());
            		this.menuChargeCombat();
                }
                
            }
            else if(choix==3){
                System.out.println("A Bientot :)");
                jeu=false;
            }
        }
    }
    
    /**
     * Le menu de chargement du combat.
     */
    public void menuChargeCombat(){
    	int choix=0,choix2=0;
    	Scanner sc = new Scanner(System.in);
    	
    	do{
            System.out.println("\n\n1-Combattre\n2-Sauvegarder votre combattant\n3-Modifier vos aptitudes/capacitÃ©es\n4-Retour");
            choix=sc.nextInt();
        }while(choix<0 || choix>4);
    	
        if(choix==1){
        	
            System.out.println("***\t***Combattre***\t***");
            
            do{
                System.out.println("\n\n1-Combattre face Ã  vous mÃªme\n2-Affronter un personnage\n\n3-Retour");
                choix2=sc.nextInt();
            }while(choix2<0|| choix2>3);
            
            if(choix2==1){
                this.j2=new Combattant(this.j1);
                j2.setNom("Ombre de "+this.j1.getNom());
                this.combat();
                this.gagner();
                try{
                    this.menuChargeCombat();
                }catch(Exception e){
                	System.out.println("Saisie incorrecte !");
            		this.menuChargeCombat();
                }
            }
            else if(choix2==2){
            	this.choixJ2();
                this.combat();
                this.gagner();
                try{
                    this.menuSave();
                }catch(Exception e){
                	System.out.println("Saisie incorrecte !");
            		this.menuSave();
                }
            }
            else{
            	try{
                    this.menuChargeCombat();
            	}catch(Exception e){
                	System.out.println("Saisie incorrecte !");
            		this.menuChargeCombat();
                }
            }
        }
        else if(choix==2){
            boolean a = this.j1.sauvegarde();
            if(a)
            	System.out.println("Combattant sauvegardÃ©");
            else
            	System.out.println("Votre joueur est mort ! Impossible d'entamer la sauvegarde :(");
        }
        else if(choix==3){
        	int ch=0;
        	do{
        		System.out.println("1-Modifier vos aptitudes\n2-Modifier vos capacitÃ©s");
        		ch = sc.nextInt();
        	}while(ch<0 || ch>2);
        	
        	if (ch==1){
        		try{
                    this.j1=cl.init();
                    this.menuChargeCombat();
        		}catch(Exception e){
                	System.out.println("Saisie incorrecte !");
                	this.j1=cl.init();
            		this.menuChargeCombat();
                }
        	}
        	else if(ch==2){
                this.cc = new CapacitesConsole();
                this.j1.supprimerCapacite();
                this.cc.initChoixCap(this.j1);
                try{
                    this.menuChargeCombat();
                }catch(Exception e){
                	System.out.println("Saisie incorrecte !");
            		this.menuChargeCombat();
                }
        	}
            
        }
        else if(choix==4){
        	try{
                this.menu();
        	}catch(Exception e){
            	System.out.println("Saisie incorrecte !");
        		this.menu();
            }
        }
    }
    
    public void choixJ2(){
    	int choix=0;
    	Scanner sc = new Scanner(System.in);
    	do{
    		System.out.println("1-Creer le personnage \n2-Charger le personnage\n3-Retour");
    		choix=sc.nextInt();
    	}while(choix<0||choix>3);
    	if(choix==1){
    		this.j2 = new Combattant( cl.init());
    	}
    	else if(choix==2){
    		try{
    			j2=new Combattant(this.lire());
    		}catch(Exception e){
    			System.out.println("Saisie incorrecte !");
    			j2=new Combattant(this.lire());
    		}
    	}
    	else
    		this.menuChargeCombat();
    }
    
    /**
     * Le menu de sauvegarde des combattants.
     */
    public void menuSave(){
    	int choix=0;
    	Scanner sc = new Scanner(System.in);
    	do{
    		System.out.println("1-Sauvegarder le joueur"+this.j1.getNom()+"\n2-Sauvegarder le joueur"+this.j2.getNom()+"\n3- Sauvegarder les deux joueurs\n4-Ne Sauvegarder aucun joueur");
    		choix=sc.nextInt();
    	}while(choix<0 || choix>3);
    	if(choix==1){
    		this.j1.sauvegarde();
    		this.save(this.j1);
    	}
    	else if(choix==2){
    		this.j2.sauvegarde();
    		this.save(this.j2);
    	}
    	else{
            this.j1.sauvegarde();
            this.j2.sauvegarde();
            this.save(this.j1);
            this.save(this.j2);
        }
    	System.out.print("Retour au menu prÃ©cedent ");
    	int i=0;
    	try {
			Thread.sleep(300);
			if(i%3==0)
				System.out.print(".");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	this.menuChargeCombat();
    }
    
    /**
     * Le menu du combat.
     */
    public void menuCombat(){
    	int choix=0,choix2=0;
    	Scanner sc = new Scanner(System.in);
    	do{
            System.out.println("\n\n1-Combattre\n2-Sauvegarder votre combattant\n3-Retour");
            choix=sc.nextInt();
        }while(choix<0 || choix>3);
        if(choix==1){
            System.out.println("***\t***Combattre***\t***");
            do{
                System.out.println("\n\n1-Combattre face Ã  vous mÃªme\n2-Affronter un personnage\n\n3-Retour");
                choix2=sc.nextInt();
            }while(choix2<0|| choix2>3);
            if(choix2==1){
                this.j2=new Combattant(this.j1);
                j2.setNom("Ombre de "+this.j1.getNom());
                this.combat();
                this.gagner();
                try{
                    this.menuChargeCombat();
                }catch(Exception e){
                	System.out.println("Saisie incorrecte !");
                	this.menuChargeCombat();
                }
            }
            else if(choix2==2){
            	try{
                    this.choixJ2();
                    combat();
                    this.gagner();
                    this.menuSave();
            	}catch(Exception e){
                	System.out.println("Saisie incorrecte !");
                	this.choixJ2();
                    combat();
                    this.gagner();
                    this.menuSave();
                }
            }
            else{
            	try{
                    this.menuCombat();
            	}catch(Exception e){
            		System.out.println("Saisie incorrecte !");
            		this.menuCombat();
            	}
            }
        }
        else if(choix==2){
            boolean a = this.j1.sauvegarde();
            this.save(this.j1);
        }
        else{
        	this.menu();
        }
        
    }
    /**
     * Sauvegarde un combattant.
     * 
     * @param joueur
     * 			Le combattant a sauvegardé.
     */
    public void save(Combattant joueur){
        boolean a = joueur.sauvegarde();
        if(a)
            System.out.println("Combattant sauvegardÃ©");
        else
        	System.out.println("Votre joueur "+joueur+" est mort ! Impossible d'entamer la sauvegarde :(");
    }
    
    /**
     * Permet de lire les combattant sauvegardé et d'en chargé un.
     * 
     * @return Le combattant chargé.
     */
    public Combattant lire(){
    	int choix =0;
    	Scanner sc = new Scanner(System.in);
    	Combattant.lire();
    	for(int i=0;i<Combattant.getSauvegarde().size();i++){
    		System.out.println("| "+(i+1)+" -  Nom : "+Combattant.getSauvegarde().get(i).getNom()+" - Vie : "+Combattant.getSauvegarde().get(i).getVitaliteMax()+" - Exp : "+Combattant.getSauvegarde().get(i).getExperience());
    	}
    	do{
    		System.out.println("Choisissez votre combattant : ");
    		choix = sc.nextInt();
    	}while(choix <1 || choix>Combattant.getSauvegarde().size());
    	System.out.println(Combattant.getSauvegarde().get(choix-1));
    	
    	return Combattant.getSauvegarde().get(choix-1);
    }
    
    /**
     * <b>Le menu de copie de capacité du gagnant.</b>
     * <b>Le gagnant peut copier une capacité du perdant</b>
     * 
     * @param gagnant
     * 			Le combattant gagnant.
     * @param perdant
     * 			Le combattant perdant
     */
    public void menuCopieCap(Combattant gagnant,Combattant perdant){
    	int choix =0;
    	Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Choisissez la capacitÃ© Ã  copier: ");
            for(int i=0; i<perdant.getCapacite().size();i++){
                System.out.print((i+1)+"-\t"+"capacite : ");
                System.out.println(perdant.getCapacite().get(i).getNom());
            }
            choix=sc.nextInt()-1;
            
        }while(choix<0 || choix>=perdant.getCapacite().size());
        gagnant.getCapacite().add(perdant.getCapacite(choix));
    }
    
    /**
     * Le menu de fin de combat du gagnant.
     * Le gagnant peut gagner une capacité,copier une capacité du perdant ou modifier ses capacités.
     * @param gagnant
     * 			Le combattant gagnant.
     * @param perdant
     * 			Le combattant perdant.
     */
    public void gagnerJoueur(Combattant gagnant,Combattant perdant){
    	int choix=0;
    	Scanner sc = new Scanner(System.in);
        System.out.println("Le joueur : "+gagnant.getNom()+" a gagnÃ© !!");
        System.out.println("Vous gagnez un point d'expÃ©rience !\n");
        if(gagnant.getExperience()>4 && gagnant.getExperience()%2!=0){
        	do{
         	System.out.println("Vous venez de gagner une nouvelle capacitÃ© !\n1-Modifier toutes vos capacites\n2-Copier une capacitÃ© de votre adversaire");
         	choix = sc.nextInt();
        	}while(choix<0 || choix>2);
        	if(choix==1){
                this.cc = new CapacitesConsole();
                gagnant.supprimerCapacite();
                this.cc.initChoixCap(gagnant);
        	}
        	else{
        		this.menuCopieCap(gagnant, perdant);
        	}
        	System.out.println("Retour au menu prÃ©cedant");
         	
        }
        gagnant.incrExp();
        gagnant.vitaliteCombattant();
        gagnant.setVitalite(gagnant.getVitaliteMax());
        
        System.out.println("Le joueur : "+perdant.getNom()+" vient de perdre :( ");
        if(perdant.getExperience()>1){
            if(perdant.getExperience()>6){
                System.out.println("Vous venez de perdre une capacitÃ© :(");
                perdant.perdreCap();
            }
            perdant.decrExp();
        }
    }
    /**
     * Permet de savoir quel combattant a gagné.
     */
    public void gagner(){
        if((this.j2.finPartie() && !(this.j1.finPartie()))){
        	try{
        		this.gagnerJoueur(this.j2, this.j1);
        	}catch(Exception e){
        		System.out.println("Saisie incorrecte");
        		this.gagnerJoueur(this.j2, this.j1);
        	}
        }
        else{
        	try{
        	this.gagnerJoueur(this.j1, this.j2);
        	}catch(Exception e){
        		System.out.println("Saisie incorrecte");
        		this.gagnerJoueur(this.j1, this.j2);
        	}
        } 
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {		}
    }
}