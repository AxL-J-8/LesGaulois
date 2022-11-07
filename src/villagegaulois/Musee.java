package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;
import personnages.Trophee;

public class Musee {
	Trophee[] trophees;
	int nbTrophee=0;



	public Musee() {
		trophees= new Trophee[200];
		
	}



	public void donnerTrophees(Gaulois gaulois,Equipement equipement) {
		assert nbTrophee<200;

		trophees[nbTrophee]=new Trophee(gaulois,equipement);

		nbTrophee++;
	}
public String extraireInstructionsCaml() {
	String text="let musee= [";
	int i=0;
    for ( i=1;i<nbTrophee;i++) {
    	text=text+trophees[i-1].getGaulois().getNom()+","+trophees[i-1].getEquipement().getNom()+";";
    }
    text+= trophees[i-1].getGaulois().getNom()+","+trophees[i-1].getEquipement().getNom()+"]";
    return text;
}

}
