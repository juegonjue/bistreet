package core;

public class Review {

	private int reviewNum;		//리뷰번호
	private String userId;		//회원아이디
	private int storeNumber;	//상가업소번호
	private String reviewText;	//리뷰내용
	private int reviewStar;		//별점
	private String createDate;	//리뷰작성일시
	private String updateDate;	//리뷰수정일시
	private String deleteDate;	//리뷰삭제일시
	
	public Review() {}

	public Review(int reviewNum, String userId, int storeNumber, String reviewText, int reviewStar,
			String createDate, String updateDate, String deleteDate) {
		this.reviewNum = reviewNum;
		this.userId = userId;
		this.storeNumber = storeNumber;
		this.reviewText = reviewText;
		this.reviewStar = reviewStar;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
	}
	
	public Review(String userId, int reviewStar, String reviewText, String createDate) {
		this.userId = userId;
		this.reviewStar = reviewStar;
		this.reviewText = reviewText;
		this.createDate = createDate;
	}

	public Review(String userId, int reviewStar, String reviewText)
	{
		this.userId = userId;
		this.reviewStar = reviewStar;
		this.reviewText = reviewText;
	}
	
	public Review(int storeNumber, int reviewStar, String reviewText) {
		this.storeNumber = storeNumber;
		this.reviewStar = reviewStar;
		this.reviewText = reviewText;
	}
	
	public Review(int storeNumber, int reviewStar, String reviewText, String createDate) {
		this.storeNumber = storeNumber;
		this.reviewStar = reviewStar;
		this.reviewText = reviewText;
		this.createDate = createDate;
	}
	
	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public int getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	
	
}
