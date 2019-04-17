package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.User;
import javafx.fxml.Initializable;

/**
 * Controller LoginController handle all event for Login.fxml
 * 
 * @author Biao Tian (fcy416)
 * UTSA CS 3443 - Team Project
 * Spring 2019
 */

public class LoginController implements Initializable{
	@FXML
	private Button signup_Login;
	@FXML
	private Button loginButton_Login;
	@FXML
	private TextField userName_Login;
	@FXML
	private Text feedback_Login;
	User tempUser = new User("","","","","");
	protected static String userName;
	
	/**
	 * initialize method that handle all data before GUI appear
	 */
    @FXML // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL location, ResourceBundle resources){
    	try {
			tempUser.loadUser("data/users.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
	 * handleIdentity method that handle all user action
	 */
    public void handleLogin(ActionEvent event) throws IOException{
    	System.out.println("User Try to prompt log in.");
    	String tempUser1 = userName_Login.getText();
    	String identifySign=tempUser.validate(tempUser1);
    	if(identifySign.equals("true")){
    		userName=tempUser1;
    		this.changeView("../view/Manage.fxml");
    	}else{
    		feedback_Login.setText(identifySign);
    		userName_Login.clear();
    		signup_Login.setDisable(false);
    	}
    }
    
    /**
     *handleSignUp method that handle all user action and jump to sign up page.
  	 */
     public void handleSignup(ActionEvent event){
    	 this.changeView("../view/SignUp.fxml");
     }
    
    /**
	 * changeView method that move to next scene
	 */
	public void changeView(String fxmlname){
		try {
			Parent nextView = FXMLLoader.load( getClass().getResource(fxmlname));
			Scene nextScene = new Scene(nextView);
			Main.stage.setScene(nextScene);
			Main.stage.show();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}