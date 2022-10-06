package personnages;

public class Romain {

	private String nom; 
	private int force; 
	public Romain(String nom, int force) { 
		this.nom = nom; 
		assert (force>0);
		this.force = force; 
	} 
	public String getNom() { 
		return nom; 
	} 
	public void parler(String texte) { 
		System.out.println(prendreParole() + "<<" + texte + ">>"); 
	} 
	private String prendreParole() { 
		return "Le romain " + nom + " : "; 
	} 
	public void recevoirCoup(int forceCoup) { 
		assert(force>0);
		int temp=force;
		force -= forceCoup;
		
		if (force > 0) { 
			parler("Aie"); 
		} else { 
			parler("J'abandonne..."); 
		} 
		assert((temp-force)>0);
	} 
	public static void main(String[] args) {
		Romain minus= new Romain("Minus",6);
		System.out.println(Equipement.CASQUE);
        System.out.println(Equipement.BOUCLIER);


	}
} 

