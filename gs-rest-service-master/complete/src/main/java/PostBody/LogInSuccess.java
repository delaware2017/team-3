package PostBody;

public class LogInSuccess {
	private String success;
	private String userName;
	public LogInSuccess(String success, String userName){
		this.success = success;
		this.userName = userName;
	}
	public String getSuccess(){
		return success;
	}
	public String getName(){
		return userName;
	}
	
}
