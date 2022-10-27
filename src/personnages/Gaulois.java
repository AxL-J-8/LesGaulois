package personnages;


public class Gaulois  { 
	private String nom; 
	private int force; 
	private int effetPotion = 1; 
	private int nbTrophees; 
	private Equipement[] trophees = new Equipement[100];
	public Gaulois(String nom, int force) { 
		this.nom = nom; 
		this.force = force; 
	} 
	public String getNom() { 
		return nom; 
	} 
	public void parler(String texte) { 
		System.out.println(prendreParole() + "<<" + texte + ">>"); 
	} 
	//	private String prendreParole() { 
	//		return "Le gaulois " + nom + " : "; 
	//	} 

	private String prendreParole() { 
		return "Le gaulois " + nom + " : "; 
	}
	public void boirPotion(int forcePotion) {
		effetPotion=forcePotion;
		parler("Merci Druide, je sens que ma force est "+ effetPotion +" fois d�cupl�e. ");
	}
	//	public void frapper(Romain romain) { 
	//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom()); 
	//		romain.recevoirCoup((force / 3)*effetPotion); 
	//	} 

	public void frapper(Romain romain) { 
		System.out.println(nom  +  "  envoie  un  grand  coup  dans la m�choire de " + romain.getNom()); 
				Equipement[] tropheesGagner  =  romain.recevoirCoup((force  /  3)  * effetPotion); 
		for  (int  i  =  0;  tropheesGagner  !=  null  &&  i  <  tropheesGagner.length;  i++, 
				nbTrophees++) { 
			this.trophees[nbTrophees] = tropheesGagner[i]; 
		} 

	}
	@Override 
	public String toString() { 
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]"; 
	} 
	public static void main(String[] args) {
		Gaulois asterix= new Gaulois("Asterix",3);
		asterix.boirPotion(8);
	}

}



