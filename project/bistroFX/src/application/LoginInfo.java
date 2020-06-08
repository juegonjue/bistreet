package application;

public class LoginInfo {

	boolean isLogin;
	String id;
	
	public LoginInfo(boolean _isLogin,String _id)
	{
		this.isLogin=_isLogin;
		this.id =_id;
	}
	
	public String getId() {return id;}
	public boolean geeIsLogin() {return isLogin;}
	
}
