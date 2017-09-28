package application.model;

import java.sql.Date;
import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Representation {


	//*****************************VARIABLE*******************************

	private int numRepresentation;
	private String nomSpectacle;
	private LocalDate dateRepresentation;
	private  Double tarif;


	
	
	public int numRepresentation() {
		return numRepresentation;
	}

	/*public int getNumRepresentation() {
		return numRepresentation.get();
	}*/

	public void setNumRepresentation(int numRepresentation) {
		this.numRepresentation=numRepresentation;

	}

	///////////////////


	public String nomSpectacle() {
		return nomSpectacle;
	}

	/*public String getNomSpectacle() {
		return nomSpectacle.get();
	}*/
	
	public void setNomSpectacle(String nomSpectacle) {
		this.nomSpectacle=nomSpectacle;
	}

	//////////////////////////



	public LocalDate dateRepresentation(){
		return dateRepresentation;
	}

	/*public LocalDate getDateRepresentation() {
		return dateRepresentation.get();
	}*/

	public void setDateRepresentation(LocalDate date) {
		this.dateRepresentation=date;
	}

	/////////////////////


	public Double tarif() {
		return tarif;
	}

	/*public Double getTarif() {
		return tarif.get();
	}*/

	public  void setTarif(double tarif) {
		this.tarif=tarif;
	}

	@Override
	public String toString() {
		return nomSpectacle + " - " + dateRepresentation ;
	}
	
	
	
	
}





