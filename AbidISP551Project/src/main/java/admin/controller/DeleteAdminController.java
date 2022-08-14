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
@WebServlet("/DeleteAdminController")
public class DeleteAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoAdmin dao;
    public DeleteAdminController() {
        super();
        dao = new DaoAdmin();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("adminid"));
		HttpSession session = request.getSession(true);
		dao.deleteadmin(id);
		request.setAttribute("admin", DaoAdmin.getAllAdmin((int)session.getAttribute("currentSessionUser")));
		RequestDispatcher view = request.getRequestDispatcher("listadmin.jsp");
		view.forward(request, response);
	}
}
