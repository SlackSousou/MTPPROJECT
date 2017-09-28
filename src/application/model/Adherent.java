package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Adherent {


	//*****************************VARIABLE*******************************

	private int identifiant;
	private String nom ;
	private String prenom;


	//*****************************CONSTRUCTEUR*******************************

	public Adherent(int id, String nom, String prenom) {
		super();
		
	//	this.identifiant = new SimpleIntegerProperty(id);
	//	this.nom = new SimpleStringProperty(nom);
	//	this.prenom = new SimpleStringProperty(prenom);
		
	}

	public Adherent() {
		super();
	}


	//*****************************METHODE*******************************

	public int identifiant(){
		return identifiant;
	}

	/*	public int getIdentifiant() {
		return identifiant.get();
	}	*/


	public void setIdentifiant(int id) {
		this.identifiant=id;

	}



	public String nom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom=nom;
	}
	/*public String getNom() {
		return nom.get();
	}*/
	
	
	
	
	
	public String prenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom=prenom;
	}
	/*public String getPrenom() {
		return prenom.get();
	}
	*/


	@Override
	public String toString() {
		return nom+" " + prenom;
	}

	
}
