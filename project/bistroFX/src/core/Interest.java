package core;

public class Interest {
	private int interestNum;	//관심목록번호
	private String userId;		//회원아이디
	private int storeNum;		//상가업소번호
	private boolean isInterest;	//관심여부
	
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
