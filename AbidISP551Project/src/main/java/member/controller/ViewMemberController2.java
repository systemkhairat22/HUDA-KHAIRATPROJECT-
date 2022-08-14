package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.DaoMember;

@WebServlet("/ViewMemberController2")
public class ViewMemberController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  DaoMember dao;   
    
    public ViewMemberController2() {
        super();
        dao= new DaoMember();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int id = (int)session.getAttribute("currentSessionUser");
	    request.setAttribute("m", DaoMember.getMemberById(id));
	    RequestDispatcher view = request.getRequestDispatcher("homemember.jsp");
	    view.forward(request, response);
	}
}
