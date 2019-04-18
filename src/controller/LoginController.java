package controller;

import model.User;
import application.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;

/**
 * Controller LoginController handle all event for Login.fxml
 * 
 * @author Biao Tian (fcy416)
 * UTSA CS 3443 - Team Project
 * Spring 2019
 */

public class LoginController implements Initializable{
	//All FXML Variables
	@FXML
	private Button signup_Login;
	@FXML
	private Button loginButton_Login;
	@FXML
	private TextField userName_Login;
	@FXML
	private Text feedback_Login;
	//All other variable needed 
	User tempUser = new User("","","","","");
	public static User currentUser;
	
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
	 * handleLogin method that handle all user action for login Button
     * @throws InterruptedException 
	 */
    public void handleLogin(ActionEvent event) throws IOException, InterruptedException{
    	String tempUser1 = userName_Login.getText();
    	String identifySign=tempUser.validate(tempUser1);
    	if(identifySign.equals("true")){
    		feedback_Login.setText("Login Successful!");
    		currentUser = tempUser.matchUser(tempUser1);
        	Thread.sleep(100);
    		this.changeView("../view/Main.fxml");
    	}else{
    		feedback_Login.setText(identifySign);
    		userName_Login.clear();
    		signup_Login.setDisable(false);
    	}
    }
    
    /**
     *handleSignUp method that handle all user action for sign up button and jump to sign up page.
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