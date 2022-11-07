package personnages;

public class Romain {
	private String nom; 
	private int force; 
	private Equipement[] equipements;
	private int nbEquipement=0;
	
	
	public Romain(String nom, int force){ 
		this.nom = nom; 
		assert force>0;
		this.force = force; 
		this.equipements= new Equipement[2];
	} 
	
	
	public String getNom(){ 
		return nom; 
	} 
	
	
	public void parler(String texte){ 
		System.out.println(prendreParole() + "<<" + texte + ">>"); 
	}
	
	
	private String prendreParole(){ 
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
		// pr�condition 
		assert force > 0; 
		int oldForce = force; 
		forceCoup = calculResistanceEquipement(forceCoup); 
		force -= forceCoup; 
		//  if (force > 0) { 
		//  parler("A�e"); 
		//  } else { 
		//  equipementEjecte = ejecterEquipement(); 
		//  parler("J'abandonne..."); 
		//  } 

	    if(force>0) {
	    	
			parler("A�e");
	    }
	    else { 
			equipementEjecte = ejecterEquipement(); 
			parler("J'abandonne..."); 
		} 
		// post condition la force � diminuer 
		assert force < oldForce; 
		return equipementEjecte; 
	}

	
	public void sEquiper(Equipement equipement) {
		assert nbEquipement<=2;
		switch(nbEquipement) {

		case 1: 
			    if(equipements[nbEquipement-1].getNom().equals(equipement.getNom())) {
			    	leSoldat("poss�de d�ja un "+equipement.getNom()+" ! ");
		        }
		        else {
			    equiperSoldat(equipement);
		        }
		        break;
		case 2:   
			    leSoldat(" est d�j� bien prot�g� ! ");break;
		case 0:
				equiperSoldat(equipement);
			    break;
		}
	}

	
	private int calculResistanceEquipement(int forceCoup) { 
		
		String texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup; 
		int resistanceEquipement = 0; 
		if (nbEquipement != 0) { 
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de "; 
					for (int i = 0; i < nbEquipement;i++) { 
						if ((equipements[i] != null && 
								equipements[i].equals(Equipement.BOUCLIER))) { 
							resistanceEquipement += 8; 
						} else { 
							System.out.println("Equipement casque"); 
							resistanceEquipement += 5; 
						} 
					} 
			texte += resistanceEquipement + "!"; 
		} 
		parler(texte); 
		forceCoup -= resistanceEquipement; 
		return forceCoup; 
	} 
	
	
	private Equipement[] ejecterEquipement() { 
		Equipement[] equipementEjecte = new Equipement[nbEquipement]; 
		System.out.println("L'�quipement  de  "  +  nom  +  " s'envole sous la force du coup."); 
		int nbEquipementEjecte = 0; 
		for (int i = 0; i < nbEquipement; i++) { 

			if (equipements[i] != null) { 
				equipementEjecte[nbEquipementEjecte]=equipements[i]; 
				nbEquipementEjecte++; 
				equipements[i] = null; 
			} 
		} 
		nbEquipement-=nbEquipementEjecte;
		return equipementEjecte; 
	} 
	
	
	private void equiperSoldat(Equipement equipement) {
		equipements[nbEquipement]=equipement;
		nbEquipement++;
		leSoldat("s'�quipe avec un "+equipement.getNom());

	}
	
	
    private void leSoldat(String message) {
    	System.out.println("Le soldat "+nom+message);
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


	public int getForce() {
		return force;
	}
} 

