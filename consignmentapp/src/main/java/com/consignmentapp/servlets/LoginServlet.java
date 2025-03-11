package com.consignmentapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.consignmentapp.dao.UserDao;
import com.consignmentapp.dao.UserDto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	UserDao dao = new UserDao();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		if(dao.getuserByName(username, password)) {
			System.out.println("LOGIN SUCCES");
			HttpSession session = request.getSession();
			session.setAttribute("isLoggedin", true);
			System.out.println(session.getAttribute("isLoggedin"));
			RequestDispatcher  rd= request.getRequestDispatcher("/index");
			rd.forward(request, response);
		}else {
			System.out.println("LOGIN FAILURE");
			request.setAttribute("loginfailed", "Login Failed Check Details");
			RequestDispatcher  rd= request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
	}

}
