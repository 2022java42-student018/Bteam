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

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDname() {
	return dName;
}

public void getDname(String dName) {
	this.dName = dName;
}

}
