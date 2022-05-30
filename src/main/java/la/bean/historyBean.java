package la.bean;

import java.io.Serializable;
import java.util.Date;

public class historyBean implements Serializable {

	private int cID;
	private String dName;
	private Date renDate;
	private Date retDate;

	public historyBean(int cID, String dName, Date renDate, Date retDate) {
		this.cID = cID;
		this.dName = dName;
		this.renDate = renDate;
		this.retDate = retDate;
	}

	public int getcID() {
		return cID;
	}

	public int setcID() {
		return cID;
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
