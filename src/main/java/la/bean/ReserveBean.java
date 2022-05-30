package la.bean;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.annotation.WebServlet;

@WebServlet("/ReserveBean")
public class ReserveBean implements Serializable {
	private int dID;
	private String dName;
	private int cCode;
	private String aName;
	private String pName;
	private Date pDate;

	public ReserveBean(int dID,String dName, int cCode, String aName, String pName, Date pDate) {
		this.dName = dName;
		this.aName = aName;
		this.cCode = cCode;
		this.pName = pName;
		this.pDate = pDate;
	}

	public ReserveBean() {

	}

	public String getDname() {
		return dName;
	}

	public void getDname(String dName) {
		this.dName = dName;
	}

	public int getCcode() {
		return cCode;
	}

	public void setCcode(int cCode) {
		this.cCode = cCode;
	}

	public String getAname() {
		return aName;
	}

	public void setAname(String aName) {
		this.aName = aName;
	}

	public String getPname() {
		return pName;
	}

	public void setPname(String pName) {
		this.pName = pName;
	}

	public Date getPdate() {
		return pDate;
	}

	public void setPdate(Date pDate) {
		this.pDate = pDate;
	}

}
