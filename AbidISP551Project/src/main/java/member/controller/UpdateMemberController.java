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

@WebServlet("/UpdateMemberController")
public class UpdateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoMember dao;
    public UpdateMemberController() {
        super();
        dao = new DaoMember();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("memberid"));
		request.setAttribute("m", DaoMember.getMemberById(id));
		RequestDispatcher view = request.getRequestDispatcher("updatemember.jsp");
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m = new Member();
		m.setMemberid(Integer.parseInt(request.getParameter("memberid")));
		m.setMem_name(request.getParameter("mem_name"));
		m.setMem_icnum(request.getParameter("mem_icnum"));
		m.setMem_age(Integer.parseInt(request.getParameter("mem_age")));
		m.setMem_address(request.getParameter("mem_address"));
		m.setMem_phonenum(request.getParameter("mem_phonenum"));
		m.setRepname(request.getParameter("repname"));
		m.setRepnum(request.getParameter("repnum"));
		m.setMem_email(request.getParameter("mem_email"));
		m.setMem_password(request.getParameter("mem_password"));
	   
		dao.updatemember(m);
		
		request.setAttribute("member", DaoMember.getAllMember());
		RequestDispatcher view = request.getRequestDispatcher("listmember.jsp");
		view.forward(request, response);
	}

}
