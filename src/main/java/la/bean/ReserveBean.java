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
	private int rescID;

	public ReserveBean(int dID,String dName, int cCode, String aName, String pName, Date pDate, int rescID) {
		this.dID=dID;
		this.dName = dName;
		this.aName = aName;
		this.cCode = cCode;
		this.pName = pName;
		this.pDate = pDate;
		this.rescID = rescID;
	}

	public ReserveBean() {

	}

	public int getdID() {
		return dID;
	}

	public void setdID(int dID) {
		this.dID = dID;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public int getcCode() {
		return cCode;
	}

	public void setcCode(int cCode) {
		this.cCode = cCode;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}

	public int getRescID() {
		return rescID;
	}

	public void setRescID(int rescID) {
		this.rescID = rescID;
	}



}
