package model;

public class SpeciesController {

	private Species[] species;

	public SpeciesController() {
		this.species = new Species[80];
	}

	/**
	 * Description: Creates a new instance of a flora object.
	 *
	 * @param type           The type of species.
	 * @param name           The name of the new species.
	 * @param scientificName The scientific name of the new species.
	 * @param hasFlowers     Boolean indicating if the new species has flowers.
	 * @param hasFruits      Boolean indicating if the new species has fruits.
	 * @param maxHeight      Maximum height the species can reach.
	 * @return True if the new species could be created; otherwise, false.
	 */
	public boolean registerSpeciesFlora(int type, String name, String scientificName, int hasFlowers, int hasFruits,
			double maxHeight) {
		// Variables of work:
		SpeciesType realType;
		boolean realHasFlowers;
		boolean realHasFruits;

		realType = transformType(type);
		realHasFlowers = transformFlowers(hasFlowers);
		realHasFruits = transformFruits(hasFruits);

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = new Flora(realType, name, scientificName, realHasFlowers, realHasFruits, maxHeight);
				return true;
			}
		}

		return false;
	}

	/**
	 * Description: Creates a new instance of a fauna object.
	 *
	 * @param type           The type of species.
	 * @param name           The name of the new species.
	 * @param scientificName The scientific name of the new species.
	 * @param isMigrant      Boolean indicating if the new species is migrant.
	 * @param maxWeight      Maximum weight the species can reach.
	 * @return True if the new species could be created; otherwise, false.
	 */
	public boolean registerSpeciesFauna(int type, String name, String scientificName, int isMigrant, double maxWeight) {
		// Variables of work:
		SpeciesType realType;
		boolean realIsMigrant;

		realType = transformType(type);
		realIsMigrant = transformMigrant(isMigrant);

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = new Fauna(realType, name, scientificName, realIsMigrant, maxWeight);
				return true;
			}
		}

		return false;
	}

	/**
	 * Description: Transforms the int typed by the user into the class needed for
	 * the
	 * constructor of a new species.
	 *
	 * @param intType The information typed by the user.
	 * @return The data required.
	 */
	private SpeciesType transformType(int intType) {
		// Variables of work:
		SpeciesType realType;

		switch (intType) {
			case 1:
				realType = SpeciesType.FLORA;
				break;
			case 2:
				realType = SpeciesType.FAUNA;
				break;
			default:
				realType = SpeciesType.FLORA;
				break;
		}

		return realType;
	}

	/**
	 * Description: Transforms the int typed by the user into the value needed for
	 * the
	 * constructor of a new flora species.
	 *
	 * @param hasFlowers The information typed by the user.
	 * @return The data required.
	 */
	private boolean transformFlowers(int hasFlowers) {
		boolean realHasFlowers;

		switch (hasFlowers) {
			case 1:
				realHasFlowers = true;
				break;
			case 2:
				realHasFlowers = false;
				break;
			default:
				realHasFlowers = true;
				break;
		}

		return realHasFlowers;
	}

	/**
	 * Description: Transforms the int typed by the user into the value needed for
	 * the
	 * constructor of a new flora species.
	 *
	 * @param hasFruits The information typed by the user.
	 * @return The data required.
	 */
	private boolean transformFruits(int hasFruits) {
		boolean realHasFruits;

		switch (hasFruits) {
			case 1:
				realHasFruits = true;
				break;
			case 2:
				realHasFruits = false;
				break;
			default:
				realHasFruits = true;
				break;
		}

		return realHasFruits;
	}

	/**
	 * Description: Transforms the int typed by the user into the value needed for
	 * the
	 * constructor of a new fauna species.
	 *
	 * @param isMigrant The information typed by the user.
	 * @return The data required.
	 */
	private boolean transformMigrant(int isMigrant) {
		boolean realIsMigrant;

		switch (isMigrant) {
			case 1:
				realIsMigrant = true;
				break;
			case 2:
				realIsMigrant = false;
				break;
			default:
				realIsMigrant = true;
				break;
		}

		return realIsMigrant;
	}

	/**
	 * Description: Joins all the information about all instances created so far.
	 *
	 * @return The string of information.
	 */
	public String showSpeciesList() {
		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg += "\n" + (i + 1) + ". " + species[i].getName();
			}
		}

		return msg;
	}

	/**
	 * Description: Searches for a species using the name.
	 *
	 * @param name The name to search for.
	 * @return The species object, or null if not found.
	 */
	private Species searchSpecie(String name) {
		// Variables of work:
		int i;

		for (i = 0; i < species.length; i++) {
			if (species[i] != null && species[i].getName().equals(name)) {
				return species[i];
			}
		}
		return null;
	}

	/**
	 * Description: Returns the type of species as an integer (1 for Flora, 2 for
	 * Fauna).
	 *
	 * @param name The name of the species to check.
	 * @return The integer representing the species type (1 for Flora, 2 for Fauna).
	 */
	public int whatIs(String name) {
		// Variables of work:
		Species theSpecie;
		int forTheExe = 0;

		theSpecie = searchSpecie(name);

		if (theSpecie != null) {
			if (theSpecie.getType().equals(SpeciesType.FLORA)) {
				forTheExe = 1;
			} else if (theSpecie.getType().equals(SpeciesType.FAUNA)) {
				forTheExe = 2;
			}
		}

		return forTheExe;
	}

	/**
	 * Description: Edits a species based on the name and selected option.
	 *
	 * @param name      The name of the species.
	 * @param whatIs    The type of species (1 for Flora, 2 for Fauna).
	 * @param option    The specific field to change.
	 * @param theChange The new value to set.
	 * @return True if the species was successfully edited, false if not.
	 */
	public boolean editASpecie(String name, int whatIs, int option, String theChange) {
		// Variables of work:
		Species theSpecie;

		theSpecie = searchSpecie(name);
		if (theSpecie == null) {
			return false;
		}

		if (whatIs == 1 && theSpecie instanceof Flora) {
			Flora floraSpecie = (Flora) theSpecie;
			switch (option) {
				case 1:
					floraSpecie.setName(theChange);
					break;
				case 2:
					floraSpecie.setScientificName(theChange);
					break;
				case 3:
					floraSpecie.setHasFlowers(Integer.parseInt(theChange) == 1);
					break;
				case 4:
					floraSpecie.setHasFruits(Integer.parseInt(theChange) == 1);
					break;
				case 5:
					floraSpecie.setMaxHeight(Double.parseDouble(theChange));
					break;
				default:
					return false;
			}
		} else if (whatIs == 2 && theSpecie instanceof Fauna) {
			Fauna faunaSpecie = (Fauna) theSpecie;
			switch (option) {
				case 1:
					faunaSpecie.setName(theChange);
					break;
				case 2:
					faunaSpecie.setScientificName(theChange);
					break;
				case 3:
					faunaSpecie.setMigrant(Integer.parseInt(theChange) == 1);
					break;
				case 4:
					faunaSpecie.setMaxWeight(Double.parseDouble(theChange));
					break;
				default:
					return false;
			}
		} else {
			return false;
		}

		return true;
	}

	/**
	 * Description: This method deletes a species from the species array based on
	 * its name.
	 * It searches for the species by its name, and if found, removes it from the
	 * array by setting
	 * its position to `null`. If the species is not found, the method returns
	 * `false`.
	 *
	 * @param nameOfSpecie The name of the species to be deleted.
	 * @return `true` if the species was successfully deleted, `false` if the
	 *         species was not found.
	 */
	public boolean deleteSpecies(String nameOfSpecie) {
		// Variables of work:
		Species specieToDelete;
		int i;

		specieToDelete = searchSpecie(nameOfSpecie);

		for (i = 0; i < species.length; i++) {

			if (species[i] != null && species[i].equals(specieToDelete)) {

				species[i] = null;

				return true;
			}
		}

		return false;
	}

	/**
	 * Retrieves detailed information about a species based on its name.
	 * 
	 * This method searches for a species by its name and returns its basic
	 * information.
	 *
	 * @param specieName The name of the species to search for.
	 * @return A string containing the basic information of the species.
	 *         If the species is found, it returns its information otherwise, it may
	 *         return an empty string.
	 */
	public String showInformationOfSpecie(String specieName) {
		// Variables of work:
		Species specieToShow;
		String information = "";

		specieToShow = searchSpecie(specieName);

		if (specieToShow instanceof Fauna) {
			Fauna faunaSpecie = (Fauna) specieToShow;

			information = faunaSpecie.toString();

		} else if (specieToShow instanceof Flora) {

			Flora floraSpecie = (Flora) specieToShow;

			information = floraSpecie.toString();
			
		}

		return information;
	}
}
