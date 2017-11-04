package TableObject;

import java.util.Date;

public class Purchase {
	private double amount;
	private Date date;
	private String name;
	Purchase(double amount, Date date, String name){
		this.amount = amount;
		this.date = date;
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
