package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import member.dao.*;

@WebServlet("/SearchMemberController")
public class SearchMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchMemberController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String search = request.getParameter("search");
		request.setAttribute("member", DaoMember.getAllMemberBySearch(search));
		System.out.println(search);
		
		RequestDispatcher view = request.getRequestDispatcher("listmember.jsp");
		view.forward(request, response);
		
	}


}
