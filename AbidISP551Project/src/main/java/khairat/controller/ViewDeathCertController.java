package khairat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khairat.dao.DaoKhairat;


@WebServlet("/ViewDeathCertController")
public class ViewDeathCertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoKhairat dao;
    public ViewDeathCertController() {
        super();
        dao = new DaoKhairat();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In do get method View Death Certificate Controller");
		int id = Integer.parseInt(request.getParameter("applicationid"));
	    request.setAttribute("c", DaoKhairat.viewDeathCertById(id));
	    RequestDispatcher view = request.getRequestDispatcher("viewdeathcert.jsp");
	    view.forward(request, response);
	}
}
