package la.bean;

import java.io.Serializable;
import java.sql.Date;


public class lend_docBean implements Serializable {

	private int dID;
//	private int isbn;
//	private int cCode;
	private String dName;
	private String aName;
	private String pName;
	private Date pDate;
	private Date aDate;
	private Date renDate;
	private Date retDate;
	private String renCID;
	private String resCID;
	
	public lend_docBean(int dID, String dName, String aName, String pName,Date renDate, Date retDate) {
		this.dID=dID;
//		this.isbn=isbn;
//		this.cCode=cCode;
		this.dName=dName;
		this.aName=aName;
		this.pName=pName;
//		this.pDate=pDate;
//		this.aDate=aDate;
		this.renDate=renDate;
		this.retDate=retDate;
//		this.renCID=renCID;
//		this.resCID=resCID;
	}
	
//	public lend_docBean(int dID, int isbn, int cCode, String dName, String aName, String pName, Date pDate) {
//		this.dID=dID;
//		this.isbn=isbn;
//		this.cCode=cCode;
//		this.dName=dName;
//		this.aName=aName;
//		this.pName=pName;
//		this.pDate=pDate;
//	}
//	
//	public lend_docBean(int dID, int isbn, int cCode, String dName, String aName, String pName, Date pDate,Date aDate) {
//		this.dID=dID;
//		this.isbn=isbn;
//		this.cCode=cCode;
//		this.dName=dName;
//		this.aName=aName;
//		this.pName=pName;
//		this.pDate=pDate;
//		this.aDate=aDate;
//	}
	
	
	public lend_docBean() {
		
	}
	
	public int getdID() {
		return dID;
	}
	
	public void setdID(int dID) {
		this.dID=dID;
	}
	
//	public int getisbn() {
//		return isbn;
//	}
//	
//	public void setisbn(int isbn) {
//		this.isbn=isbn;
//	}
//	
//	public int getcCode() {
//		return cCode;
//	}
//	
//	public void setcCode(int cCode) {
//		this.cCode=cCode;
//	}
	
	public String getdName() {
		return dName;
	}
	
	public void setdName(String dName) {
		this.dName=dName;
	}
	
	public String getaName() {
		return aName;
	}
	
	public void setaName(String aName) {
		this.aName=aName;
	}
	
	public String getpName() {
		return pName;
	}
	
	public void setpName(String pName) {
		this.pName=pName;
	}
	
	public Date getpDate() {
		return pDate;
	}
	
	public void setpDate(Date pDate) {
		this.pDate=pDate;
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
	
	public String getrenCID() {
		return renCID;
	}
	
	public void setrenCID(String renCID) {
		this.renCID=renCID;
	}
	
	public String getresCID() {
		return resCID;
	}
	
	public void setresCID(String resCID) {
		this.resCID=resCID;
		
	}
	
	
}