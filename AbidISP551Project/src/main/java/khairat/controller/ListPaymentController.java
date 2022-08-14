package khairat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khairat.dao.DaoKhairat;


@WebServlet("/ListPaymentController")
public class ListPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DaoKhairat dao;   

    public ListPaymentController() {
        super();
        dao = new DaoKhairat();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("payment", DaoKhairat.getAllPayment());
		RequestDispatcher view = request.getRequestDispatcher("listpayment.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("payment", DaoKhairat.getAllPayment());
		RequestDispatcher view = request.getRequestDispatcher("listpayment.jsp");
		view.forward(request, response);
	}

}
