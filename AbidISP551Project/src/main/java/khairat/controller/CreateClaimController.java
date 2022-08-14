package khairat.controller;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;

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
import member.dao.DaoMember;
@MultipartConfig
@WebServlet("/CreateClaimController")
public class CreateClaimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoKhairat dao;
    public CreateClaimController() {
        super();
        dao = new DaoKhairat();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = (int) request.getSession().getAttribute("currentSessionUser");
		request.setAttribute("m", DaoMember.getMemberById(id));
	    RequestDispatcher view = request.getRequestDispatcher("createapplicationclaim.jsp");
	    view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In do post method");
		Claimkhairat c = new Claimkhairat();
		HttpSession session = request.getSession();
		
		//image upload
		Part file = request.getPart("deathcertificate");
		
		c.setAppclaim_status("PENDING");
		c.setMemberid((int)session.getAttribute("currentSessionUser"));
		c.setAdminid(0);
		c.setDeathcertificate(file.getSubmittedFileName());
		dao.applicationClaim(c);
		
		//set an upload path of file
		String uploadPath = "C:/Users/Admin/git/FINAL2_KHAIRAT_PROJECT/AbidISP551Project/src/main/webapp/deathcertificateimg" + file.getSubmittedFileName();
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
		
		JOptionPane.showMessageDialog(null,"Application form submited");
		request.setAttribute("m", DaoMember.getMemberById((int)session.getAttribute("currentSessionUser")));
		RequestDispatcher view = request.getRequestDispatcher("homemember.jsp");
		view.forward(request, response);
	}

}
