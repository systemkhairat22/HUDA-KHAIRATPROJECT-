package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import member.dao.*;
import user.model.*;
@WebServlet("/ManageProfileMemberController")
public class ManageProfileMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoMember dao;
    public ManageProfileMemberController() {
        super();
        dao = new DaoMember();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberid = (int) request.getSession().getAttribute("currentSessionUser");
		request.setAttribute("m", DaoMember.getMemberById(memberid));
		RequestDispatcher view = request.getRequestDispatcher("managemember.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Member m = new Member();
		
		//CONDITION IF CHANGE PASSWORD
		if(action.equalsIgnoreCase("change_pass")) {
			//TO CHANGE PASSWORD
			m.setMemberid((int) request.getSession().getAttribute("currentSessionUser"));
			m.setMem_password(request.getParameter("current_pass"));
			String new_pass = request.getParameter("new_pass");
			//CHECK CURRENT PASSWORD
			m = DaoMember.loginMember(m);
			//IF PASSWORD VALID
			if(m.isValid()) {
				//CHANGE PASSWORD
				dao.ChangeMemberPassword(m, new_pass);
				m.setMem_password(new_pass);
			}
		}
		//CONDITION IF UPDATE PROFILE
		if(action.equalsIgnoreCase("update_profile")) {
			//TO UPDATE PROFILE
			m.setMemberid((int) request.getSession().getAttribute("currentSessionUser"));
			m.setMem_age(Integer.parseInt(request.getParameter("mem_age")));
			m.setMem_address(request.getParameter("mem_address"));
			m.setMem_phonenum(request.getParameter("mem_phonenum"));
			m.setRepname(request.getParameter("repname"));
			m.setRepnum(request.getParameter("repnum"));
			m.setMem_email(request.getParameter("mem_email"));
			//UPDATE PROFILE
			dao.updatemember(m);
		}
		//FORWARD TO MANAGE MEMBER
		request.setAttribute("m", DaoMember.getMemberById(m.getMemberid()));
		RequestDispatcher view = request.getRequestDispatcher("managemember.jsp");
		view.forward(request, response);
	}

}
