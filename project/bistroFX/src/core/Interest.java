package core;

public class Interest {
	private int interestNum;	//���ɸ�Ϲ�ȣ
	private String userId;		//ȸ�����̵�
	private int storeNum;		//�󰡾��ҹ�ȣ
	private boolean isInterest;	//���ɿ���
	
	public Interest() {}

	public Interest(int interestNum, String userId, int storeNum, boolean isInterest) {
		super();
		this.interestNum = interestNum;
		this.userId = userId;
		this.storeNum = storeNum;
		this.isInterest = isInterest;
	}

	public int getInterestNum() {
		return interestNum;
	}

	public void setInterestNum(int interestNum) {
		this.interestNum = interestNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}

	public boolean isInterest() {
		return isInterest;
	}

	public void setInterest(boolean isInterest) {
		this.isInterest = isInterest;
	}
	
}
