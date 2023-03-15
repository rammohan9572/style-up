package backend.servlet;

import java.io.*;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.DB.DataBase;

import javax.servlet.http.*;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
		
		System.out.println(mobile+ " Login  "+password);	
		
		if(DataBase.checkLogin(mobile,password)) {

			String name= DataBase.getName(mobile, password).toString();
			
			System.out.println("name =  "+name);
			
			try {
				
			Cookie ck = new Cookie("name",name);
			Cookie ck1 = new Cookie("mobile",mobile);
			response.addCookie(ck);
			response.addCookie(ck1);

			response.getWriter().append( "<script>window.location.replace(\"Entry\");</script>");
			
			}catch(Exception e) {
				response.getWriter().append("<script> alert(\"An error occured\")</script> "
						+ "<script>window.location.replace(\"/style_up/login.html\");</script>");
					
			}
			
			System.out.println("Login done");
			
			
		}else {
//			PrintWriter pw= response.getWriter();
			response.getWriter().append("<script> alert(\"Login Failed: You have entered Wrong Mobile number or Password\")</script> "
					+ "<script>window.location.replace(\"login.html\");</script>");
			
    			System.out.println("Login failed");
//			pw.println("Wrong password");
					
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
