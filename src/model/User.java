package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class User is the class that read user file, contain User login username and last login time.
 * 
 * @author Biao Tian (fcy416)
 * UTSA CS 3443 - Team Project
 * Spring 2019
 */

public class User {
	//Variable used in User class
	private String userName;
	private String lastLoginTime;
	private String goal;
	private String achieve;
	private String food;
	//public static String username;
	ArrayList<User> loginUser = new ArrayList<User>();
	
	//Constructor
	/**
	 * @param userName: String, lastLoginTime: String, goal: String, achieve: String, food: String
	 * Constructor used to initialized User object
	 */
	public User(String userName, String lastLoginTime, String goal, String achieve, String food){
		super();
		this.userName = userName;
		this.lastLoginTime = lastLoginTime;
		this.goal = goal;
		this.achieve = achieve;
		this.food = food;
	}
	
	/**
	 * @param filePath: String
	 * @throws IOException
	 * This method read data from the file given by filePath and split it into several different
	 * tokens. Pass it into User constructor and generate new User object. Finally store it into 
	 * loginUser ArrayList.
	 */
	public void loadUser(String filePath) throws IOException{
		File csvFile = new File(filePath);
		BufferedReader fileBR = null;
		try{
			fileBR = new BufferedReader(new FileReader(csvFile));
		}catch (FileNotFoundException e){
	        e.printStackTrace();
	    }
	    String line = "";
	    String currentLine = "";
	    try {
	    	ArrayList<String> allString = new ArrayList<>();
            while((line=fileBR.readLine())!= null) {
                currentLine = line;
                String[] tokenSplit = line.split(",");
                allString.add(currentLine);
                User tempUser = new User(tokenSplit[0],tokenSplit[1],tokenSplit[2],tokenSplit[3],tokenSplit[4]);
                loginUser.add(tempUser);
            }
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    fileBR.close();
	}
	
	//Set and Get methods for userName
	/**
	 * @param userName, assign to userName
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}		
	/**
	 * @return the userName
	 */
	public String getUserName(){
		return userName;
	}	
		
	//Set and Get methods for lastLoginTime
	/**
	 * @param lastLoginTime, assign to lastLoginTime
	 */
	public void setLoginTime(String lastLoginTime){
		this.lastLoginTime = lastLoginTime;
	}			
	/**
	 * @return the lastLoginTime
	 */
	public String getLoginTime(){
		return lastLoginTime;
	}
	
	//Set and Get methods for goal
	/**
	 * @param goal, assign to goal
	 */
	public void setGoal(String goal){
		this.goal = goal;
	}		
	/**
	 * @return the goal
	 */
	public String getGoal(){
		return goal;
	}
	
	//Set and Get methods for achieve
	/**
	 * @param achieve, assign to achieve
	 */
	public void setAchieve(String achieve){
		this.achieve = achieve;
	}		
	/**
	 * @return the achieve
	 */
	public String getAchieve(){
		return achieve;
	}
	
	//Set and Get methods for food
	/**
	 * @param food, assign to food
	 */
	public void setFood(String food){
		this.food = food;
	}			
	/**
	 * @return the food
	 */
	public String getFood(){
		return food;
	}

	/**
	 * @param userUserName: String
	 * This method validate the username passed from login controller and 
	 * check it in the arraylist or not, and return login status.
	 */
	public String validate(String userUserName){
		String matchReturn="ERROR";
		for(int i=0;i<loginUser.size();i++){
			if(loginUser.get(i).getUserName().equals(userUserName)){
				userName = userUserName;
				return "true";
			}else
				matchReturn =  "Username not exist!";
		}
		return matchReturn;
	}

	/*
	public String toString() {
		String temp="";
		for(int i=0;i<loginUser.size();i++) {
			temp+=loginUser.get(i).getUserName()+"\n";
		}
		return temp;
	}
	*/
}