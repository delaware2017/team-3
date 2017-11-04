package TableObject;

import java.util.Date;

public class Purchase {
	private double amount;
	private Date date;
	private String userName;
	public Purchase(double amount, Date date, String userName){
		this.amount = amount;
		this.date = date;
		this.userName = userName;
	}
	public String getName(){
		return userName;
	}
}
