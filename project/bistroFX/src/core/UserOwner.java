package core;

import java.time.LocalDateTime;

//업주

public class UserOwner {

	private String id;		//업주아이디
	private String pw;		//패스워드
	private String name;	//성명
	private LocalDateTime registerDate; 	//가입일자
	private int storeNum;	//상가업소번호_업주가 소유하는 상가업소의 번호를 말한다
	private String storeName;	//상가업소명_업주가 소유하는 상가업소의 이름을 말한다
	
	public UserOwner() {}

	public UserOwner(String id, String pw, String name, LocalDateTime registerDate, int storeNum, String storeName) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.registerDate = registerDate;
		this.storeNum = storeNum;
		this.storeName = storeName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	
}
