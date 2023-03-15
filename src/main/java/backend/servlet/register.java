package backend.servlet;

import java.io.IOException;


import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.DB.DataBase;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public register() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
 
		response.setContentType("text/html");
		
		try {
		
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
		
		if(email.length()==0 || name.length()==0|| mobile.length()==0|| password.length()==0) {
			response.getWriter().append("<script> alert(\"Invalid Inputs\")</script> "
					+ "<script>window.location.replace(\"sigup.html\");</script>");
			return;
		}
		
		
		
		DataBase.insertRecord(name,email, mobile, password);
		
		response.getWriter().append("<script> alert(\"Registration Complete\")</script> "
				+ "<script>window.location.replace(\"Entry\");</script>");
		}catch(Exception e) {
			response.getWriter().append("<script> alert(\"Something Wrong Happend\")</script> "
					+ "<script>window.location.replace(\"sigup.html\");</script>");
			
		}
   
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
