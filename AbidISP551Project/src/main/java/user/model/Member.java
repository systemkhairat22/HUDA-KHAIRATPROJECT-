package user.model;

public class Member {
	private int memberid;
	private String mem_icnum;
	private String mem_name;
	private int mem_age;
	private String mem_address;
	private String mem_email;
	private String mem_phonenum;
	private String mem_password;
	private String repname;
	private String repnum;
	private boolean valid;
	
	public Member(int memberid, String mem_icnum, String mem_name, int mem_age, String mem_address, String mem_email,
			String mem_phonenum, String mem_password, String repname, String repnum,boolean valid) {
		super();
		this.memberid = memberid;
		this.mem_icnum = mem_icnum;
		this.mem_name = mem_name;
		this.mem_age = mem_age;
		this.mem_address = mem_address;
		this.mem_email = mem_email;
		this.mem_phonenum = mem_phonenum;
		this.mem_password = mem_password;
		this.repname = repname;
		this.repnum = repnum;
		this.setValid(valid);
	}

	public Member(String mem_icnum, String mem_name, int mem_age, String mem_address, String mem_email,
			String mem_phonenum, String mem_password, String repname, String repnum) {
		super();
		this.mem_icnum = mem_icnum;
		this.mem_name = mem_name;
		this.mem_age = mem_age;
		this.mem_address = mem_address;
		this.mem_email = mem_email;
		this.mem_phonenum = mem_phonenum;
		this.mem_password = mem_password;
		this.repname = repname;
		this.repnum = repnum;
	}

	public Member() {
		
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getMem_icnum() {
		return mem_icnum;
	}

	public void setMem_icnum(String mem_icnum) {
		this.mem_icnum = mem_icnum;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public int getMem_age() {
		return mem_age;
	}

	public void setMem_age(int mem_age) {
		this.mem_age = mem_age;
	}

	public String getMem_address() {
		return mem_address;
	}

	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_phonenum() {
		return mem_phonenum;
	}

	public void setMem_phonenum(String mem_phonenum) {
		this.mem_phonenum = mem_phonenum;
	}

	public String getMem_password() {
		return mem_password;
	}

	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}

	public String getRepname() {
		return repname;
	}

	public void setRepname(String repname) {
		this.repname = repname;
	}

	public String getRepnum() {
		return repnum;
	}

	public void setRepnum(String repnum) {
		this.repnum = repnum;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
