package application.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Helper class to wrap a list of persons. This is used for saving the
 * list of persons to XML.
 * 
 * 
 */
@XmlRootElement(name = "data")
@XmlType(propOrder = {"representation","adherant"})

public class DataListWrapper {

	private List<Representation> representations;

	@XmlElementWrapper(name="representations")
	@XmlElement(name = "representation")
	public List<Representation> getRepresentation() {
		return (List<Representation>) representations;
	}

	public void setRepresentation(List<Representation> representations) {
		this.representations = representations;
	}

	private List<Adherant> adherants;

	@XmlElementWrapper(name="adherants")
	@XmlElement(name = "adherant")
	public List<Adherant> getAdherant() {
		return (List<Adherant>) adherants;
	}

	public void setAdherant(List<Adherant> adherants) {
		this.adherants = adherants;
	}

}

