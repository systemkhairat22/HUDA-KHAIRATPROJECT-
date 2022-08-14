package khairat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khairat.dao.*;

@WebServlet("/DeletePaymentController")
public class DeletePaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DaoKhairat dao;
    
    public DeletePaymentController() {
        super();
        dao = new DaoKhairat();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("paymentid"));
		dao.deletePayment(id);
		request.setAttribute("payment", DaoKhairat.getAllPayment());
		RequestDispatcher view = request.getRequestDispatcher("listpayment.jsp");
		view.forward(request, response);
	}

}
