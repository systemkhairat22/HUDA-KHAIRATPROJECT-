package khairat.model;

public class Claimkhairat {
	private int applicationid;
	private String appclaim_status;
	private int memberid;
	private int adminid;
	private String deathcertificate;
	
	public Claimkhairat(){
		
	}
	public int getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(int applicationid) {
		this.applicationid = applicationid;
	}
	public String getAppclaim_status() {
		return appclaim_status;
	}
	public void setAppclaim_status(String appclaim_status) {
		this.appclaim_status = appclaim_status;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getDeathcertificate() {
		return deathcertificate;
	}
	public void setDeathcertificate(String deathcertificate) {
		this.deathcertificate = deathcertificate;
	}
}
