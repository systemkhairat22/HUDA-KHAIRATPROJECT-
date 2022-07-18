package khairat.dao;

import java.io.FileInputStream;

import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.servlet.http.Part;

import connectionDB.*;
import khairat.model.*;
public class DaoKhairat {
	static Connection con = null;
	static PreparedStatement ps = null;
	static java.sql.Statement st = null;
	static ResultSet rs = null;
	
	private int paymentid,memberid;
	private double payment_amount;
	private String bankname,transactionid,payment_receipt;
	private Date payment_date;
	private String inputFile ;
	//CREATE CASH PAYMENT
	public void cashPayment(Payment p) {
		java.util.Date utilDate = p.getPayment_date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		paymentid = p.getPaymentid();
		payment_amount = p.getPayment_amount();
		memberid = p.getMemberid();
		
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO payment(payment_date,payment_amount,memberid) values(?,?,?,?)");
			ps.setDate(1, sqlDate);
			ps.setDouble(2, payment_amount);
			ps.setInt(3, memberid);
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//close connection
            con.close();
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	//CREATE ONLINE PAYMENT
	public void onlinePayment(Payment p) {
		java.util.Date utilDate = p.getPayment_date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		paymentid = p.getPaymentid();
		payment_amount = p.getPayment_amount();
		payment_receipt = p.getPayment_receipt();
		memberid = p.getMemberid();
		transactionid = p.getTransactionid();
		bankname = p.getBank_name();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("INSERT INTO online (payment_date,payment_amount,payment_receipt,memberid,transactionid,bank_name) values(?,?,?,?,?,?)");
			ps.setDate(1, sqlDate);
			ps.setDouble(2, payment_amount);
			ps.setString(3, payment_receipt);
			ps.setInt(4, memberid);
			ps.setString(5, transactionid);
			ps.setString(6, bankname);
			//execute query
			ps.executeUpdate();
			System.out.println("Successfully inserted");
			
			//close connection
            con.close();
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	//GET ALL ONLINE PAYMENT
	public static List<Payment> getAllPayment(){
		List<Payment> payment = new ArrayList<Payment>();
		
		try {
			//call connection
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT * FROM online";
			
			//execute query
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Payment p = new Payment();
				p.setPaymentid(rs.getInt("paymentid"));
				p.setPayment_date(rs.getDate("payment_date"));
				p.setPayment_amount(rs.getDouble("payment_amount"));
				p.setPayment_receipt(rs.getString("payment_receipt"));
				p.setMemberid(rs.getInt("memberid"));
				p.setTransactionid(rs.getString("transactionid"));
				p.setBank_name(rs.getString("bank_name"));
				System.out.println("data mana woi??");
				payment.add(p);
			}
			
			//close connection
			con.close();
		}catch(Exception e) {
  			e.printStackTrace();
  		}
		for(Payment pay:payment) {
			System.out.println(pay.getPaymentid());
			System.out.println(pay.getPayment_date());
		}
		return payment;
	}
	
	//GET ALL CASH PAYMENT
	public static List<Payment> getAllCashPayment(){
		List<Payment> payment = new ArrayList<Payment>();
		
		try {
			//call connection
			con = ConnectionManager.getConnection();
			
			//create statement
			st = con.createStatement();
			String sql = "SELECT * FROM payment";
			
			//execute query
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Payment p = new Payment();
				p.setPaymentid(rs.getInt("paymentid"));
				p.setPayment_date(rs.getDate("payment_date"));
				p.setPayment_amount(rs.getDouble("payment_amount"));
				p.setMemberid(rs.getInt("memberid"));
				System.out.println("data mana woi??");
				payment.add(p);
			}
			
			//close connection
			con.close();
		}catch(Exception e) {
  			e.printStackTrace();
  		}
		for(Payment pay:payment) {
			System.out.println(pay.getPaymentid());
			System.out.println(pay.getPayment_date());
		}
		return payment;
	}
	//DELETE ONLINE PAYMENT
	public void deletePayment(int id) {
		try {
			//call getConnection method
  			con = ConnectionManager.getConnection();
  			
  			//create statement
  			ps = con.prepareStatement("DELETE FROM online WHERE paymentid=?");
  			ps.setInt(1, id);
  			
  			//execute query
  			ps.executeUpdate();
  			
  			//close connection
  			con.close();
		}catch (Exception e) {
  			e.printStackTrace();
  		}
	}
	//DELETE CASH PAYMENT
	public void deleteCashPayment(int id) {
		try {
			//call getConnection method
  			con = ConnectionManager.getConnection();
  			
  			//create statement
  			ps = con.prepareStatement("DELETE FROM payment WHERE paymentid=?");
  			ps.setInt(1, id);
  			
  			//execute query
  			ps.executeUpdate();
  			
  			//close connection
  			con.close();
		}catch (Exception e) {
  			e.printStackTrace();
  		}
	}
	
	//VIEW RECEIPT PAYMENT
	public static Payment viewReceiptById(int paymentid) {
		Payment p = new Payment();
		try {
			//call getConnection method
    		con = ConnectionManager.getConnection();
    		
    		//create statement
    		ps=con.prepareStatement ("SELECT paymentid,payment_receipt FROM online WHERE paymentid =?");
    		ps.setInt(1, paymentid);
    		
    		//execute query
			rs = ps.executeQuery();
			
			if(rs.next()) {
				p.setPaymentid(rs.getInt("paymentid"));
				p.setPayment_receipt(rs.getString("payment_receipt"));
				System.out.println("Payment receipt :" + rs.getString("payment_receipt"));
			}
			
			//close connection
			con.close();
		}catch(Exception e) {
    		e.printStackTrace();
		}
		return p;
	}

}
