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
	private Double tarif;


	
	
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

	public Double getTarif() {
		return tarif;
	}

	public  void setTarif(double tarif) {
		this.tarif=tarif;
	}

	@Override
	public String toString() {
		return nomSpectacle + " - " + dateRepresentation ;
	}
	
	
	
	
}

/*
package metier;



import javafx.beans.property.ObjectProperty;

import javafx.beans.property.SimpleObjectProperty;

import javafx.beans.property.SimpleStringProperty;

import javafx.beans.property.StringProperty;



public class Representation {

    

    private final StringProperty dateRepresentation;

    private final StringProperty nomSpectacle;

    private final StringProperty tarif;

    private final StringProperty numRepresentation;



    

    private final ObjectProperty<Representation> representationComboBox;



    // Constructeur

        public Representation() {

                    

            this.dateRepresentation = new SimpleStringProperty();

            this.nomSpectacle = new SimpleStringProperty();

            this.tarif = new SimpleStringProperty();

            this.numRepresentation = new SimpleStringProperty();

            

            this.representationComboBox = new SimpleObjectProperty<Representation>();

    

        }



        // Getters et setters

        public String getDateRepresentation() {return dateRepresentation.get();}

        public void setDateRepresentation(String dateRepresentation) {this.dateRepresentation.set(dateRepresentation);}            

        public StringProperty dateRepresentationProperty() {return dateRepresentation;}

        

        public String getNomSpectacle() {return nomSpectacle.get();}

        public void setNomSpectacle(String nomSpectacle) {this.nomSpectacle.set(nomSpectacle);}

        public StringProperty nomSpectacleProperty() {return nomSpectacle;}

        

        public String getTarif() {return tarif.get();}

        public void setTarif(String tarif) {this.tarif.set(tarif);}

        public StringProperty TarifProperty() {return tarif;}

        

        public String getNumRepresentation() {return numRepresentation.get();}

        public void setNumRepresentation(String numRepresentation) {this.numRepresentation.set(numRepresentation);}

        public StringProperty numRepresentationProperty() {return numRepresentation;}

        

        public Representation getRepresentationComboBox() {return representationComboBox.get();}

        public void setRepresentationComboBox(Representation representationComboBox) {this.representationComboBox.set(representationComboBox);}            

        public ObjectProperty<Representation> representationComboBox() {return representationComboBox;}

        

        



        @Override

        public String toString() {return this.getDateRepresentation() + " " + this.getNomSpectacle();}
*/



