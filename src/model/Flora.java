package model;

public class Flora extends Species {

    private boolean hasFlowers;
    private boolean hasFruits;
    private double maxHeight;

    public Flora(SpeciesType type, String name, String scientificName, boolean hasFlowers, boolean hasFruits,
            double maxHeight) {
        super(type, name, scientificName);
        this.hasFlowers = hasFlowers;
        this.hasFruits = hasFruits;
        this.maxHeight = maxHeight;
    }

    public boolean getHasFlowers() {
        return hasFlowers;
    }

    public void setHasFlowers(boolean hasFlowers) {
        this.hasFlowers = hasFlowers;
    }

    public boolean getHasFruits() {
        return hasFruits;
    }

    public void setHasFruits(boolean hasFruits) {
        this.hasFruits = hasFruits;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public String toString() {
        return super.toString() + ". It has flowers (" + hasFlowers + "), it has fruits (" + hasFruits + ") and the maximum height recorded in a specimen is " + maxHeight + " m";
    }
    
}

