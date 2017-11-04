package TableObject;

public class Person {

	private int id;
	private String name;
	public double balance;
	public String username;
	private String password;
	public int famSize;

	public Person(int id, String name, int balance, String u, String pass, int fam) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.username = u;
		this.password = pass;
		this.famSize = fam;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void changePassword(String str) {
		this.password = str;
	}

}