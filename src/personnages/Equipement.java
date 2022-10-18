package personnages;

public enum Equipement {
	BOUCLIER("bouclier"),CASQUE("casque");
	
private String nom;
public String getNom() {
	return nom;
}
private Equipement(String nom) {
	this.nom=nom;
}
public String toString() { return nom;}
}
