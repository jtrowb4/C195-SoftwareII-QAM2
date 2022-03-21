package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointment;
import model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentDAO {

    private static ObservableList<Appointment> allAppointments = FXCollections.observableArrayList();
    private static String allApptsQuery = "SELECT * FROM client_schedule.appointments";
    private static String weekApptsQuery = "SELECT * FROM client_schedule.appointments";
    private static String monthApptsQuery = "SELECT * FROM client_schedule.appointments";


    public static ObservableList<Appointment> displayAllAppointments() throws SQLException, Exception {

        if (allAppointments.size() > 0){
            allAppointments.clear();
        }
        DBConnector.openConnection();
        DBQuery.makeQuery(allApptsQuery);
        ResultSet result = DBQuery.getResult();
        while (result.next()) {
            int appointmentID = result.getInt("Appointment_ID");
            String appointmentTitle = result.getString("Title");
            String appointmentDescription = result.getString("Description");
            String appointmentLocation = result.getString("Location");
            String appointmentType = result.getString("Type");
            String appointmentStart = result.getString("Start");
            String appointmentEnd = result.getString("End");
            int userID = result.getInt("User_ID");
            int customerID = result.getInt("Customer_ID");
            int contactID = result.getInt("Contact_ID");
            addAppointment(new Appointment(appointmentID, appointmentTitle, appointmentDescription, appointmentLocation,
                    appointmentType, appointmentStart, appointmentEnd, userID, customerID, contactID));
        }
        DBConnector.closeConnection();
        return allAppointments;
    }

    public static void addAppointment(Appointment appt) {
        allAppointments.add(appt);

    }

    public static void insertAppointment(Appointment appointment) {
        DBConnector.openConnection();
        /* String insertCustomerQuery = "INSERT INTO client_schedule.customers (Customer_ID, Customer_Name, Address, Postal_Code, " +
                "Phone, Division_ID) VALUES('"
                + customer.getCustomerID() + "', '"
                + customer.getCustomerName() + "', '"
                + customer.getAddress() + "', '"
                + customer.getPostalCode() + "', '"
                + customer.getPhoneNumber() + "', '"
                + customer.getDivisionID() + "')";

        DBQuery.makeQuery(insertCustomerQuery);   */
        DBConnector.closeConnection();
    }

    public static void updateAppointment(Appointment appointment) {
        DBConnector.openConnection();
        /* String updateCustomerQuery =
                "UPDATE client_schedule.customers " +
                        "SET Customer_Name = '" + customer.getCustomerName() +
                        "', Address = '" + customer.getAddress() +
                        "', Postal_Code = '" + customer.getPostalCode() +
                        "', Phone = '" + customer.getPhoneNumber() +
                        "', Division_ID = '" + customer.getDivisionID() +
                        "' WHERE Customer_ID = '" + customer.getCustomerID() + "'";
        DBQuery.makeQuery(updateCustomerQuery); */
        DBConnector.closeConnection();
    }

    public static void deleteCustomer(Customer customer){
        DBConnector.openConnection();
        String deleteCustomerQuery = "DELETE FROM client_schedule.customers WHERE Customer_ID = '" + customer.getCustomerID() + "'";
        DBQuery.makeQuery(deleteCustomerQuery);
        DBConnector.closeConnection();
    }
}



