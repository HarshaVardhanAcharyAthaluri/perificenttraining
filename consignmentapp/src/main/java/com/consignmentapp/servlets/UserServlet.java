package com.consignmentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.consignmentapp.dao.UserDao;
import com.consignmentapp.dao.UserDto;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userservlet")
public class UserServlet extends HttpServlet {
	UserDao dao = new UserDao();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		
		switch (path) {
		case "/save":
			String username = request.getParameter("username");
			String address = request.getParameter("addr");
			String role = request.getParameter("role");
			String password = request.getParameter("password");

			String respMsg = dao.saveUser(username, address, role, password);
			List<UserDto> userslist = dao.getUsers();
			request.setAttribute("jspusers", userslist);
			 RequestDispatcher rd= request.getRequestDispatcher("userlist.jsp");
				rd.forward(request, response);
			break;

		default:
			break;
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String path = request.getServletPath();
		  String path= request.getParameter("path");
		  System.out.println(path);
		 switch (path) {
		case "list":
			List<UserDto> userslist = dao.getUsers();
			request.setAttribute("jspusers", userslist);
			RequestDispatcher rd= request.getRequestDispatcher("userlist.jsp");
			rd.forward(request, response);
			break;
			case "delete":
				String username = request.getParameter("name");
				List<UserDto> updatedlist = dao.deleteUser(username);
				request.setAttribute("jspusers", updatedlist);
				RequestDispatcher rd2= request.getRequestDispatcher("userlist.jsp");
				rd2.forward(request, response);
				break;
			case "adduser":
				RequestDispatcher rd1= request.getRequestDispatcher("userdetails.jsp");
				rd1.forward(request, response);
				break;
		default:
			break;
		}
		
	}
	

}
