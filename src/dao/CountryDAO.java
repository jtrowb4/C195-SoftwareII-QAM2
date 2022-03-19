package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDAO {

    private static ObservableList<Country> allCountries = FXCollections.observableArrayList();

    public static ObservableList<Country> displayAllCountries() throws SQLException, Exception{

        DBConnector.openConnection();
        String loginQuery = "SELECT * FROM client_schedule.countries";
        DBQuery.makeQuery(loginQuery);
        ResultSet result = DBQuery.getResult();
        while(result.next()){
            int countryID = result.getInt("Country_ID");
            String countryName = result.getString("Country");
            allCountries.add(new Country(countryID, countryName));
        }
        DBConnector.closeConnection();
        return allCountries;
    }

}
