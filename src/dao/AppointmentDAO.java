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
    private static String weekApptsQuery = "SELECT * FROM client_schedule.appointments WHERE week(start)= week(now())";
    private static String monthApptsQuery = "SELECT * FROM client_schedule.appointments WHERE Month(start)= Month(now())";


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
        String insertCustomerQuery = "INSERT INTO client_schedule.appointments (Appointment_ID, Title, Description, Location, " +
                "Type, Start, End, Customer_ID, User_ID, Contact_ID) VALUES('"
                + appointment.getAppointmentID() + "', '"
                + appointment.getTitle() + "', '"
                + appointment.getDescription() + "', '"
                + appointment.getLocation() + "', '"
                + appointment.getType() + "', '"
                + appointment.getStartTime() + "', '"
                + appointment.getEndTime() + "', '"
                + appointment.getCustomerID() + "', '"
                + appointment.getUserId() + "', '"
                + appointment.getContactID() + "')";

        DBQuery.makeQuery(insertCustomerQuery);
        DBConnector.closeConnection();
    }

    public static void updateAppointment(Appointment appointment) {
        DBConnector.openConnection();
        String updateCustomerQuery =
                "UPDATE client_schedule.appointments " +
                        "SET Title = '" + appointment.getTitle() +
                        "', Description = '" + appointment.getDescription() +
                        "', Location = '" + appointment.getLocation() +
                        "', Type = '" + appointment.getType() +
                        "', Start = '" + appointment.getStartTime() +
                        "', End = '" + appointment.getEndTime() +
                        "', Customer_ID = '" + appointment.getCustomerID() +
                        "', User_ID = '" + appointment.getUserId() +
                        "', Contact_ID = '" + appointment.getContactID() +

                        "' WHERE Appointment_ID = '" + appointment.getAppointmentID() + "'";
        DBQuery.makeQuery(updateCustomerQuery);
        DBConnector.closeConnection();
    }

    public static void deleteAppointment(Appointment appointment){
        DBConnector.openConnection();
        String deleteCustomerQuery = "DELETE FROM client_schedule.appointments WHERE Appointment_ID = '" + appointment.getAppointmentID() + "'";
        DBQuery.makeQuery(deleteCustomerQuery);
        DBConnector.closeConnection();
    }

    public static ObservableList<Appointment> displayThisWeekAppointments() throws SQLException, Exception {

        if (allAppointments.size() > 0){
            allAppointments.clear();
        }
        DBConnector.openConnection();
        DBQuery.makeQuery(weekApptsQuery);
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

    public static ObservableList<Appointment> displayThisMonthAppointments() throws SQLException, Exception {

        if (allAppointments.size() > 0){
            allAppointments.clear();
        }
        DBConnector.openConnection();
        DBQuery.makeQuery(monthApptsQuery);
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

}



