package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import member.dao.*;
import user.model.*;
@WebServlet("/LoginMemberController")
public class LoginMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoMember dao; 
    public LoginMemberController() {
        super();
        dao = new DaoMember();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member m = new Member();
		m.setMem_icnum(request.getParameter("mem_icnum"));
		m.setMem_password(request.getParameter("mem_password"));
		
		m = DaoMember.loginMember(m);
		if(m.isValid()) {
			HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser", m.getMemberid());
			request.setAttribute("m", DaoMember.getMemberById(m.getMemberid()));
			//request.setAttribute(getServletName(), session);
			RequestDispatcher view = request.getRequestDispatcher("homemember.jsp");
			view.forward(request, response);
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid Ic Number & Password", "Error Occurred", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect("loginmember.jsp");
		}
	}

}
