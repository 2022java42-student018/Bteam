package la.bean;

import java.io.Serializable;

import javax.servlet.annotation.WebServlet;

@WebServlet("/ReserveBean")
public class ReserveBean implements Serializable {
	private String cName;
	private int cID;
	private String dName;
    private int cCode;
    private String aName;
    private String pName;
    private int pDate;
public ReserveBean(String cName,int cID,String dName,int cCode,String aName,String pName,int pDate) {
	this.cName = cName;
	this.dName = dName;
	this.aName= aName;
	this.cID=cID;
	this.cCode=cCode;
	this.pName=pName;
	this.pDate=pDate;
}

public ReserveBean(String name,int cID) {
	this.cName = name;
	this.cID = cID;
}



public ReserveBean() {
	
}
public int getCId() {
	return cID;
}

public void setCId(int cID) {
	this.cID = cID;
}

public String getCname() {
	return cName;
}

public void setCname(String cName) {
	this.cName = cName;
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

public void setAname(String aName ) {
	this.aName = aName;
}
public String getPname() {
	return pName;
}

public void setPname(String pName) {
	this.pName =pName ;
}
public int getPdate() {
	return pDate;
}

public void setPdate(int pDate) {
	this. pDate=pDate ;
}
}
