package model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.User;

public class test {
	public static void main(String[] args)
	{
		/*
		User temp = new User("","","","","");
		try {
			temp.loadUser("data/users.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(temp.validate("peter1"));
		//String ssss = temp.toString();
		System.out.println(temp);
		*/
		
		/*
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy");
		String temp=dateFormat.format(calendar.getTime());
		System.out.println(temp);
		*/
		
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		System.out.println(dateFormat.format(date));
	}
}
