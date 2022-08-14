package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.*;
import admin.dao.*;
@WebServlet("/CreateAdminController")
public class CreateAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DaoAdmin dao;
    public CreateAdminController() {
        super();
        dao = new DaoAdmin();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin a = new Admin();
		HttpSession session = request.getSession(true);
		a.setAdd_name(request.getParameter("add_name"));
		a.setAdmin_icnum(request.getParameter("admin_icnum"));
		a.setAdd_age(Integer.parseInt(request.getParameter("add_age")));
		a.setAdd_phonenum(request.getParameter("add_phonenum"));
		a.setAdd_email(request.getParameter("add_email"));
		//a.setAdd_password(request.getParameter("add_password"));
		a.setSupervisorid((int)session.getAttribute("currentSessionUser"));
		dao.addAdmin(a); //invoke method addmember() in memberDAO
		
		request.setAttribute("admin", DaoAdmin.getAllAdmin((int)session.getAttribute("currentSessionUser")));
		RequestDispatcher view = request.getRequestDispatcher("listadmin.jsp");
		view.forward(request, response);
	}

}
