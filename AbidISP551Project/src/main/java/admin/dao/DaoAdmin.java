package admin.dao;

import java.sql.*;
import java.util.*;
import user.model.*;
import connectionDB.*;
public class DaoAdmin {
	static Connection con = null;
	static PreparedStatement ps = null;
	static java.sql.Statement st = null;
	static ResultSet rs = null;
	static int adminid;
	static String add_password,admin_icnum;
	private int add_age, supervisorid;
	private String add_name, add_email, add_phonenum;
	
	//LOGIN ADMIN
	public static Admin loginAdmin(Admin a) {
		admin_icnum = a.getAdmin_icnum();
		add_password = a.getAdd_password();
		
		try {
			//connect to db
			con = ConnectionManager.getConnection();
			//create statement
			ps=con.prepareStatement("SELECT * FROM admin WHERE admin_icnum = ? AND add_password = ?");
			ps.setString(1, admin_icnum );
			ps.setString(2, add_password);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				a.setAdminid(rs.getInt("adminid"));
				a.setValid(true);
			}
			else {
				a.setValid(false);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	//LOGIN SUPERVISOR
	public static Admin loginSupervisor(Admin a) {
		admin_icnum = a.getAdmin_icnum();
		add_password = a.getAdd_password();
		
		try {
			//connect to db
			con = ConnectionManager.getConnection();
			//create statement
			ps=con.prepareStatement("SELECT * FROM admin WHERE admin_icnum = ? AND add_password = ? AND supervisorid = 0");
			ps.setString(1, admin_icnum );
			ps.setString(2, add_password);
			
			//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				a.setAdminid(rs.getInt("adminid"));
				a.setValid(true);
			}
			else {
				a.setValid(false);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
    //GET ADMIN BY ID
    public static Admin getAdminById(int adminid) {
    	Admin a = new Admin();
    	try{
    		//call getConnection method
    		con = ConnectionManager.getConnection();
    		
    		//create statement
    		ps=con.prepareStatement ("SELECT * FROM admin WHERE adminid =?");
    		ps.setInt(1, adminid);
    	
    		
    		//execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				a.setAdminid(rs.getInt("adminid"));
				a.setAdmin_icnum(rs.getString("admin_icnum"));
				a.setAdd_name(rs.getString("add_name"));
				a.setAdd_age(rs.getInt("add_age"));
				a.setAdd_email(rs.getString("add_email"));
				a.setAdd_password(rs.getString("add_password"));
				a.setAdd_phonenum(rs.getString("add_phonenum"));
				a.setSupervisorid(rs.getInt("supervisorid"));
				
			}
			
			//close connection
			con.close();
			
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return a;
    }
    
    //CREATE NEW admin
    public void addAdmin(Admin admin) {
    	add_name = admin.getAdd_name();
    	admin_icnum = admin.getAdmin_icnum();
    	add_age = admin.getAdd_age();
    	add_email = admin.getAdd_email();
    	add_phonenum = admin.getAdd_phonenum();
    	add_password = add_name.substring(0,2) + admin_icnum.substring(8,12);
    	supervisorid = admin.getSupervisorid();
        
    	try {
    		//call getConnection() method
    		con = ConnectionManager.getConnection();
    		
    		//create statement
    		ps = con.prepareStatement("INSERT INTO admin(add_name,admin_icnum,add_age,add_email,add_phonenum,add_password,supervisorid) values(?,?,?,?,?,?,?)");
    		ps.setString(1, add_name);
    		ps.setString(2,admin_icnum);
    		ps.setInt(3, add_age);
    		ps.setString(4, add_email);
    		ps.setString(5, add_phonenum);
    		ps.setString(6, add_password);
    		ps.setInt(7, supervisorid);
    		
    		//execute query
    		ps.executeUpdate();
			System.out.println("Successfully inserted");
            
			//close connection
            con.close();
    	}catch (Exception e) {
            e.printStackTrace();
        }
    }

    //GET ALL ADMIN
  	public static List<Admin> getAllAdmin(int supervisorid) {
  		List<Admin> admin= new ArrayList<Admin>();
  		
  		try {
  			//call getConnection() method
  			con = ConnectionManager.getConnection();
  			
  			//create statement
  			ps=con.prepareStatement("SELECT * FROM  admin WHERE supervisorid = ? ORDER BY adminid");
  			ps.setInt(1, supervisorid);
  			//execute query
  			rs = ps.executeQuery();
  			
  			while(rs.next()) {		//process result
  				Admin a = new Admin();
  				a.setAdminid(rs.getInt("adminid"));
				a.setAdmin_icnum(rs.getString("admin_icnum"));
				a.setAdd_name(rs.getString("add_name"));
				a.setAdd_age(rs.getInt("add_age"));
			    a.setAdd_phonenum(rs.getString("add_phonenum"));
				a.setAdd_email(rs.getString("add_email"));
				a.setAdd_password(rs.getString("add_password"));
				a.setSupervisorid(supervisorid);
  				admin.add(a);
  			}
  			
  			//close connection
  			con.close();
  			
  			
  		} catch(Exception e) {
  			e.printStackTrace();
  		}
  		
  		return admin;
  	}
  	
  	//GET ALL ADMIN CONTACT
  	public static List<Admin> getAllAdminContact() {
  		List<Admin> admin= new ArrayList<Admin>();
  		
  		try {
  			//call getConnection() method
  			con = ConnectionManager.getConnection();
  			
  			//create statement
  			ps=con.prepareStatement("SELECT add_name,add_phonenum FROM  admin ORDER BY adminid");
  		
  			//execute query
  			rs = ps.executeQuery();
  			
  			while(rs.next()) {		//process result
  				Admin a = new Admin();
				a.setAdd_name(rs.getString("add_name"));
			    a.setAdd_phonenum(rs.getString("add_phonenum"));
  				admin.add(a);
  			}
  			
  			//close connection
  			con.close();
  			
  			
  		} catch(Exception e) {
  			e.printStackTrace();
  		}
  		
  		return admin;
  	}


	//DELETE ADMIN
	public void deleteadmin (int id) {
		try {
			//call getConnection method
			con = ConnectionManager.getConnection();
			
			//create statement
			ps = con.prepareStatement("DELETE FROM admin WHERE adminid=?");
			ps.setInt(1, id);
			
			//execute query
			ps.executeUpdate();
			
			//close connection
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
  	//UPDATE ADMIN
  	public void updateadmin (Admin admin) {
  		adminid = admin.getAdminid();
    	add_age = admin.getAdd_age();
    	add_email = admin.getAdd_email();
        add_phonenum = admin.getAdd_phonenum();
    	
    	 try {
    		 //call getConnection method
    		 con = ConnectionManager.getConnection ();
    		 
    		 //create statement
    		ps = con.prepareStatement("UPDATE admin SET add_age=?, add_email=?, add_phonenum=? WHERE adminid=?");
     		ps.setInt(1, add_age);
     		ps.setString(2, add_email);
     		ps.setString(3, add_phonenum);
     		ps.setInt(4, adminid);
    		 
     		//execute query
     		ps.executeUpdate();
     		
     		System.out.println("Successfully updated");
     		
     		//close connection
     		con.close();
     		
    	 }catch (Exception e) {
    		 e.printStackTrace();
    	 }
  	}
  	//CHANGE ADMIN PASSWORD
  	public void ChangeAdminPassword(Admin a, String new_pass) {
  		adminid = a.getAdminid();
  		try {
  			//connect to db
  			con = ConnectionManager.getConnection();
  			
  			//create statement
  			ps = con.prepareStatement("UPDATE admin SET add_password=? WHERE adminid=?");
  			ps.setString(1, new_pass);
  			ps.setInt(2, adminid);
  			
  			//execute query
  			ps.executeUpdate();
  			//close connection
  			con.close();
  			
  		}catch(SQLException e) {
			e.printStackTrace();
		}
  	}
}
