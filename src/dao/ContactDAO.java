package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contact;
import model.FirstLevelDivision;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDAO {
    // create an interface that holds methods such as Create, Read, Update, and Delete.
    // define those methods in the classes you create for user, customer, contact, appointment, etc.
    private static ObservableList<Contact> allContacts = FXCollections.observableArrayList();

    public static ObservableList<Contact> displayAllContacts() throws SQLException, Exception{

        if (allContacts.size() > 0){
            allContacts.clear();
        }

        DBConnector.openConnection();
        String searchQuery = "SELECT * FROM client_schedule.contacts";
        DBQuery.makeQuery(searchQuery);
        ResultSet result = DBQuery.getResult();
        while(result.next()){
            int contactID = result.getInt("Contact_ID");
            String contactName = result.getString("Contact_Name");
            String email = result.getString("Email");
            allContacts.add(new Contact(contactID, contactName));
        }
        DBConnector.closeConnection();
        return allContacts;
    }
}

