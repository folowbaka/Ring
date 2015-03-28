package capacite;
import combattant.*;
/**
 * <b>L'interface Capacite est l'interface que toutes les capacités devront implementer</b>
 *<b>Elles devront donc redéfinir toutes les méthodes de Capacite.$
 */
public interface Capacite {
    
	public static final int ATTAQUE = 1;
	public static final int PARADE = 2;
	public static final int SOIN = 3;
	public String Categorie[] = { "Attaque", "Parade", "Soin" };
    
	public boolean reussite(Combattant joueur);
    
	public void description();
	public String getDescription();
	public String getNom();
    
	public boolean categorie(int categorie,Combattant joueur);
    
	public int capacite(int coup,Combattant joueur);
    
}
