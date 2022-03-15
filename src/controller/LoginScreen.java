package controller;

import dao.DBConnector;
import dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreen implements Initializable {

    public Button loginButton;
    public Button exitButton;
    public Label zoneIDText;
    public TextField userNameText;
    public PasswordField passwordText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        System.out.println("QAM2_JavaApplication v1.0.0 Loaded");
    }

    public void onButtonClick(ActionEvent actionEvent) {
        String password = passwordText.getText();
        String userName = userNameText.getText();

        try{
           User userLogin = UserDAO.getUserLogin(userName);
           String userLoginName = userLogin.getUserName();
           String userLoginPassword = userLogin.getPassword();
           if ((userLoginName.equals(userName)) && (userLoginPassword.equals(password))){
               System.out.println("Login Success");
               Parent root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
               Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
               Scene scene = new Scene(root, 800, 600);
               stage.setTitle("QAM2_InventoryManagementSystem");
               stage.setScene(scene);
               stage.show();
           }
           else{
               userNameText.clear();
               passwordText.clear();
               throw new Exception("User Name or Password is invalid.");
           }

        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Code 400: Bad Request.");
            alert.setHeaderText("Exception has occurred.");
            alert.setContentText("Login Failed: User Name or Password is invalid.");

            alert.showAndWait();

        }
    }

    public void onExit(ActionEvent actionEvent) {
    }

}
