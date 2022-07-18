package khairat.controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import khairat.model.*;
import khairat.dao.*;
import member.dao.*;
import admin.dao.*;

@WebServlet("/CashPaymentController")
public class CashPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DaoKhairat dao;   
    public CashPaymentController() {
        super();
        dao = new DaoKhairat();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = (int) request.getSession().getAttribute("currentSessionUser");
		request.setAttribute("m", DaoMember.getMemberById(id));
		request.setAttribute("admin", DaoAdmin.getAllAdminContact());
	    RequestDispatcher view = request.getRequestDispatcher("cashpayment.jsp");
	    view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Payment p = new Payment();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		
		try {
			Date parsedDate = format.parse(request.getParameter("payment_date"));
			p.setPayment_date(parsedDate);
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		p.setPayment_amount(Double.parseDouble(request.getParameter("payment_amount")));
		p.setMemberid((int)session.getAttribute("currentSessionUser"));
		
		dao.cashPayment(p);
		JOptionPane.showMessageDialog(null,"Please make a payment to our admin");
		request.setAttribute("m", DaoMember.getMemberById((int)session.getAttribute("currentSessionUser")));
		RequestDispatcher view = request.getRequestDispatcher("homemember.jsp");
		view.forward(request, response);
	}

}
