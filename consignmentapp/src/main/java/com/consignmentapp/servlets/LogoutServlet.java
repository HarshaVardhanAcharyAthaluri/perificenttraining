package com.consignmentapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 HttpSession session = request.getSession();
			 session.invalidate();
			 request.setAttribute("logoutmsg", "Logged Out Seeccessfully");
			 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			 rd.forward(request, response);
			 
	}


}
