package la.bean;

public class OwnerBean {
	private int oID ;
	private String oName;
	private String oPassword;
	
	public OwnerBean(int oID,String oName,String password) {
		this.oID = oID;
		this.oName = oName;
		this.oPassword = password;
	}
	
	public OwnerBean() {
		
	}
	
	public int getoID() {
		return oID;
	}
	
	public void setoID(int oID) {
		this.oID = oID;
	}
	
	public String getoName() {
		return oName;
	}
	
	public void setoName(String oPassword) {
		this.oPassword = oPassword;
	}
	
	public String getoPasswoed() {
		return oPassword;
	}
	
	public void setoPassword(String oPassword) {
		this.oPassword = oPassword;
	}

}
