package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import admin.dao.*;
import model.*;

@WebServlet("/LoginAdminController")
public class LoginAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DaoAdmin dao;
    public LoginAdminController() {
        super();
        dao = new DaoAdmin();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin a = new Admin();
		a.setAdmin_icnum(request.getParameter("admin_icnum"));
		a.setAdd_password(request.getParameter("add_password"));
		//long adminic = Integer.parseInt(request.getParameter("admin_icnum"));
		String adminic = request.getParameter("admin_icnum");
		System.out.println(adminic);
		switch(adminic) {
			case "000810100717":
				a = DaoAdmin.loginSupervisor(a);
				if(a.isValid()) {
					HttpSession session = request.getSession(true);
					session.setAttribute("currentSessionUser", a.getAdminid());
					request.setAttribute("a", DaoAdmin.getAdminById(a.getAdminid()));
					RequestDispatcher view = request.getRequestDispatcher("homesupervisor.jsp");
					view.forward(request, response);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Ic Number & Password", "Error Occurred", JOptionPane.WARNING_MESSAGE);
					response.sendRedirect("loginadmin.jsp");
				}
				System.out.println("Login Supervisor");
				break;
			case "670541012342":
				a = DaoAdmin.loginSupervisor(a);
				if(a.isValid()) {
					HttpSession session = request.getSession(true);
					session.setAttribute("currentSessionUser", a.getAdminid());
					request.setAttribute("a", DaoAdmin.getAdminById(a.getAdminid()));
					RequestDispatcher view = request.getRequestDispatcher("homesupervisor.jsp");
					view.forward(request, response);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Ic Number & Password", "Error Occurred", JOptionPane.WARNING_MESSAGE);
					response.sendRedirect("loginadmin.jsp");
				}
				System.out.println("Login Supervisor");
				break;
			default:
				a = DaoAdmin.loginAdmin(a);
				
				if(a.isValid()) {
					HttpSession session = request.getSession(true);
					session.setAttribute("currentSessionUser", a.getAdminid());
					request.setAttribute("a", DaoAdmin.getAdminById(a.getAdminid()));
					RequestDispatcher view = request.getRequestDispatcher("homeadmin.jsp");
					view.forward(request, response);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Please enter a valid Ic Number & Password", "Error Occurred", JOptionPane.WARNING_MESSAGE);
					response.sendRedirect("loginadmin.jsp");
				}
				System.out.println("Login Normal Admin");
				break;
		}
	}
}

