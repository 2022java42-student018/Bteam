package la.bean;

import java.io.Serializable;
import java.util.Date;

public class CustomerBean implements Serializable{

	private int cID;
	private String cName;
	private String cAddress;
	private String cTell;
	private String cMail;
	private Date cBday;
	private Date cJdate;
	private Date cWdate;


public  CustomerBean(int cID, String cName,String cAddress,String cTell, String cMail, Date cBday , Date cJdate,Date cWdate){
	

	this.cID = cID;
	this.cName = cName;
	this.cAddress = cAddress;
	this.cTell = cTell;
	this.cMail = cMail;
	this.cBday = cBday;
	this.cJdate =cJdate;
	this.cWdate = cWdate;
}

public CustomerBean() {
	
}

public CustomerBean(String cName, String cAddress, String cTell, String cMail, Date cBday) {
	
	this.cName = cName;
	this.cAddress = cAddress;
	this.cTell = cTell;
	this.cMail = cMail;
	this.cBday = cBday;
	
}

public int getcID() {
	return cID;
}
public void setcID(int cID) {
	this.cID= cID;
}
public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName= cName;
}
public String getcAddress() {
	return cAddress;
}
public void setcAddress(String cAddress) {
	this.cAddress=cAddress;
}
public String getcTell() {
	return cTell;
}
public void setcTell(String cTell) {
	this.cTell=cTell;
}

public String getcMail() {
	return cMail;
}
public void setcMail(String cMail) {
	this.cMail=cMail;
}
public Date getcBday() {
	return cBday;
}
public void setcBday(Date cBday) {
	this.cBday=cBday;
}
public Date getcJdate() {
	return cJdate;
}
public void setcJdate(Date cJdate) {
	this.cJdate=cJdate;
}
public Date getcWdate() {
	return cWdate;
}
public void setcWdate(Date cWdate) {
	this.cWdate=cWdate;
}

}
