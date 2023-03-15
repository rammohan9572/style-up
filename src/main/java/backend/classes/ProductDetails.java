package backend.classes;

import java.util.ArrayList;

public class ProductDetails {

	
	public static ArrayList<String> getProductDetails(String pid){
		ArrayList<String> arr= new ArrayList<String>();
	if(	pid.equals("p1"))
	{
		arr.add("Women's Parlour");
		arr.add("Our committed and competent team is here to help keep your hair, nails, skin, and body healthy and beautiful. In addition to our regular beauty services such as pedicures, manicures, and hair services we will continue to perfect our skills and keep educated on all the latest styles. Enjoy our wide range of services in a cozy and luxurious environment. We look forward to serving you!\r\n"
				+ "\r\n"
				);
		
		arr.add("img/women.jpg");
	}
	
	else if(	pid.equals("p2"))
	{
		arr.add("Men's Parlour");
//		arr.add("The art of looking handsome and getting makeovers has its own story for men and one cannot imagine the number of styles and treatments that can be done on these hunks. Moreover, the desire to have a unique identity is everyone's' want and Looks Salon makes that possible. From grooming to beauty sessions, we offer a wide range of services and treatments that every man wishes to get.\r\n")+"\r\n";
		arr.add("The art of looking handsome and getting makeovers has its own story for men and one cannot imagine the number of styles and treatments that can be done on these hunks. Moreover, the desire to have a unique identity is everyone's' want and Looks Salon makes that possible. From grooming to beauty sessions, we offer a wide range of services and treatments that every man wishes to get.\r\n"
				+ "\r\n"
				);
		arr.add("img/2.jpg");
	}
		
	else if(	pid.equals("p3"))
	{
		arr.add("Kid's Parlour");
		arr.add("A kids haircut at Starfish is different from getting one at any other salon! With a cheerful set up and entertainment screens to the trained and child friendly team, it will be a special experience for your child! Kids love to walk out after a great haircut and a treat at the end of every visit.\r\n"
				+ "\r\n"
				+ "");
		arr.add("img/baby.jpg");
	}
		
		
		
		return arr;
		
	}
	
	
}
