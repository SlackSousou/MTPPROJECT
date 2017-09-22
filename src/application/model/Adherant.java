package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;


public class Adherant {


	//*****************************VARIABLE*******************************

	private IntegerProperty identifiant;
	private StringProperty nom ;
	private StringProperty prenom;
	private String adresse;


	//*****************************CONSTRUCTEUR*******************************

	public Adherant(IntegerProperty id, StringProperty nom, StringProperty prenom, String adresse) {
		super();
		this.identifiant = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public Adherant() {
		super();
	}


	//*****************************METHODE*******************************

	public IntegerProperty identifiantProperty(){
		return identifiant;
	}

	public int getIdentifiant() {
		return identifiant.get();
	}


	public void setIdentifiant(int id) {
		this.identifiant.set(id);

	}



	public StringProperty nomProperty() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom.set(nom);
	}
	public String getNom() {
		return nom.get();
	}
	
	
	
	
	
	public StringProperty prenomProperty() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}
	public String getPrenom() {
		return prenom.get();
	}
	
	
	//************************




	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	//public String toString(){
	//	return prenom;
}
