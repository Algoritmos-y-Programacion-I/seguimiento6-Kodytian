package model;

public abstract class Species {

	private String name;
	private String scientificName;
	private SpeciesType type;

	public Species(SpeciesType type, String name, String scientificName) {
		this.name = name;
		this.scientificName = scientificName;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public SpeciesType getType() {
		return type;
	}

	public void setType(SpeciesType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type + ": Named " + name + " - " + scientificName;
	}
}
