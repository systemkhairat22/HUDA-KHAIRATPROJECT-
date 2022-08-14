package khairat.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khairat.dao.DaoKhairat;

@WebServlet("/ListClaimController")
public class ListClaimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoKhairat dao;
	
    public ListClaimController() {
        super();
        dao = new DaoKhairat();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("claimkhairat", DaoKhairat.getAllAppClaim());
		RequestDispatcher view = request.getRequestDispatcher("listapplicationclaim.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("claimkhairat", DaoKhairat.getAllAppClaim());
		RequestDispatcher view = request.getRequestDispatcher("listapplicationclaim.jsp");
		view.forward(request, response);
	}

}
