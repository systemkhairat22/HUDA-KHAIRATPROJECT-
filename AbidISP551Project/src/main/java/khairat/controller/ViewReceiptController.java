package khairat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khairat.dao.*;
@WebServlet("/ViewReceiptController")
public class ViewReceiptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoKhairat dao;
    public ViewReceiptController() {
        super();
        dao = new DaoKhairat();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In do get method View Receipt Controller");
		int id = Integer.parseInt(request.getParameter("paymentid"));
	    request.setAttribute("p", DaoKhairat.viewReceiptById(id));
	    RequestDispatcher view = request.getRequestDispatcher("viewreceipt.jsp");
	    view.forward(request, response);
	}
}
