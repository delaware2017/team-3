package PostBody;

public class PostLogIn {
	private String id;
	private String password;
	public PostLogIn(String id, String password){
		this.id = id;
		this.password = password;
	}
	public String getId(){
		return id;
	}
	public String getPassword(){
		return password;
	}
}
