package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutMemberController")
public class LogoutMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LogoutMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//get the current session
			HttpSession session = request.getSession(true);
			//set current session to null
			session.setAttribute("currentSessionUser", null);
			//destroy session
			session.invalidate();
			//redirect to login page
			response.sendRedirect("index.html");
		}catch(Throwable ex) {
			System.out.println(ex);
		}
	}

}
