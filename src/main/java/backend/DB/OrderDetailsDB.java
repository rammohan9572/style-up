package backend.DB;

import java.sql.Connection;


import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;

import backend.classes.BookedItem;

import java.sql.*;

public class OrderDetailsDB {
	
	static Connection conLogin;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conLogin= DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","root" );
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void insertRecord(String mobile,String product_id,String date, String address) {
		try {
		Statement stmt= conLogin.createStatement();
		System.out.println("registering in DB");
		String sql = "insert into orders values('"+mobile+"','"+product_id+"','"+date+"','"+address+"')";
		System.out.println(sql);
		
		stmt.execute(sql);
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
public static ArrayList<BookedItem> getProductDetails(String mobile) {
		
	ArrayList<BookedItem> ProductList=new ArrayList<BookedItem>();
		try {
		
			Statement stmt= conLogin.createStatement();
			System.out.println("checking details in DB");
			String sql = "select * from orders where mobile="+mobile;
			System.out.println(sql);
			
			ResultSet result= stmt.executeQuery(sql);
			 
			while(result.next()) {

				String pid = result.getString("product_id");

				String date = result.getString("dates");
				String address = result.getString("address");
				ProductList.add(new BookedItem(pid,date,address));
							
			}
			
		    Collections.reverse(ProductList);
			return ProductList;
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
		
		
	}

	
	
	
	

}
