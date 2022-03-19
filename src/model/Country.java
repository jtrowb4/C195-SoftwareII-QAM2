package model;
/**
 * class Country.java
 */

/**
 *
 * @author James Trowbridge
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Country {

    private String countryName;
    private int countryID;

    public Country(int countryID, String countryName){
        this.countryID = countryID;
        this.countryName = countryName;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString(){
        return (countryName);
    }
}
