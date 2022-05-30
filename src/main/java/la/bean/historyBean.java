package la.bean;
import java.io.Serializable;

public class historyBean implements Serializable{
	
private int cID1;
private String dName;
private int renCID;
private int retCID;


public historyBean(int cID1, String dName, int renCID, int retCID) {
	this.cID1 = cID1;
	this.dName=dName;
	this.renCID=renCID;
	this.retCID=retCID;
}

public int getcID1() {
	return cID1;
}
public int setcID1() {
	return cID1;
}

public String getdName() {
	return dName;
	
}

public String setName() {
	return dName;
}

public int getrenCID() {
	return renCID;
}

public int setrenCID() {
	return renCID;	
}

public int getretCID() {
	return retCID;
}

public int setretCID() {
	return retCID;
	
}

}

