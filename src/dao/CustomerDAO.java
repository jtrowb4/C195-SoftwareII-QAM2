package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    private static ObservableList<Customer> allCustomers = FXCollections.observableArrayList();

    public static ObservableList<Customer> displayAllCustomers() throws SQLException, Exception {


        if (allCustomers.size() > 0){
            allCustomers.clear();
        }
        DBConnector.openConnection();
        String loginQuery = "SELECT * FROM client_schedule.customers";
        DBQuery.makeQuery(loginQuery);
        ResultSet result = DBQuery.getResult();
        while (result.next()) {
            int customerID = result.getInt("Customer_ID");
            String customerName = result.getString("Customer_Name");
            String address = result.getString("Address");
            String postalCode = result.getString("Postal_Code");
            String phone = result.getString("Phone");
            int division = result.getInt("Division_ID");
            addCustomer(new Customer(customerID, customerName, address, postalCode, phone, division));
        }
        DBConnector.closeConnection();
        return allCustomers;
    }

    public static void addCustomer(Customer customer) {
        allCustomers.add(customer);

    }

    public static void insertCustomer(Customer customer) {
        DBConnector.openConnection();
        String addCustomerQuery = "INSERT INTO client_schedule.customers (Customer_ID, Customer_Name, Address, Postal_Code, " +
                "Phone, Division_ID) VALUES('"
                + customer.getCustomerID() + "', '"
                + customer.getCustomerName() + "', '"
                + customer.getAddress() + "', '"
                + customer.getPostalCode() + "', '"
                + customer.getPhoneNumber() + "', '"
                + customer.getDivisionID() + "')";
        DBQuery.makeQuery(addCustomerQuery);
        DBConnector.closeConnection();
    }
}


