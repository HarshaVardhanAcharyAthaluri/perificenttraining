package com.consignmentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.consignmentapp.dao.UserDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/saveuser")
public class UserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao dao = new UserDao();

		String username = request.getParameter("username");
		String address = request.getParameter("addr");
		String role = request.getParameter("role");
		String password = request.getParameter("password");

		String respMsg = dao.saveUser(username, address, role, password);
		PrintWriter out = response.getWriter();
		System.out.println("Details" + username + address + role + password);
		out.println("<h1>" + respMsg + "</h1>");
	}

}
