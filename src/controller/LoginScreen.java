package controller;

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

import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 * class LoginScreen.java
 *
 * @author James Trowbridge
 *
 * first scene for application
 */
public class LoginScreen implements Initializable {

    public Button loginButton;
    public Button exitButton;
    public Label zoneIDText;
    public TextField userNameText;
    public PasswordField passwordText;

    public static int userID;

    /**
     * Initialize scene
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        zoneIDText.setText("'" + ZoneId.systemDefault() + " " + ZoneId.systemDefault().getRules().getOffset(Instant.now()) + "'");
        System.out.println("QAM2_JavaApplication v1.0.0 Loaded");
    }
    /**
     * Login button that ties to UserDAO
     * checks if username and password match db
     */
    public void onButtonClick(ActionEvent actionEvent) {
        String password = passwordText.getText();
        String userName = userNameText.getText();

        try{
           User userLogin = UserDAO.getUserLogin(userName);
           String userLoginName = userLogin.getUserName();
           String userLoginPassword = userLogin.getPassword();
           int userLoginUserID = userLogin.getUserID();
           userID = userLoginUserID;
            if ((userLoginName.equals(userName)) && (userLoginPassword.equals(password))){
               System.out.println("Login Success");
               Parent root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
               Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
               Scene scene = new Scene(root, 800, 600);
               stage.setTitle("QAM2_JavaApplication");
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
            if(Locale.getDefault().getLanguage().equals("en")) {
                alert.setTitle("Error Code 400: Bad Request.");
                alert.setHeaderText("Exception has occurred.");
                alert.setContentText("Login Failed: User Name or Password is invalid.");
                alert.showAndWait();
            }
            else if(Locale.getDefault().getLanguage().equals("fr")){
                alert.setTitle("Code D'erreur 400: Mauvaise Demande.");
                alert.setHeaderText("Une exception s'est produite.");
                alert.setContentText("Échec de la connexion : le nom d'utilisateur ou le mot de passe n'est pas valide.");
                alert.showAndWait();
            }

        }
    }
    /**
     * Exit button that closes application
     */
    public void onExit(ActionEvent actionEvent) {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
