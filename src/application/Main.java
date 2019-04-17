package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

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
