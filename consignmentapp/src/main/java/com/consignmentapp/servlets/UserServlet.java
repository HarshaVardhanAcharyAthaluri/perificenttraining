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
import javax.servlet.http.HttpSession;

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
		HttpSession session =  request.getSession();
		Boolean isLoogedIn=  session.getAttribute("isLoggedin")!=null?(Boolean)session.getAttribute("isLoggedin"):false;
		if(isLoogedIn) {

				String username = request.getParameter("username");
				String address = request.getParameter("addr");
				String role = request.getParameter("role");
				String password = request.getParameter("password");

				String respMsg = dao.saveUser(username, address, role, password);
				List<UserDto> userslist = dao.getUsers();
				request.setAttribute("jspusers", userslist);
				 RequestDispatcher rd= request.getRequestDispatcher("/userlist");
					rd.forward(request, response);
		}else {
			RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String path= request.getParameter("path");
			HttpSession session =  request.getSession();
			Boolean isLoogedIn=  session.getAttribute("isLoggedin")!=null?(Boolean)session.getAttribute("isLoggedin"):false;
		  if(isLoogedIn) {
			  switch (path) {
				case "list":
					List<UserDto> userslist = dao.getUsers();
					request.setAttribute("jspusers", userslist);
					RequestDispatcher rd= request.getRequestDispatcher("/userlist");
					rd.forward(request, response);
					break;
					case "delete":
						String username = request.getParameter("name");
						List<UserDto> updatedlist = dao.deleteUser(username);
						request.setAttribute("jspusers", updatedlist);
						RequestDispatcher rd2= request.getRequestDispatcher("/userlist");
						rd2.forward(request, response);
						break;
					case "adduser":
						RequestDispatcher rd1= request.getRequestDispatcher("/userdetails");
						rd1.forward(request, response);
						break;
				default:
					break;
				}
		  }else {
			  RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
		  }
		  
		
		
	}
	

}
