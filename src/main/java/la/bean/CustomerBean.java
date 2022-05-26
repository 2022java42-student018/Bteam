package la.bean;

import java.io.Serializable;

public class CustomerBean implements Serializable{

	private int cID;
	private String cName;
	private int cAddress;
	private int cTell;
	private String cMail;
	private int cBday;
	private int cJdate;
	private int cWdate;


public  CustomerBean(int cID, String cName,int cAddress,int cTell,String cMail, int cBday,int cJdate, int cWdate){
	

	this.cID = cID;
	this.cName = cName;
	this.cAddress = cAddress;
	this.cTell = cTell;
	this.cMail = cMail;
	this.cBday = cBday;
	this.cWdate = cWdate;
}
}