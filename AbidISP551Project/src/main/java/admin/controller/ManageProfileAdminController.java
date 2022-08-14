package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.*;
import user.model.*;
@WebServlet("/ManageProfileAdminController")
public class ManageProfileAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DaoAdmin dao;   
    
    public ManageProfileAdminController() {
        super();
        dao = new DaoAdmin();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adminid = (int) request.getSession().getAttribute("currentSessionUser");
		request.setAttribute("a", DaoAdmin.getAdminById(adminid));
		RequestDispatcher view = request.getRequestDispatcher("manageadmin.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Admin a = new Admin();
		
		//CONDITION IF CHANGE PASSWORD
		if(action.equalsIgnoreCase("change_pass")) {
			//TO CHANGE PASSWORD
			a.setAdminid((int) request.getSession().getAttribute("currentSessionUser"));
			a.setAdd_password(request.getParameter("current_pass"));
			String new_pass = request.getParameter("new_pass");
			//CHECK CURRENT PASSWORD
			a = DaoAdmin.loginAdmin(a);
			//IF PASSWORD VALID
			if(a.isValid()) {
				//CHANGE PASSWORD
				dao.ChangeAdminPassword(a, new_pass);
				a.setAdd_password(new_pass);
			}
		}
		//CONDITION IF UPDATE PROFILE
		if(action.equalsIgnoreCase("update_profile")) {
			//TO UPDATE PROFILE
			a.setAdminid((int) request.getSession().getAttribute("currentSessionUser"));
			a.setAdd_age(Integer.parseInt(request.getParameter("add_age")));
			a.setAdd_phonenum(request.getParameter("add_phonenum"));
			a.setAdd_email(request.getParameter("add_email"));
			//UPDATE PROFILE
			dao.updateadmin(a);
		}
		
		//FORWARD TO MANAGE ADMIN
		request.setAttribute("a", DaoAdmin.getAdminById(a.getAdminid()));
		RequestDispatcher view = request.getRequestDispatcher("manageadmin.jsp");
		view.forward(request, response);
	}

}
