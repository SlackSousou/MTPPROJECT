package application.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

public class Representation {
	//*****************************VARIABLE*******************************

		private IntegerProperty numRepresentation;
		private IntegerProperty numSpectacle;
		private IntegerProperty numSalle;
		private LocalDate dateRepresentation;
		private static int tarif;


		//*****************************CONSTRUCTEUR*******************************

		public Representation(IntegerProperty numRepresentation,IntegerProperty numSpectacle, IntegerProperty numSalle, LocalDate dateRepresentation, int Tarif) {
			super();
			this.dateRepresentation = dateRepresentation;
		}

		public Representation() {
			super();
		}

		public IntegerProperty getNumRepresentation() {
			return numRepresentation;
		}

		public void setNumRepresentation(IntegerProperty numRepresentation) {
			this.numRepresentation = numRepresentation;
		}

		public IntegerProperty getNumSpectacle() {
			return numSpectacle;
		}

		public void setNumSpectacle(IntegerProperty numSpectacle) {
			this.numSpectacle = numSpectacle;
		}

		public IntegerProperty getNumSalle() {
			return numSalle;
		}

		public void setNumSalle(IntegerProperty numSalle) {
			this.numSalle = numSalle;
		}

		public ObjectProperty<LocalDate> getDateRepresentation() {
			return dateRepresentation;
		}

		public void setDateRepresentation(ObjectProperty<LocalDate> dateRepresentation) {
			this.dateRepresentation = dateRepresentation;
		}

		public static int getTarif() {
			return tarif;
		}

		public static void setTarif(int tarif) {
			Representation.tarif = tarif;
		}


		//*****************************METHODE*******************************

		
}
