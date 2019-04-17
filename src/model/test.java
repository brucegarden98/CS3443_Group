package model;

import java.io.IOException;

import model.User;

public class test {
	public static void main(String[] args)
	{
		User temp = new User("","","","","");
		try {
			temp.loadUser("data/users.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(temp.validate("peter1"));
		//String ssss = temp.toString();
		System.out.println(temp);
	}

}
