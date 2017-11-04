package TableObject;

public class Retailer {
	private String name;
	private String address;
	private String program;
	public Retailer(String name, String address, String program){
		this.name = name;
		this.address = address;
		this.program = program;
	}
	public String getName(){
		return name;
	}
}
