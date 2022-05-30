package la.bean;
import java.io.Serializable;
import java.util.Date;

public class historyBean implements Serializable{
	
private int cID1;
private String dName;
private Date renDate;
private Date retDate;


public historyBean(int cID1, String dName, Date renDate, Date retDate) {
	this.cID1 = cID1;
	this.dName=dName;
	this.renDate=renDate;
	this.retDate=retDate;
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

public Date getrenDate() {
	return renDate;
}

public Date setrenDate() {
	return renDate;	
}

public Date getretCID() {
	return retDate;
}

public Date setretDate() {
	return retDate;
	
}

}

