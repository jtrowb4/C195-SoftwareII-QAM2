package controller;

import dao.CustomerDAO;
import dao.FirstLevelDivisionDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Customer;
import model.FirstLevelDivision;
import java.io.IOException;
import java.net.URL;

import java.sql.SQLException;
import java.util.Locale;
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
    public void initialize(URL url, ResourceBundle resourceBundle) {


        customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        customerPostal.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        customerPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        customerDivision.setCellValueFactory(new PropertyValueFactory<>("divisionName"));

        try {
            customerTable.setItems(CustomerDAO.displayAllCustomers());
          /*  ObservableList<FirstLevelDivision> firstLevelDivisions = FirstLevelDivisionDAO.displayAllDivisions();
            for (FirstLevelDivision division: firstLevelDivisions
                 ) {
                if (division.equals(customerDivision.getCellObservableValue("divisionID").getValue()));
                customerDivision.getColumns().set(customerDivision.getColumns().indexOf("divisionID"), division.getDivisionName());
            }*/

        }
    catch(Exception e) {
            e.printStackTrace();
        }
    }

        public void toMainMenu (ActionEvent actionEvent) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 800, 600);
            stage.setTitle("QAM2_JavaApplication");
            stage.setScene(scene);
            stage.show();
        }

        public void loadAddCustomer (ActionEvent actionEvent) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("/view/AddCustomer.fxml"));
            Stage stage = new Stage(); //(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 450);
            stage.setTitle("QAM2_JavaApplication: Add Customer");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        }

        public void loadModifyCustomer (ActionEvent actionEvent) throws IOException {

            try {
                Customer selectedCustomer = (Customer) customerTable.getSelectionModel().getSelectedItem();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ModifyCustomer.fxml"));
                Parent root = loader.load();

                ModifyCustomer modifyCustomer = loader.getController();
                modifyCustomer.loadSelectedCustomer(selectedCustomer);

                Stage stage = new Stage(); //(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 450);
                stage.setTitle("QAM2_JavaApplication: Modify Customer");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Code 400: Bad Request.");
                alert.setHeaderText("Exception has occurred.");
                alert.setContentText("Customer was not selected. Please select Customer to Modify.");

                alert.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void loadDeleteCustomer (ActionEvent actionEvent) throws Exception {
            Customer selectedCustomer = (Customer) customerTable.getSelectionModel().getSelectedItem();

            if (selectedCustomer != null) {
                CustomerDAO.deleteCustomer(selectedCustomer);
            }

            customerTable.setItems(CustomerDAO.displayAllCustomers());
        }

        public void searchCustomer (ActionEvent actionEvent) throws Exception {
            String searchText = customerSearch.getText();
            //int searchTextID = Integer.parseInt(customerSearch.getText());

            if (searchText == "") {
                customerTable.setItems(CustomerDAO.displayAllCustomers());
            } else {
                customerTable.setItems(CustomerDAO.findCustomer(searchText));
            }

            try {
                int customerID = Integer.parseInt(searchText);
                customerTable.setItems(CustomerDAO.findCustomer(customerID));

            } catch (NumberFormatException e) {
                //ignore
            }

            customerSearch.setText("");

        }
    }

