package dialogueConsole;

import java.util.Scanner;

import sort.*;
import cac.*;
import capacite.*;
import combattant.*;

/**
 * 
 * CapacitesConsole g�re les diverses affectations des caract�ristiques des divers capacit�s du  jeu par l'utilisateur.
 *
 */
public class CapacitesConsole {
	private Epee e=null;
	private Bouclier b=null;
	private Sort s=null;
	
    public void initChoixCap(Combattant j){
        for(int i=0;i<j.nbCapacite();i++){
            try{
	            this.init(j,i);
            }catch(Exception e){
                System.out.println("Saisie incorrecte !");
                this.init(j,i);
            }
        }
    }
    
    public void init(Combattant j,int i){
        Scanner sc = new Scanner(System.in);
        int cap = 0,des=0;
        do{
            System.out.println("Veuillez choisir votre capacité : \n1-Epee\n2-Bouclier\n3-Sortilège offensif\n4-Sortilège defensif\n5-Remede\n6-Sortilège guerisseur");
            cap =sc.nextInt();
        }while(cap<0||cap>6);
        System.out.println(cap);
        switch(cap){
            case 1 :
                this.e = new Epee() ;
                if(this.initDescription(this.e)==1){
                    this.initEpee();
                    j.getCapacite().add(this.e);
                }
                else
                    init(j,i);
                break;
            case 2:
                this.b = new Bouclier();
                if(this.initDescription(this.b)==1){
                    j.getCapacite().add(this.b);
                }
                else
                    init(j,i);
                break;
            case 3 :
                this.s = new SortilegeOffensif() ;
                break;
            case 4 :
                this.s = new SortilegeDefensif() ;
                break;
            case 5 :
                this.s = new Remede();
                break;
            default :
                this.s = new SortilegeGuerisseur();
                break;
                
        }
        if(cap>=3){
            des = this.initDescription(this.s);
            if(des==1){
                this.initSort();
                j.getCapacite().add(this.s);
            }
            else
                init(j,i);
        }
        System.out.println("\nVous venez de choisir "+ j.getCapacite().get(i).getNom()+"!\n");
    }
    
	public int initDescription(Capacite cap){
		int choix=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Description de "+cap.getNom()+" : \n\t"+cap.getDescription());
		do{
			System.out.println("1-Choisir\n2-Retour");
			choix = sc.nextInt();
		}while(choix<0||choix>2);
		
		return choix;
	}
	public void initEpee(){
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("Veuillez saisir l'impact de votre épée");
            this.e.setImpact(sc.nextInt());
            System.out.println("Veuillez saisir la parade de votre épée");
            this.e.setParade(sc.nextInt());
            System.out.println("Veuillez saisir la maniabilité de votre épée");
            this.e.setManiabilite(sc.nextInt());
        }while(!this.e.caracteristique());
	}
	public void initBouclier(){
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Veuillez saisir la maniabilité de votre bouclier");
			this.b.setManiabilite(sc.nextInt());
			System.out.println("Veuillez saisir la protection de votre bouclier");
			this.b.setProtection(sc.nextInt());
		}while(!this.b.caracteristique());
	}
	
	public void initSort(){
		do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez saisir l'efficacité de votre sort");
            this.s.setEfficacite(sc.nextInt());
            System.out.println("Veuillez saisir la facilité de votre sort");
            this.s.setFacilite(sc.nextInt());
		}while(!this.s.caracteristique());
	}
	
	
    
}
