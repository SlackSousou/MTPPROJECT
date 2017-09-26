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
		private static double tarif;


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

		public void setNumRepresentation(IntegerProperty representation ) {
			this.numRepresentation = representation;
		}

		public IntegerProperty getNumSpectacle() {
			return numSpectacle;
		}

		public void setNumSpectacle(IntegerProperty spectacle) {
			this.numSpectacle = spectacle;
		}

		public IntegerProperty getNumSalle() {
			return numSalle;
		}

		public void setNumSalle(IntegerProperty string) {
			this.numSalle = string;
		}

		public LocalDate getDateRepresentation() {
			return dateRepresentation;
		}

		public void setDateRepresentation(LocalDate dateRepresentation) {
			this.dateRepresentation = dateRepresentation;
		}

		public static double getTarif() {
			return tarif;
		}

		public static void setTarif(double tarif) {
			Representation.tarif = tarif;
		}

		


		//*****************************METHODE*******************************

		
}
