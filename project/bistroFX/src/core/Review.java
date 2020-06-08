package core;

import java.time.LocalDateTime;

public class Review {

	private int reviewNum;		//리뷰번호
	private String userId;		//회원아이디
	private int storeNum;		//상가업소번호
	private String reviewText;	//리뷰내용
	private int reviewStar;		//별점
	private LocalDateTime createDate;	//리뷰작성일시
	private LocalDateTime updateDate;	//리뷰수정일시
	private LocalDateTime deleteDate;	//리뷰삭제일시
	
	public Review() {}

	public Review(int reviewNum, String userId, int storeNum, String reviewText, int reviewStar,
			LocalDateTime createDate, LocalDateTime updateDate, LocalDateTime deleteDate) {
		this.reviewNum = reviewNum;
		this.userId = userId;
		this.storeNum = storeNum;
		this.reviewText = reviewText;
		this.reviewStar = reviewStar;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
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

	public int getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
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

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public LocalDateTime getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(LocalDateTime deleteDate) {
		this.deleteDate = deleteDate;
	}
	
	
}
