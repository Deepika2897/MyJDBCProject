package com.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DbConnect {

	public static void main(String[] args) {
		int userpassword;
		String username;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		username=sc.next();
		System.out.println("Enter userpassword");
		userpassword=sc.nextInt();
		//MAKE A CONNECTION WITH DATABASE
		String driver="com.mysql.cj.jdbc.Driver";
		//In the Url statement Give the name of the database created in mysql 
		String url="jdbc:mysql://localhost:3306/Deepika";
		String un="root";
		String pa="root";
		try {
		//loading the driver
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,un,pa);
			Statement st=conn.createStatement();
			String ins="insert into login values('"+username+"','"+userpassword+"')";
			
			int i=st.executeUpdate(ins);
			if(i>0)
			{
				System.out.println("Record inserted");
		}
			else
			{
				System.out.println("Not inserted");
			}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}

