package application;

public class LoginInfo {
	//trueȸ�� false ����
	private boolean isLogin;
	private String id;
	private int type;	//type 0:�ʱⰪ / type 1:ȸ�� / type 2:����
	
	public LoginInfo() {isLogin=false; type=0;}	
	public LoginInfo(boolean isLogin,String id,int type)
	{
		this.isLogin= isLogin;
		this.id = id;
		this.type = type;
		
	}
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public boolean getIsLogin() {return isLogin;}
	public void setIsLogin(boolean isLogin) {this.isLogin = isLogin;}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
