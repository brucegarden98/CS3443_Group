package controller;

import model.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SignUpController extends LoginController {
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
     *handleSignUp method that handle all user action and jump to sign up page.
     * @throws InterruptedException 
  	 */
     public void handleAdd(ActionEvent event) throws InterruptedException{
    	 String indicator = "false";
    	 //Get Current Time
    	 Calendar calendar= Calendar.getInstance();
    	 SimpleDateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy");
    	 //Valid User name
    	 String result=tempUser.validate(newUser_Sign.getText());
    	 System.out.println(result);
    	 if(result.equalsIgnoreCase("true")){
    		 feedback_Sign.setText("Username Already Exist!");
    		 Thread.sleep(100);
    		 newUser_Sign.clear();
    	 }
    	 else {
    		 feedback_Sign.setText("Sign Up Successful!");
    		 User newUser = new User(newUser_Sign.getText(), dateFormat.format(calendar.getTime()), newGoal_Sign.getText(), "0", "");
    		 tempUser.addUser(newUser);
    		 currentUser = newUser;
    		 Thread.sleep(1000);
    		 this.changeView("../view/Main.fxml");
    	 }
     }
     
     /**
      *handleSignUp method that handle all user action and jump to sign up page.
   	 */
      public void handleReturn(ActionEvent event){
    	  this.changeView("../view/Login.fxml");
      }
}