package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.*;
@WebServlet("/ViewMemberController")
public class ViewMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  DaoMember dao;
    public ViewMemberController() {
        super();
        dao= new DaoMember();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("memberid"));
	    request.setAttribute("m", DaoMember.getMemberById(id));
	    RequestDispatcher view = request.getRequestDispatcher("viewmember.jsp");
	    view.forward(request, response);
	}
}
