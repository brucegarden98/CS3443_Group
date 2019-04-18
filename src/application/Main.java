package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Class Main is the main class that start the app.
 * 
 * @author Biao Tian (fcy416)
 * UTSA CS 3443 - Team Project
 * Spring 2019
 */

public class Main extends Application {
	//Variables used to define stage
	public static Stage stage;
	
	@Override
	/**
	 * start method used to create a stage
	 */
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
			primaryStage.setScene(new Scene(root, 600, 800));
			primaryStage.show();
			stage = primaryStage;
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * main method used to start whole application
	*/
	public static void main(String[] args) {
		launch(args);
	}
}
