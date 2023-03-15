package backend.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.DB.OrderDetailsDB;
import backend.classes.HTMLProvider;

/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public cart() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

try {	
			
			Cookie ck[] = request.getCookies();
			String name= null,mobile=null;
			
			for(Cookie c: ck) {
				
				if(c.getName().toString().equals("name") )
					name= c.getValue();
				

				if(c.getName().toString().equals("mobile") )
					mobile= c.getValue();
				
				
			}
			
			if(name!=null && mobile !=null) {
				
				System.out.println("User Is Logged in");
				
				PrintWriter pw = response.getWriter();
				pw.print( HTMLProvider.getCart(name,OrderDetailsDB.getProductDetails(mobile)) );
				pw.close();
				
				
			}
			
			else 
			{
				System.out.println("User Is Logged out ");
				response.setContentType("text/html");
				response.getWriter().append("<script> alert(\"Please Login First...\")</script> "
						+ "<script>window.location.replace(\"login.html\");</script>");
				
				
			}
			
			
			
			
		}catch(Exception e) {
			
			
		PrintWriter pw = response.getWriter();
		pw.print(HTMLProvider.getCart());
		pw.close();
		}
		

		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
