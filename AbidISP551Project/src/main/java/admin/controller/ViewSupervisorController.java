package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.dao.*;
@WebServlet("/ViewSupervisorController")
public class ViewSupervisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoAdmin dao;
    public ViewSupervisorController() {
        super();
        dao = new DaoAdmin();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int id = (int)session.getAttribute("currentSessionUser");
		request.setAttribute("a", DaoAdmin.getAdminById(id));
		RequestDispatcher view = request.getRequestDispatcher("homesupervisor.jsp");
		view.forward(request, response);
	}
}
