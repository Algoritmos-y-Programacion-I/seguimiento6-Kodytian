package model;

public class Fauna extends Species {

    private boolean isMigrant;
    private double maxWeight;

    public Fauna(SpeciesType type, String name, String scientificName, boolean isMigrant, double maxWeight) {
        super(type, name, scientificName);
        this.isMigrant = isMigrant;
        this.maxWeight = maxWeight;
    }

    public boolean isMigrant() {
        return isMigrant;
    }

    public void setMigrant(boolean isMigrant) {
        this.isMigrant = isMigrant;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return super.toString() + ". Is migrant (" + isMigrant + ") and the maximum weight recorded in a specimen: " + maxWeight + " kg";
    }

}
