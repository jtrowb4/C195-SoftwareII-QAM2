package main;
/**
 * class Main.java
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
        stage.setTitle("QAM2_JavaApplication");
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

// comment added to test VM to local