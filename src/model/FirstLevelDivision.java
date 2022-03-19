package model;
/**
 * class FirstLevelDivision.java
 */

/**
 *
 * @author James Trowbridge
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class FirstLevelDivision {
    //related to state and prov codes in the FLD table
    private int divisionID;
    private String divisionName;
    private int countryID;

    public FirstLevelDivision(int divisionID, String divisionName){
        this.divisionID = divisionID;
        this.divisionName = divisionName;
    }

    public int getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public int getCountryID() {
        return countryID;
    }

    @Override
    public String toString(){
        return (divisionName);
    }
}
