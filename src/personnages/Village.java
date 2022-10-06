package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;

	public Village(String nom,int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois=new Gaulois[nbVillageoisMaximum];
	}
	public void ajouterHabitant(Gaulois gaulois) {

		if(nbVillageois<=villageois.length) {

			villageois[nbVillageois]=gaulois;
			nbVillageois++;
		}
	}
	public Gaulois trouverHabitant(int numVillageois) {

		return villageois[numVillageois-1];
	}
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+chef.getNom()+ " vivent les légendaires :");
		for(int i=0;i<nbVillageois;i++) {
			System.out.println("-"+ villageois[i].getNom());
		}

	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	public static void main(String[] args) {
		Village village1=new Village("Village des Irréductible",30);
		Chef abraracourcix = new Chef("Abraracourcix",10,village1);
		Gaulois obélix = new Gaulois("Obélix",8);
		Gaulois asterix = new Gaulois("Asterix",8);
		village1.ajouterHabitant(obélix);
		village1.ajouterHabitant(asterix);
		village1.setChef(abraracourcix);
		// Gaulois gaulois1 = village.trouverHabitant(30);
		Gaulois gaulois = village1.trouverHabitant(0);
		//System.out.println(gaulois);
		village1.afficherVillageois();
		
	}

}
