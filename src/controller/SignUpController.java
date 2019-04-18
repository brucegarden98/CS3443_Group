package controller;

import model.User;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Controller SignUpController handle all event for SignUp.fxml
 * 
 * @author Biao Tian (fcy416)
 * UTSA CS 3443 - Team Project
 * Spring 2019
 */

public class SignUpController extends LoginController {
	//All FXML Variables
	@FXML
    private TextField newUser_Sign;
	@FXML
    private TextField newGoal_Sign;
    @FXML
    private Button return_Sign;
    @FXML
    private Text feedback_Sign;
    @FXML
    private Button add_Sign;

    /**
     *handleAdd method that handle all user action for Add button, add new user
     *and jump to main page.
     * @throws InterruptedException 
     * @throws FileNotFoundException 
  	 */
     public void handleAdd(ActionEvent event) throws InterruptedException, FileNotFoundException{
    	 String indicator = "false";
    	 //Get Current Time
    	 Calendar calendar= Calendar.getInstance();
    	 SimpleDateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy");
    	 //Valid User name
    	 String result=tempUser.validate(newUser_Sign.getText());
    	 if(result.equalsIgnoreCase("true")){
    		 feedback_Sign.setText("Username Already Exist!");
    		 Thread.sleep(100);
    		 newUser_Sign.clear();
    	 }else {
    		 feedback_Sign.setText("Sign Up Successful!");
    		 User newUser = new User(newUser_Sign.getText(), dateFormat.format(calendar.getTime()), newGoal_Sign.getText(), "0", "null");
    		 tempUser.addUser(newUser);
    		 currentUser = newUser;
    		 Thread.sleep(1000);
    		 tempUser.save();
    		 this.changeView("../view/Main.fxml");
    	 }
     }
     
     /**
      *handleReturn method that handle all user action for return button.
   	 */
      public void handleReturn(ActionEvent event){
    	  this.changeView("../view/Login.fxml");
      }
}