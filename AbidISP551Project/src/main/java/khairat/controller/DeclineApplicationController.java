package khairat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import khairat.dao.*;
import khairat.model.*;
@WebServlet("/DeclineApplicationController")
public class DeclineApplicationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoKhairat dao;
    public DeclineApplicationController() {
        super();
        dao = new DaoKhairat();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Claimkhairat c = new Claimkhairat();
		HttpSession session = request.getSession();
		c.setAdminid((int)session.getAttribute("currentSessionUser"));
		dao.declineApplication(c);
		
		RequestDispatcher view = request.getRequestDispatcher("listapplicationclaim.jsp");
		view.forward(request, response);
	}

}
