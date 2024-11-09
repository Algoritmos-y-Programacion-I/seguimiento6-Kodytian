package ui;

import java.util.Scanner;
import model.SpeciesController;

public class SpeciesExecutable {

	private Scanner reader;
	private SpeciesController speciesController;

	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	public SpeciesExecutable() {
		reader = new Scanner(System.in);
		speciesController = new SpeciesController();
	}

	public void showMainMenu() {
		System.out.println("Welcome to Icesi Species!");

		boolean stopFlag = false;

		while (!stopFlag) {
			System.out.println("\nChoose an option:");
			System.out.println("[1] Register a species.");
			System.out.println("[2] Edit a species.");
			System.out.println("[3] Delete a species.");
			System.out.println("[4] Show a species information.");
			System.out.println("[0] Exit.");

			int mainOption = reader.nextInt();

			switch (mainOption) {
				case 1:
					registerSpecies();
					break;
				case 2:
					editSpecies();
					break;
				case 3:
					deleteSpecies();
					break;
				case 4:
					showInformationAboutASpecie();
					break;
				case 0:
					System.out.println("\nThanks for using our system :D");
					stopFlag = true;
					break;
				default:
					System.out.println("\nPlease choose a valid option.");
					break;
			}
		}
	}

	public void registerSpecies() {
		// Variables of work:
		int specieType;
		String name;
		String scientificName;
		int hasFlowers;
		int hasFruits;
		double maxHeight;
		int isMigrant;
		double maxWeight;
		boolean created;

		System.out.println("\nEnter the class of the new species:");
		System.out.println("[1] Flora.");
		System.out.println("[2] Fauna.");
		specieType = reader.nextInt();

		reader.nextLine();

		System.out.println("\nEnter the new species' name: ");
		name = reader.nextLine();

		System.out.println("\nEnter the new species' scientific name: ");
		scientificName = reader.nextLine();

		switch (specieType) {
			case 1:
				System.out.println("\nDoes this new species have flowers?");
				System.out.println("[1] Yes.");
				System.out.println("[2] No.");
				hasFlowers = reader.nextInt();

				System.out.println("\nDoes this new species have fruits?");
				System.out.println("[1] Yes.");
				System.out.println("[2] No.");
				hasFruits = reader.nextInt();

				System.out.println("\nEnter the maximum height that a specimen of this species can reach (m).");
				maxHeight = reader.nextDouble();

				created = speciesController.registerSpeciesFlora(specieType, name, scientificName, hasFlowers, hasFruits, maxHeight);

				if (created) {
					System.out.println("\nSpecies registered successfully.");
					System.out.println(speciesController.showSpeciesList());
				} else {
					System.out.println("\nSomething went wrong...");
				}
				break;

			case 2:
				System.out.println("\nIs this new species a migrant?");
				System.out.println("[1] Yes.");
				System.out.println("[2] No.");
				isMigrant = reader.nextInt();

				System.out.println("\nEnter the maximum weight that a specimen of this species can reach (kg).");
				maxWeight = reader.nextDouble();

				created = speciesController.registerSpeciesFauna(specieType, name, scientificName, isMigrant, maxWeight);

				if (created) {
					System.out.println("\nSpecies registered successfully.");
					System.out.println(speciesController.showSpeciesList());
				} else {
					System.out.println("\nSomething went wrong...");
				}
				break;

			default:
				break;
		}
	}

	public void editSpecies() {
		// Variables of work:
		String specieName;
		int whatIs;
		int option;
		String theChange;
		boolean changed;

		reader.nextLine();

		System.out.println("\nWhich species would you like to edit?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			System.out.println("\nEnter the name of the species you want to edit:");
			specieName = reader.nextLine();

			whatIs = speciesController.whatIs(specieName);

			switch (whatIs) {
				case 1:
					System.out.println("\nWhat would you like to edit?");
					System.out.println("[1] Name.");
					System.out.println("[2] Scientific name.");
					System.out.println("[3] Flowers.");
					System.out.println("[4] Fruits.");
					System.out.println("[5] Maximum height.");
					option = reader.nextInt();

					switch (option) {
						case 1:
							System.out.println("\nEnter the new name:");
							reader.nextLine();
							theChange = reader.nextLine();
							changed = speciesController.editASpecie(specieName, whatIs, option, theChange);

							if (changed) {
								System.out.println("\nSuccessfully changed.");
								System.out.println(speciesController.showSpeciesList());
							} else {
								System.out.println("\nSomething went wrong.");
							}
							break;

						case 2:
							System.out.println("\nEnter the new scientific name:");
							reader.nextLine();
							theChange = reader.nextLine();
							changed = speciesController.editASpecie(specieName, whatIs, option, theChange);

							if (changed) {
								System.out.println("\nSuccessfully changed.");
								System.out.println(speciesController.showSpeciesList());
							} else {
								System.out.println("\nSomething went wrong.");
							}
							break;

						case 3:
							System.out.println("\nDoes it have flowers?");
							System.out.println("[1] True.");
							System.out.println("[2] False.");
							reader.nextLine();
							theChange = reader.nextLine();
							changed = speciesController.editASpecie(specieName, whatIs, option, theChange);

							if (changed) {
								System.out.println("\nSuccessfully changed.");
								System.out.println(speciesController.showSpeciesList());
							} else {
								System.out.println("\nSomething went wrong.");
							}
							break;

						case 4:
							System.out.println("\nDoes it have fruits?");
							System.out.println("[1] True.");
							System.out.println("[2] False.");
							reader.nextLine();
							theChange = reader.nextLine();
							changed = speciesController.editASpecie(specieName, whatIs, option, theChange);

							if (changed) {
								System.out.println("\nSuccessfully changed.");
								System.out.println(speciesController.showSpeciesList());
							} else {
								System.out.println("\nSomething went wrong.");
							}
							break;

						case 5:
							System.out.println("\nEnter the new maximum height:");
							reader.nextLine();
							theChange = reader.nextLine();
							changed = speciesController.editASpecie(specieName, whatIs, option, theChange);

							if (changed) {
								System.out.println("\nSuccessfully changed.");
								System.out.println(speciesController.showSpeciesList());
							} else {
								System.out.println("\nSomething went wrong.");
							}
							break;

						default:
							System.out.println("\nInvalid option.");
							break;
					}
					break;

				case 2:
					System.out.println("\nWhat would you like to edit?");
					System.out.println("[1] Name.");
					System.out.println("[2] Scientific name.");
					System.out.println("[3] Is it migrant?");
					System.out.println("[4] Maximum weight.");
					option = reader.nextInt();

					switch (option) {
						case 1:
							System.out.println("\nEnter the new name:");
							reader.nextLine();
							theChange = reader.nextLine();
							changed = speciesController.editASpecie(specieName, whatIs, option, theChange);

							if (changed) {
								System.out.println("\nSuccessfully changed.");
								System.out.println(speciesController.showSpeciesList());
							} else {
								System.out.println("\nSomething went wrong.");
							}
							break;

						case 2:
							System.out.println("\nEnter the new scientific name:");
							reader.nextLine();
							theChange = reader.nextLine();
							changed = speciesController.editASpecie(specieName, whatIs, option, theChange);

							if (changed) {
								System.out.println("\nSuccessfully changed.");
								System.out.println(speciesController.showSpeciesList());
							} else {
								System.out.println("\nSomething went wrong.");
							}
							break;

						case 3:
							System.out.println("\nIs it a migrant?");
							System.out.println("[1] True.");
							System.out.println("[2] False.");
							reader.nextLine();
							theChange = reader.nextLine();
							changed = speciesController.editASpecie(specieName, whatIs, option, theChange);

							if (changed) {
								System.out.println("\nSuccessfully changed.");
								System.out.println(speciesController.showSpeciesList());
							} else {
								System.out.println("\nSomething went wrong.");
							}
							break;

						case 4:
							System.out.println("\nEnter the new maximum weight:");
							reader.nextLine();
							theChange = reader.nextLine();
							changed = speciesController.editASpecie(specieName, whatIs, option, theChange);

							if (changed) {
								System.out.println("\nSuccessfully changed.");
								System.out.println(speciesController.showSpeciesList());
							} else {
								System.out.println("\nSomething went wrong.");
							}
							break;

						default:
							System.out.println("\nInvalid option.");
							break;
					}
					break;

				default:
					System.out.println("\nNo such species exists.");
					break;
			}
		} else {
			System.out.println("\nNo species registered.");
		}
	}

	public void deleteSpecies() {
		// Variables of work:
		String specieName = " ";
		boolean deleted;

		reader.nextLine();

		System.out.println("\nWhich species would you like to delete?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			System.out.println("\nEnter the name of the species you want to delete:");
			specieName = reader.nextLine();

			deleted = speciesController.deleteSpecies(specieName);

			if (deleted) {
				System.out.println("\nSuccessfully deleted.");
				System.out.println(speciesController.showSpeciesList());
			} else {
				System.out.println("\nSomething went wrong.");
			}
		} else {
			System.out.println("\nNo species registered.");
		}
	}

	public void showInformationAboutASpecie() {
		// Variables of work:
		String specieToShow;
		String informationAboutTheSpecie;

		reader.nextLine();

		System.out.println(speciesController.showSpeciesList());

		System.out.println("\nType the name of the specie that you want to display te information:");
		specieToShow = reader.nextLine();

		informationAboutTheSpecie = speciesController.showInformationOfSpecie(specieToShow);

		System.out.println("\n" +informationAboutTheSpecie);
	}
}
