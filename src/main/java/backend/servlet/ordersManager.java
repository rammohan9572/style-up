package backend.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.DB.OrderDetailsDB;
import backend.classes.HTMLProvider;
import backend.classes.ProductDetails;

/**
 * Servlet implementation class ordersManager
 */
@WebServlet("/ordersManager")
public class ordersManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ordersManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {	
			
			Cookie ck[] = request.getCookies();
			String name= null,mobile=null;
			String pid= request.getParameter("pid");
			
			for(Cookie c: ck) {
				
				if(c.getName().toString().equals("name") )
					name= c.getValue();
				

				if(c.getName().toString().equals("mobile") )
					mobile= c.getValue();
				
				
			}
			
			if(name!=null && mobile !=null) {
				
				System.out.println("User Is Logged in");
				
				request.setAttribute("name", name);

				request.setAttribute("mobile", mobile);
				
				ServletContext context= getServletContext();
				context.setAttribute("pid",pid);
				context.setAttribute("name",name);
				context.setAttribute("mobile",mobile);

				
				PrintWriter pw = response.getWriter();
				pw.print(HTMLProvider.getBookingPage(name, mobile,ProductDetails.getProductDetails(pid).get(0)));
				pw.close();
				
				
			
//				OrderDetailsDB.insertRecord(mobile,pid );
//				
//				response.getWriter().append("<script> alert(\"Appointment Booked\")</script> "
//						+ "<script>window.location.replace(\"/style_up/cart\");</script>");
//				
				
			}
			
			
			
		}catch(Exception e) {
			System.out.println("User Is Logged out ");
		response.setContentType("text/html");
		
		response.getWriter().append("<script> alert(\"Please Login to Book Appointment\")</script> "
				+ "<script>window.location.replace(\"/style_up/login.html\");</script>");
		

	
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
