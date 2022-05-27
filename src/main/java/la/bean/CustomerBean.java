package la.bean;

import java.io.Serializable;
import java.util.Date;

public class CustomerBean implements Serializable{

	private int cID;
	private String cName;
	private String cAddress;
	private int cTell;
	private String cMail;
	private Date cBday;
	private Date cJdate;
	private Date cWdate;


public  CustomerBean(int cID, String cName,String cAddress,int cTell, String cMail, Date cBday , Date cJdate){
	

	this.cID = cID;
	this.cName = cName;
	this.cAddress = cAddress;
	this.cTell = cTell;
	this.cMail = cMail;
	this.cBday = cBday;
	this.cJdate =cJdate;
	this.cWdate = cWdate;
}

public int getcID() {
	return cID;
}
public int setcID() {
	return cID;
}
public String getcName() {
	return cName;
}
public String setcName() {
	return cName;
}
public String getcAddress() {
	return cAddress;
}
public String setcAddress() {
	return cAddress;
}
public int getcTell() {
	return cTell;
}
public int setcTell() {
	return cTell;
}

public String getcMail() {
	return cMail;
}
public String setcMail() {
	return cMail;
}
public Date getcBday() {
	return cBday;
}
public Date setcBday() {
	return cBday;
}
public Date getcJdate() {
	return cJdate;
}
public Date setcJdate() {
	return cJdate;
}
public Date getcWdate() {
	return cWdate;
}
public Date setcWdate() {
	return cWdate;
}

}
