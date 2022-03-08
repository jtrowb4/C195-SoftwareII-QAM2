package main;
/**
 * class Main.java
 * version 1.0.0 11/06/2021
 * version 1.1.0 11/08/2021
 */

/**
 *
 * @author James Trowbridge
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    /**
     *Utilize the start method and set the stage
     */
    @Override
    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
        stage.setTitle("QKM2_InventoryManagementSystem");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
    /**
     * @param args
     * Initial Launch of application - QAM2_JavaApplication
     */
    public static void main(String[] args){
        launch(args);
    }
}
