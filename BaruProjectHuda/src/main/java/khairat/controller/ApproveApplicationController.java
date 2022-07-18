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

@WebServlet("/ApproveApplicationController")
public class ApproveApplicationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoKhairat dao;
    public ApproveApplicationController() {
        super();
        dao = new DaoKhairat();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doPost method Approve Application Controller");
		Claimkhairat c = new Claimkhairat();
		HttpSession session = request.getSession(true);
		c.setAdminid((int)session.getAttribute("currentSessionUser"));
		c.setApplicationid(Integer.parseInt(request.getParameter("applicationid")));
		dao.approveApplication(c);
		
		RequestDispatcher view = request.getRequestDispatcher("listapplicationclaim.jsp");
		view.forward(request, response);
	}

}

