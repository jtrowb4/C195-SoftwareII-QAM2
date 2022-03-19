package controller;

import dao.CustomerDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
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

    public void loadAddCustomer(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/AddCustomer.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("QAM2_JavaApplication: Add Customer");
        stage.setScene(scene);
        stage.setResizable(false);
        //stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

    public void loadModifyCustomer(ActionEvent actionEvent) {
    }

    public void loadDeleteCustomer(ActionEvent actionEvent) {
    }

    public void searchCustomer(ActionEvent actionEvent) {
    }
}
