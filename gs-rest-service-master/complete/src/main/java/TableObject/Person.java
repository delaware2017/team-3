package TableObject;

public class Person {

	private String name;
	private double balance;
	public String userName;
	private String password;
	public int famSize;
	private String program;

	public Person(String name, double balance, String userName, String password, int famSize, String program) {
		this.name = name;
		this.balance = balance;
		this.userName = userName;
		this.password = password;
		this.famSize = famSize;
		this.program = program;
	}

	public String getName() {
		return name;
	}
	public String getUserName(){
		return userName;
	}
	public void changePassword(String str) {
		this.password = str;
	}
	public double getBalance(){
		return balance;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
	public String getProgram(){
		return program;
	}
}