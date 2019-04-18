package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * Controller FoodController handle all event for Food.fxml
 * 
 * @author Biao Tian (fcy416)
 * UTSA CS 3443 - Team Project
 * Spring 2019
 */

public class FoodController extends MainController implements Initializable{
	//All FXML Variables
	@FXML
    private Button return_Food;
    @FXML
    private Button add_Food;
    @FXML
    private TextArea returnScreen_Food;
    
    /**
	 * initialize method that handle all data before GUI appear
	 */
    @Override
	public void initialize(URL location, ResourceBundle resources) {
	}
    
    /**
     *handleReturn method that handle all user action for return button and return to
     *previous page.
  	 */
     public void handleReturn(ActionEvent event){
    	 this.changeView("../view/Main.fxml");
     }
     
     /**
      *handleAdd method that handle all user action for add button and add food to user choice.
   	 */
     /*Need work on that 
      * 1. Food UI design
      * 2. Show Food choice already exist in user date
      * 3. Calculate the current cal
      * 4. Return the value back to current User
      */
      public void handleAdd(ActionEvent event){
     	 this.changeView("../view/Main.fxml");
      }
}
