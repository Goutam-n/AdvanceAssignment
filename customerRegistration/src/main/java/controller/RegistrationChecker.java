package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.CustomerDto;
import model.RegistrationAuthenticator;
/**
 * Servlet implementation class RegistrationChecker
 */
@WebServlet("/RegistrationChecker")
public class RegistrationChecker extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendRedirect("login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String firstname = request.getParameter("firstname");
		String lastname  = request.getParameter("lastname");
		String address   = request.getParameter("address");
		String city      = request.getParameter("city");
		String zipcode   = request.getParameter("zipcode");
		String state     = request.getParameter("state");
		String country   = request.getParameter("country");
		String phone     = request.getParameter("phone");
		String username  = request.getParameter("username");
		String password  = request.getParameter("password");
		
		CustomerDto user = new CustomerDto();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setAddress(address);
		user.setCity(city);
		user.setZipcode(zipcode);
		user.setState(state);
		user.setCountry(country);
		user.setPhone(phone);
		user.setUsername(username);
		user.setPassword(password);
		
		
		RegistrationAuthenticator authenticator = new RegistrationAuthenticator();
		boolean login = authenticator.isRegister(user);
		
		if(login)
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("username",username);
			response.sendRedirect("login.html");
		}
		else
			response.sendRedirect("/registration.html");
			
	}

}
