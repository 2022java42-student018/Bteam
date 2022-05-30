package la.bean;

import java.io.Serializable;
import java.sql.Date;

public class lend_docBean implements Serializable {

	private int dID;
	private String dName;
	private String aName;
	private String pName;
	private Date pDate;
	private Date aDate;
	private Date renDate;
	private Date retDate;

	public lend_docBean(int dID, String dName, String aName, String pName, Date renDate, Date retDate) {
		this.dID = dID;
		this.dName = dName;
		this.aName = aName;
		this.pName = pName;
		this.renDate = renDate;
		this.retDate = retDate;
	}

	public lend_docBean() {

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

	public Date getaDate() {
		return aDate;
	}

//	public void setaDate(Date aDate) {
//		this.aDate=aDate;
//	}
	public Date getrenDate() {
		return renDate;
	}

	public Date setrenDate() {
		return renDate;
	}

	public Date getretDate() {
		return retDate;
	}

	public Date setretDate() {
		return retDate;

	}

}
