package com.consignmentapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.consignmentapp.dao.ConsignmentDao;
import com.consignmentapp.dao.ConsignmentDto;
import com.consignmentapp.dao.UserDto;

/**
 * Servlet implementation class Consignment
 */
@WebServlet("/consignmentservlet")
public class ConsignmentServlet extends HttpServlet {
	private ConsignmentDao dao = new ConsignmentDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("path");
		 switch (path) {
		case "consignmentlist":
			List<ConsignmentDto> consognments = dao.getConsignemnts();
			request.setAttribute("jspconsognments", consognments);
			RequestDispatcher rd= request.getRequestDispatcher("consignmnets.jsp");
			rd.forward(request, response);
			break;
			case "consignmentdelete":
				String cid = request.getParameter("cid");
				 Integer intcid = Integer.parseInt(cid);
				List<ConsignmentDto> consignemntlist = dao.deleteConsignment(intcid);
				request.setAttribute("jspconsognments", consignemntlist);
				RequestDispatcher rd2= request.getRequestDispatcher("consignmnets.jsp");
				rd2.forward(request, response);
				break;
			case "addconsignment":
				RequestDispatcher rd1= request.getRequestDispatcher("addconsignment.jsp");
				rd1.forward(request, response);
				break;
		default:
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getParameter("path");
		switch (path) {
		case "consignmentsave":
			String cname = request.getParameter("cname");
			String qunatity = request.getParameter("qunatity");
			Integer intqunatity = Integer.parseInt(qunatity);
			String status = request.getParameter("status");

			String respMsg = dao.saveConsignment(cname, intqunatity, status);
			List<ConsignmentDto> consignments = dao.getConsignemnts();
			request.setAttribute("jspconsognments", consignments);
			 RequestDispatcher rd= request.getRequestDispatcher("consignmnets.jsp");
				rd.forward(request, response);
			break;

		default:
			break;
		}
	}

}
