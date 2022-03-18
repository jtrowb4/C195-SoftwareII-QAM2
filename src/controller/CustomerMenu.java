package controller;

import dao.CustomerDAO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.util.ResourceBundle;

public class CustomerMenu implements Initializable {

    public TableView customerTable;
    public TableColumn customerID;
    public TableColumn customerName;
    public TableColumn customerAddress;
    public TableColumn customerDivision;
    public TableColumn customerPostal;
    public TableColumn customerPhone;
    public TextField customerSearch;
    public Button addCustomerButton;
    public Button modifyCustomerButton;
    public Button deleteCustomerButton;
    public Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
    customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
    customerAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    customerPostal.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
    customerPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    customerDivision.setCellValueFactory(new PropertyValueFactory<>("divisionID"));

        try {
            customerTable.setItems(CustomerDAO.displayAllCustomers());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("QAM2_JavaApplication v1.0.0 Loaded");
    }
    public void toMainMenu(ActionEvent actionEvent) {
    }

    public void loadAddCustomer(ActionEvent actionEvent) {
    }

    public void loadModifyCustomer(ActionEvent actionEvent) {
    }

    public void loadDeleteCustomer(ActionEvent actionEvent) {
    }

    public void searchCustomer(ActionEvent actionEvent) {
    }
}
