package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Country;
import model.FirstLevelDivision;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FirstLevelDivisionDAO {

    private static ObservableList<FirstLevelDivision> allDivisions = FXCollections.observableArrayList();

    public static ObservableList<FirstLevelDivision> displayAllDivisions() throws SQLException, Exception{

        if (allDivisions.size() > 0){
            allDivisions.clear();
        }

        DBConnector.openConnection();
        String divisionQuery = "SELECT * FROM client_schedule.first_level_divisions";
        DBQuery.makeQuery(divisionQuery);
        ResultSet result = DBQuery.getResult();
        while(result.next()){
            int divisionID = result.getInt("Division_ID");
            String divisionName = result.getString("Division");
            allDivisions.add(new FirstLevelDivision(divisionID, divisionName));
        }
        DBConnector.closeConnection();
        return allDivisions;
    }
    public static ObservableList<FirstLevelDivision> displayDivisions(int countryID) throws SQLException, Exception{

        if (allDivisions.size() > 0){
            allDivisions.clear();
        }

        DBConnector.openConnection();
        String divisionQuery = "SELECT * FROM client_schedule.first_level_divisions WHERE Country_ID = '" + countryID + "'";
        DBQuery.makeQuery(divisionQuery);
        ResultSet result = DBQuery.getResult();
        while(result.next()){
            int divisionID = result.getInt("Division_ID");
            String divisionName = result.getString("Division");
            allDivisions.add(new FirstLevelDivision(divisionID, divisionName));
        }
        DBConnector.closeConnection();
        return allDivisions;
    }

}
