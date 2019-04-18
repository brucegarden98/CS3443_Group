package controller;

import controller.LoginController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

/**
 * Controller MainController handle all event for Main.fxml
 * 
 * @author Biao Tian (fcy416)
 * UTSA CS 3443 - Team Project
 * Spring 2019
 */

public class MainController extends LoginController implements Initializable{
	//All FXML Variables
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

	/**
	 * initialize method that handle all data before GUI appear
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources){
		welcome_Main.setText("Welcome: "+currentUser.getUserName());
		goalFeedback_Main.setText(currentUser.getGoal());
		currentFeedback_Main.setText(currentUser.getAchieve());
		lastTime_Main.setText("Last Login Time: "+currentUser.getLoginTime());
	}
	
    /**
	 * handleFood method that handle all user action for Food Button
	 */
	public void handleFood(ActionEvent event){
		this.changeView("../view/Food.fxml");
    }
	
    /**
	 * handleLogout method that handle all user action for Logout Button
     * @throws FileNotFoundException 
	 */
	public void handleLogout(ActionEvent event){
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy");
		currentUser.setLoginTime(dateFormat.format(calendar.getTime()));
		this.changeView("../view/Login.fxml");
	}
	
    /**
	 * handleEdit method that handle all user action for Edit Button
     * @throws FileNotFoundException 
	 */
	public void handleEdit(ActionEvent event) throws FileNotFoundException{
		this.changeView("../view/Manage.fxml");
	}
	
}