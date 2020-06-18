package core;

public class MyReview {

	private String storeName;
	private int reviewStar;
	private String reviewText;
	private String createDate;
	
	public MyReview() {}

	public MyReview(String storeName, int reviewStar, String reviewText, String createDate) {
		this.storeName = storeName;
		this.reviewStar = reviewStar;
		this.reviewText = reviewText;
		this.createDate = createDate;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
