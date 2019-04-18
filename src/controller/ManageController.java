package controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.User;

/**
 * Controller ManageController handle all event for Manage.fxml
 * 
 * @author Biao Tian (fcy416)
 * UTSA CS 3443 - Team Project
 * Spring 2019
 */

public class ManageController extends MainController implements Initializable{
	//All FXML Variables
	@FXML
    private TextField newGoal_Manage;
    @FXML
    private Button update_Manage;
    @FXML
    private Button delete_Manage;
    @FXML
    private TextField newUser_Manage;
    @FXML
    private Button return_Manage;
    @FXML
    private Text feedback_Manage;
	
    /**
	 * initialize method that handle all data before GUI appear
	 */
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	newUser_Manage.setPromptText(currentUser.getUserName());
    	newGoal_Manage.setPromptText(currentUser.getGoal());
	}
    
    /**
     *handleSignUp method that handle all user action and jump to sign up page.
  	 */
     public void handleReturn(ActionEvent event){
    	 this.changeView("../view/Main.fxml");
     }
     
     /**
      *handleDelete method that handle all user action for detete button and delete current user data.
     * @throws InterruptedException 
     * @throws FileNotFoundException 
   	 */
      public void handleDelete(ActionEvent event) throws InterruptedException{
    	  tempUser.removeUser(currentUser);
    	  feedback_Manage.setText("User Remove Successful!");
    	  this.changeView("../view/Login.fxml");
      }
      
      /**
       *handleUpdate method that handle all user action for update button and update user Info.
     * @throws InterruptedException 
     * @throws FileNotFoundException 
    	 */
       public void handleUpdate(ActionEvent event) throws InterruptedException, FileNotFoundException{
    	   String result=tempUser.validate(newUser_Manage.getText());
    	   if(result.equalsIgnoreCase("true")){
    		   feedback_Manage.setText("Username Already Exist!");
    		   Thread.sleep(50);
    		   feedback_Manage.setText("");
    		   } else {
    			   feedback_Manage.setText("Update Successful!");
    			   if(newUser_Manage.getText().isEmpty()!=true)
    				   currentUser.setUserName(newUser_Manage.getText());
    			   if(newGoal_Manage.getText().isEmpty()!=true)
    				   currentUser.setGoal(newGoal_Manage.getText());
    			   Thread.sleep(100);
    			   this.changeView("../view/Main.fxml");
    			   }
    	   }
}