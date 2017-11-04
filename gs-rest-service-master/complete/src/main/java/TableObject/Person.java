package TableObject;

public class Person {

	private String name;
	private double balance;
	public String userName;
	private String password;
	public int famSize;
	private String program;

	public Person(String name, int balance, String userName, String password, int famSize) {
		this.name = name;
		this.balance = balance;
		this.userName = userName;
		this.password = password;
		this.famSize = famSize;
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
	public String getProgram(){
		return program;
	}
}