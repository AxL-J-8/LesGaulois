
package personnages;
import java.util.*;
public class Druide {

	 private String nom; 
	 private int forcePotion=1;
	 private int effetPotionMin; 
	 private int effetPotionMax; 
	 
	 public Druide(String nom, int effetPotionMin, int effetPotionMax) { 
	 this.nom = nom; 
	 this.effetPotionMin = effetPotionMin; 
	 this.effetPotionMax = effetPotionMax; 
	 parler("Bonjour,  je  suis  le  druide  "  +  nom  +  "  et  ma  potion  peut  aller d'une force " + effetPotionMin + " � " + effetPotionMax + "."); 
	 } 
	 public void preparerPotion() {
          Random r =new Random();
		 forcePotion= r.nextInt(effetPotionMax);
		 while(forcePotion<effetPotionMin) {
			 forcePotion= r.nextInt(effetPotionMax);
		 }
		 if (forcePotion>7) {
			 parler("J'ai  préparé une super potion de force "+ forcePotion);
		 }
		 else {
			 parler("Je  n'ai  pas  trouv�  tous  les  ingr�dients,  ma  potion  est seulement de force "+ forcePotion);
		 }
	 }
	 public void booster(Gaulois gaulois) {
		 if (gaulois.getNom()=="Ob�lix") {
			 parler("Non, Ob�lix !... Tu n'auras pas de potion magique !");
		 }
		 else {
		 gaulois.boirPotion(forcePotion);
		 }
	 }
	 public String getNom() { 
	 return nom; 
	 } 
	 public void parler(String texte) { 
	   System.out.println(prendreParole() + "<< " + texte + ">>"); 
	 } 
	 private String prendreParole() { 
	 return "Le druide " + nom + " : "; 
	 } 
	 public static void main(String[] args) {
		 Druide panoramix = new Druide("Panoramix",5,10);
		 panoramix.preparerPotion();
		 panoramix.preparerPotion();
		 panoramix.preparerPotion();
		 panoramix.preparerPotion();
	 }
	 
}
