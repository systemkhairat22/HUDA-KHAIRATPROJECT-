package khairat.controller;
import java.io.FileOutputStream;



import java.io.IOException;
import java.io.InputStream;
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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import khairat.dao.*;
import khairat.model.*;
import member.dao.*;

@MultipartConfig
@WebServlet("/OnlinePaymentController")
public class OnlinePaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DaoKhairat dao;   
    public OnlinePaymentController() {
        super();
        dao = new DaoKhairat();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = (int) request.getSession().getAttribute("currentSessionUser");
		request.setAttribute("m", DaoMember.getMemberById(id));
	    RequestDispatcher view = request.getRequestDispatcher("onlinepayment.jsp");
	    view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In do post method");
		Payment p = new Payment();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		
		try {
			Date parsedDate = format.parse(request.getParameter("payment_date"));
			p.setPayment_date(parsedDate);
		}catch (ParseException e) {
			e.printStackTrace();
		}
		//image upload
		Part file = request.getPart("payment_receipt");
		p.setPayment_amount(Double.parseDouble(request.getParameter("payment_amount")));
		p.setPayment_receipt(file.getSubmittedFileName());//sent file name into model
		System.out.println("Selected Image File Name : " + file.getSubmittedFileName());
		p.setMemberid((int)session.getAttribute("currentSessionUser"));
		p.setTransactionid(request.getParameter("transactionid"));
		p.setBank_name(request.getParameter("bank_name"));
		dao.onlinePayment(p);
		
		//set an upload path of file
		String uploadPath = "C:/Users/Admin/git/HUDA-KHAIRATPROJECT-/BaruProjectHuda/src/main/webapp/receiptimg" + file.getSubmittedFileName();
		System.out.println("Upload Path : "+uploadPath);
		
		//uploading selected file into folder
		FileOutputStream fos = new FileOutputStream(uploadPath);
		InputStream is = file.getInputStream();
		try {
			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null,"Payment successfull");
		request.setAttribute("m", DaoMember.getMemberById((int)session.getAttribute("currentSessionUser")));
		RequestDispatcher view = request.getRequestDispatcher("homemember.jsp");
		view.forward(request, response);
	}

}
