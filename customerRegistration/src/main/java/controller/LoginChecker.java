package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.CustomerDto;
import model.LoginAuthenticator;

/**
 * Servlet implementation class LoginChecker
 */
//@WebServlet("/LoginChecker")
public class LoginChecker extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendRedirect("login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		CustomerDto user = new CustomerDto();
		user.setUsername(username);
		user.setPassword(password);
		
		LoginAuthenticator authenticator = new LoginAuthenticator();
		boolean login = authenticator.isLogin(user);
		
		if(login)
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("username",username);
			response.sendRedirect("home.jsp");
		}
		else
			response.sendRedirect("login.html");
			
	}
}
