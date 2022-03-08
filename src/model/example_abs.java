package model;
/**
 * Supplied class Part.java
 */

/**
 *
 * @author James Trowbridge
 */
public abstract class example_abs {
    private int partID;
    private String partName;
    private double partPrice;
    private int partStock;
    private int partMin;
    private int partMax;
    public example_abs(int partID, String partName, double partPrice, int partStock, int partMin, int partMax) {
        this.partID = partID;
        this.partName = partName;
        this.partPrice = partPrice;
        this.partStock = partStock;
        this.partMin = partMin;
        this.partMax = partMax;
    }

    /**
     * @return the partID
     */
    public int getPartID() {
        return partID;
    }

    /**
     * @param partID the id to set
     */
    public void setPartID(int partID) {
        this.partID = partID;
    }

    /**
     * @return the part Name
     */
    public String getPartName() {
        return partName;
    }

    /**
     * @param partName the name to set
     */
    public void setPartName(String partName) {
        this.partName = partName;
    }

    /**
     * @return the part price
     */
    public double getPartPrice() {
        return partPrice;
    }

    /**
     * @param partPrice the price to set
     */
    public void setPartPrice(double partPrice) {
        this.partPrice = partPrice;
    }

    /**
     * @return the part inventory stock
     */
    public int getPartStock() {
        return partStock;
    }

    /**
     * @param partStock the stock to set
     */
    public void setPartStock(int partStock) {
        this.partStock = partStock;
    }

    /**
     * @return the part inventory min
     */
    public int getPartMin() {
        return partMin;
    }

    /**
     * @param partMin the min to set
     */
    public void setPartMin(int partMin) {
        this.partMin = partMin;
    }

    /**
     * @return the part inventory max
     */
    public int getPartMax() {
        return partMax;
    }

    /**
     * @param partMax the max to set
     */
    public void setPartMax(int partMax) {
        this.partMax = partMax;
    }

}
