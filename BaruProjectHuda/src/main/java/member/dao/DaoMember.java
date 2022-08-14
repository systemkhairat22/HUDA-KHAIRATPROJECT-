package member.dao;

import java.sql.*;

import java.util.*;
import connectionDB.*;
import model.*;


public class DaoMember {
	static Connection con = null;
	static PreparedStatement ps = null;
	static java.sql.Statement st = null;
	static ResultSet rs = null;
	private static int memberid;
	private static String mem_password,mem_icnum;
	private int mem_age;
	private String mem_name, mem_address, mem_email, mem_phonenum, repname, repnum;
	
	//LOGIN MEMBER
	public static Member loginMember(Member m) {
		mem_icnum = m.getMem_icnum();
		//memberid = m.getMemberid();
		mem_password = m.getMem_password();
		
		try {
			//connect to db
			con = ConnectionManager.getConnection();
			//create statement
			ps=con.prepareStatement("SELECT * FROM member WHERE mem_icnum = ? AND mem_password = ?");
			ps.setString(1, mem_icnum);
			ps.setString(2, mem_password);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				m.setMemberid(rs.getInt("memberid"));
				m.setValid(true);
			}
			else {
				m.setValid(false);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

    //GET MEMBER BY ID
    public static Member getMemberById(int memberid) {
    	Member m = new Member();
    	try{
    		//call getConnection method
    		con = ConnectionManager.getConnection();
    		
    		//create statement
    		ps=con.prepareStatement ("SELECT * FROM member WHERE memberid =?");
    		ps.setInt(1, memberid);
    	
    		
    		//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				m.setMemberid(rs.getInt("memberid"));
				m.setMem_icnum(rs.getString("mem_icnum"));
				m.setMem_name(rs.getString("mem_name"));
				m.setMem_age(rs.getInt("mem_age"));
				m.setMem_email(rs.getString("mem_email"));
				m.setMem_address(rs.getString("mem_address"));
				m.setMem_password(rs.getString("mem_password"));
				m.setMem_phonenum(rs.getString("mem_phonenum"));
				m.setRepname(rs.getString("repname"));
				m.setRepnum(rs.getString("repnum"));

			}
			
			//close connection
			con.close();
			
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return m;
    }
    
    //CREATE NEW MEMBER 
    public void addMember(Member member) {
    	mem_name = member.getMem_name();
    	mem_icnum = member.getMem_icnum();
    	mem_age = member.getMem_age();
    	mem_address = member.getMem_address();
    	mem_email = member.getMem_email();
    	mem_phonenum = member.getMem_phonenum();
    	mem_password = mem_name.substring(0,2) + mem_icnum.substring(8,12);
    	repname = member.getRepname();
    	repnum = member.getRepnum();
    	
    	try{
    	//call getConnection() method
    		con = ConnectionManager.getConnection();
    		
    	//create statement
    		ps = con.prepareStatement("INSERT INTO member(mem_name,mem_icnum,mem_age,mem_address,mem_email,mem_phonenum,mem_password,repname,repnum) values(?,?,?,?,?,?,?,?,?)");
    		ps.setString(1, mem_name);
    		ps.setString(2,mem_icnum);
    		ps.setInt(3, mem_age);
    		ps.setString(4, mem_address);
    		ps.setString(5, mem_email);
    		ps.setString(6, mem_phonenum);
    		ps.setString(7, mem_password);
    		ps.setString(8, repname);
    		ps.setString(9, repnum);
    		
    		//execute query
    		ps.executeUpdate();
			System.out.println("Successfully inserted");
            
			//close connection
            con.close();
    	}
    	catch (Exception e) {
            e.printStackTrace();
        }
    }
   
  //GET ALL MEMBER
  	public static List<Member> getAllMember() {
  		List<Member> member= new ArrayList<Member>();
  		
  		try 
  		{
  			//call getConnection() method
  			con = ConnectionManager.getConnection();
  			
  			//create statement
  			st = con.createStatement();
  			String sql = "SELECT * FROM  member ORDER BY memberid";
  			
  			//execute query
  			rs = st.executeQuery(sql);
  			
  			while(rs.next()) {		//process result
  				Member m = new Member();
  				m.setMemberid(rs.getInt("memberid"));
				m.setMem_icnum(rs.getString("mem_icnum"));
				m.setMem_name(rs.getString("mem_name"));
				m.setMem_age(rs.getInt("mem_age"));
			    m.setMem_address(rs.getString("mem_address"));
			    m.setMem_phonenum(rs.getString("mem_phonenum"));
				m.setMem_email(rs.getString("mem_email"));
				m.setMem_password(rs.getString("mem_password"));
				m.setRepname(rs.getString("repname"));
				m.setRepnum(rs.getString("repnum"));
				System.out.println("data mana woi??");
  				member.add(m);
  			}
  			
  			//close connection
  			con.close();
  			
  			
  		} catch(Exception e) {
  			e.printStackTrace();
  		}
  		for(Member mem:member) {
  			System.out.println(mem.getMemberid());
  			System.out.println(mem.getMem_name());
  		}
  		return member;
  	}
   
  	//DELETE MEMBER
  	
  	public void deletemember (int id) {
  		try {
  			//call getConnection method
  			con = ConnectionManager.getConnection();
  			
  			//create statement
  			ps = con.prepareStatement("DELETE FROM member WHERE memberid=?");
  			ps.setInt(1, id);
  			
  			//execute query
  			ps.executeUpdate();
  			
  			//close connection
  			con.close();
  			
  		}catch (Exception e) {
  			e.printStackTrace();
  		}
  }
  	
  	//UPDATE MEMBER
  	
  	public void updatemember (Member member) {
  		memberid = member.getMemberid();
  		mem_age = member.getMem_age();
  		mem_address = member.getMem_address();
  		mem_email = member.getMem_email();
  		mem_phonenum = member.getMem_phonenum();
  		mem_password = member.getMem_password();
  		repname = member.getRepname();
  		repnum = member.getRepnum();
    	 
    	 try {
    		 //call getConnection method
    		 con = ConnectionManager.getConnection ();
    		 
    		 //create statement
    		 ps = con.prepareStatement("UPDATE member SET mem_age=?, mem_address=?, mem_email=?, mem_phonenum=?,repname=?, repnum=? WHERE memberid=?");
    		 ps.setInt(1, mem_age);
    		 ps.setString(2, mem_address);
    		 ps.setString(3, mem_email);
    		 ps.setString(4, mem_phonenum);
    		 ps.setString(5, repname);
    		 ps.setString(6, repnum);
    		 ps.setInt(7, memberid);
    		 
    		 //execute query
    		 ps.executeUpdate();

    		 System.out.println("Successfully updated");

    		 //close connection
    		 con.close();
     		
    	 }catch (Exception e) {
    		 e.printStackTrace();
    	 }
  	}
  	
  	//CHANGE MEMBER PASSWORD
  	public void ChangeMemberPassword(Member m,String new_pass) {
  		memberid = m.getMemberid();
  		try {
  			//connect to db
  			con = ConnectionManager.getConnection();
  			
  			//create statement
  			ps = con.prepareStatement("UPDATE member SET mem_password=? WHERE memberid=?");
  			ps.setString(1, new_pass);
  			ps.setInt(2, memberid);
  			
  			//execute query
  			ps.executeUpdate();
  			//close connection
  			con.close();
  		}catch(SQLException e) {
			e.printStackTrace();
		}
  	}


}
