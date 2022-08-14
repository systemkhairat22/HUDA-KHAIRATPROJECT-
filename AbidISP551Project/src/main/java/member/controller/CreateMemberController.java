package member.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.*;
import member.dao.*;

@WebServlet("/CreateMemberController")
public class CreateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoMember dao;
    public CreateMemberController() {
        super();
        dao = new DaoMember();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Member m = new Member();
		m.setMem_name(request.getParameter("mem_name"));
		m.setMem_icnum(request.getParameter("mem_icnum"));
		m.setMem_age(Integer.parseInt(request.getParameter("mem_age")));
		m.setMem_address(request.getParameter("mem_address"));
		m.setMem_phonenum(request.getParameter("mem_phonenum"));
		m.setRepname(request.getParameter("repname"));
		m.setRepnum(request.getParameter("repnum"));
		m.setMem_email(request.getParameter("mem_email"));
		//m.setMem_password(request.getParameter("mem_password"));
		
		dao.addMember(m); //invoke method addShawl() in ShawlDAO
		
		request.setAttribute("member", DaoMember.getAllMember());
		RequestDispatcher view = request.getRequestDispatcher("listmember.jsp");
		view.forward(request, response);
	}

}
