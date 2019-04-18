package controller;

import controller.LoginController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MainController extends LoginController implements Initializable{
	@FXML
	private Text currentFeedback_Main;
	@FXML
	private Text goalFeedback_Main;
	@FXML
	private Text advise_Main;
	@FXML
	private Button food_Main;
	@FXML
	private Text welcome_Main;
	@FXML
	private Button logout_Main;
	@FXML
	private Button edit_Main;
	@FXML
	private Text lastTime_Main;

	@Override
	public void initialize(URL location, ResourceBundle resources){
		welcome_Main.setText("Welcome: "+currentUser.getUserName());
		goalFeedback_Main.setText(currentUser.getGoal());
		currentFeedback_Main.setText(currentUser.getAchieve());
		lastTime_Main.setText("Last Login Time: "+currentUser.getLoginTime());
		
	}
	
	public void handleFood(ActionEvent event){
		this.changeView("../view/SignUp.fxml");
    }
	
	public void handleLogout(ActionEvent event){
	   	 this.changeView("../view/Login.fxml");
	}
	
	public void handleEdit(ActionEvent event){
	   	 this.changeView("../view/Manage.fxml");
	}
}