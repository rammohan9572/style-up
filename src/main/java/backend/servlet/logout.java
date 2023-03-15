package backend.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append(""");
		
		
			try {
			
			Cookie ck[] = request.getCookies();
			String name= null,mobile=null;
			
			for(Cookie c: ck) {
				
				if(c.getName().toString().equals("name") )
				{
					c.setMaxAge(0);
					response.addCookie(c);
				}
				

				if(c.getName().toString().equals("mobile") )
				{
					c.setMaxAge(0);
					response.addCookie(c);
				}
				
				
			}
			
			
		}catch(Exception e) {
		
			
		}

	response.getWriter().append(" <script> window.location.replace(\"/style_up/Entry\") </script>");
		
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}