package controller;

import dao.AppointmentDAO;
import dao.CustomerDAO;
import dao.FirstLevelDivisionDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Contact;
import model.FirstLevelDivision;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentMenu implements Initializable {
    public Button backButton;
    public TableView apptTable;
    public TableColumn apptID;
    public TableColumn apptTitle;
    public TableColumn apptDescription;
    public TableColumn apptLocation;
    public TableColumn apptContact;
    public TableColumn apptType;
    public TableColumn apptStart;
    public TableColumn apptEnd;
    public ToggleGroup apptGroup;
    public Button addAppointmentButton;
    public Button modifyAppointmentButton;
    public Button deleteAppointmentButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        apptID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        apptTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        apptDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        apptLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        apptType.setCellValueFactory(new PropertyValueFactory<>("type"));
        apptStart.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        apptEnd.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        apptContact.setCellValueFactory(new PropertyValueFactory<>("contactID"));

        try {
            apptTable.setItems(AppointmentDAO.displayAllAppointments());
            System.out.println("QAM2_JavaApplication v1.0.0 Loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void toMainMenu(ActionEvent actionEvent) {
    }

    public void monthApptOn(MouseEvent mouseEvent) {
    }

    public void weekApptOn(ActionEvent actionEvent) {
    }

    public void allApptOn(ActionEvent actionEvent) {
    }

    public void loadAddAppointment(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/AddAppointment.fxml"));
        Stage stage = new Stage(); //(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 450);
        stage.setTitle("QAM2_JavaApplication: Add Appointment");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void loadModifyAppointment(ActionEvent actionEvent) {
    }

    public void loadDeleteAppointment(ActionEvent actionEvent) {
    }
}
