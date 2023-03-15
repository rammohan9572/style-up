package backend.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.DB.OrderDetailsDB;

/**
 * Servlet implementation class confirmOrder
 */
@WebServlet("/confirmOrder")
public class confirmOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		ServletContext context= getServletContext();
		String pid = (String)context.getAttribute("pid");
        String name = (String)context.getAttribute("name");
		String mobile = (String)context.getAttribute("mobile");
		String date = request.getParameter("date");
		String address = request.getParameter("address");
		
		if(date.length()==0 || address.length()==0) {
			throw new Exception("");
		}
		
		OrderDetailsDB.insertRecord(mobile,pid,date,address );
		
		response.getWriter().append("<script> alert(\"Appointment Booked\")</script> "
				+ "<script>window.location.replace(\"/style_up/cart\");</script>");
//		
		
		
		}catch(Exception e) {
			response.setContentType("text/html");
			
			response.getWriter().append("<script> alert(\"Some Error Occured\")</script> "
					+ "<script>window.location.replace(\"Entry\");</script>");
			


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
