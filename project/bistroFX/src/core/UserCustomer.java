package core;

import java.time.LocalDateTime;

//È¸¿ø

public class UserCustomer {					
	private String id;
	private String pw;
	private String name;
	private LocalDateTime registerDate;
	
	public UserCustomer() {}

	public UserCustomer(String id, String pw, String name, LocalDateTime registerDate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.registerDate = registerDate;
	}

	public UserCustomer(String id, String pw) {
		this.id = id;
		this.pw = pw;
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
	
	
}
