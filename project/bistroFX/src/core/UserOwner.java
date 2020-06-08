package core;

import java.time.LocalDateTime;

//����

public class UserOwner {

	private String id;		//���־��̵�
	private String pw;		//�н�����
	private String name;	//����
	private LocalDateTime registerDate; 	//��������
	private int storeNum;	//�󰡾��ҹ�ȣ_���ְ� �����ϴ� �󰡾����� ��ȣ�� ���Ѵ�
	private String storeName;	//�󰡾��Ҹ�_���ְ� �����ϴ� �󰡾����� �̸��� ���Ѵ�
	
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
