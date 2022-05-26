package la.bean;
import java.io.Serializable;

public class DocumentBean implements Serializable{
	
private int dID;
private String dName;
private String aName;
private String pName;
private String renCID;


public DocumentBean(int dID, String dName, String aName, String pName, String renCID) {
	this.dID = dID;
	this.dName=dName;
	this.aName=aName;
	this.pName=pName;
	this.renCID=renCID;
}

public DocumentBean(int dID) {
	this.dID=dID;
}


public DocumentBean() {
	
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
	this.pName = pName;
}



public String getrenCID() {
	return renCID;
}

public void setrenCID(String renCID) {
	this.renCID = renCID;
}
}
