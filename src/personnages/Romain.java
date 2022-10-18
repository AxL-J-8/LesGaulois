package personnages;

public class Romain {
	private String texte;
	private String nom; 
	private int force; 
	private Equipement[] equipements;
	private int nbEquipement=0;
	public Romain(String nom, int force) { 
		this.nom = nom; 
		assert (force>0);
		this.force = force; 
		this.equipements= new Equipement[2];
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
	//	public void recevoirCoup(int forceCoup) { 
	//		assert(force>0);
	//		int temp=force;
	//		force -= forceCoup;
	//
	//		if (force > 0) { 
	//			parler("Aie"); 
	//		} else { 
	//			parler("J'abandonne..."); 
	//		} 
	//		assert((temp-force)>0);
	//	} 

	public Equipement[] recevoirCoup(int forceCoup) { 
		Equipement[] equipementEjecte = null; 
		// précondition 
		assert force > 0; 
		int oldForce = force; 
		forceCoup = CalculResistanceEquipement(forceCoup); 
		force -= forceCoup; 
		//  if (force > 0) { 
		//  parler("Aïe"); 
		//  } else { 
		//  equipementEjecte = ejecterEquipement(); 
		//  parler("J'abandonne..."); 
		//  } 

		switch (force) { 
		case 0: 
			parler("Aïe"); 
		default: 
			equipementEjecte = ejecterEquipement(); 
			parler("J'abandonne..."); 
			break; 
		} 
		// post condition la force à diminuer 
		assert force < oldForce; 
		return equipementEjecte; 
	}

	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {

		case 1: if(equipements[nbEquipement-1].getNom()==equipement.getNom()) {
			System.out.println("Le soldat "+nom+" possède déja un "+equipement.getNom()+" ! ");
		}
		else {
			equiperSoldat(equipement);
		}
		break;
		case 2:  System.out.println("Le soldat "+nom +" est déjà bien protégé ! ");break;
		default: 
			if (nbEquipement<2) {
				equiperSoldat(equipement);
			}
			break;
		}
	}

	private int CalculResistanceEquipement(int forceCoup) { 
		texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup; 
				int resistanceEquipement = 0; 
		if (!(nbEquipement == 0)) { 
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de "; 
					for (int i = 0; i < nbEquipement;) { 
						if ((equipements[i] != null && 
								equipements[i].equals(Equipement.BOUCLIER)) == true) { 
							resistanceEquipement += 8; 
						} else { 
							System.out.println("Equipement casque"); 
							resistanceEquipement += 5; 
						} 
						i++; 
					} 
			texte =+ resistanceEquipement + "!"; 
		} 
		parler(texte); 
		forceCoup -= resistanceEquipement; 
		return forceCoup; 
	} 
	private Equipement[] ejecterEquipement() { 
		Equipement[] equipementEjecte = new Equipement[nbEquipement]; 
		System.out.println("L'équipement  de  "  +  nom.toString()  +  " s'envole sous la force du coup."); 
		//TODO 
		int nbEquipementEjecte = 0; 
		for (int i = 0; i < nbEquipement; i++) { 

			if (equipements[i] == null) { 
				continue; 
			} else { 
				equipementEjecte[nbEquipementEjecte]  = 
						equipements[i]; 
				nbEquipementEjecte++; 
				equipements[i] = null; 
			} 
		} 
		return equipementEjecte; 
	} 
	private void equiperSoldat(Equipement equipement) {
		equipements[nbEquipement]=equipement;
		nbEquipement++;
		System.out.println("Le soldat "+nom+" s'équipe avec un "+equipement.getNom());

	}

	public static void main(String[] args) {
		Romain minus= new Romain("Minus",6);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);      
		minus.sEquiper(Equipement.CASQUE);      
		minus.sEquiper(Equipement.BOUCLIER);      
		minus.sEquiper(Equipement.BOUCLIER);      
	}
} 

