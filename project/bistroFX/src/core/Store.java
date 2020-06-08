package core;

public class Store {

	private Integer storeNumber;		//상가업소번호
	private String storeName;		//상호명
	private String storeLocation;	//지점명			
	private String codeMedium;		//상권업종중분류코드
	private String codeSmall;		//상권업종소분류코드
	private String storeAddress;	//도로명주소
	private double kDegree;			//경도
	private double wDegree;			//위도
	
	public Store() {}
	public Store(Integer storeNumber, String storeName, String storeLocation, String codeMedium, String codeSmall, String storeAddress, double kDegree, double wDegree)
	{
		this.storeNumber = storeNumber;
		this.storeName = storeName;
		this.storeLocation = storeLocation;
		this.codeMedium = codeMedium;
		this.codeSmall = codeSmall;
		this.storeAddress = storeAddress;
		this.kDegree = kDegree;
		this.wDegree = wDegree;
	}
	public Store(String storeName,double kDegree,double wDegree)
	{
		this.storeName= storeName;
		this.kDegree=kDegree;
		this.wDegree=wDegree;
	}
	public Integer getStoreNumber() {return storeNumber;}
	public void setStoreNumber(Integer storeNumber) {this.storeNumber = storeNumber;}
	public String getStoreName() {return storeName;}
	public void setStoreName(String storeName) {this.storeName = storeName;}
	public String getStoreLocation() {return storeLocation;}
	public void setStoreLocation(String storeLocation) {this.storeLocation = storeLocation;}
	public String getCodeMedium() {return codeMedium;}
	public void setCodeMedium(String codeMedium) {this.codeMedium = codeMedium;}
	public String getCodeSmall() {return codeSmall;}
	public void setCodeSmall(String codeSmall) {this.codeSmall = codeSmall;}
	public String getStoreAddress() {return storeAddress;}
	public void setStoreAddress(String storeAddress) {this.storeAddress = storeAddress;}
	public double getkDegree() {return kDegree;}
	public void setkDegree(double kDegree) {this.kDegree = kDegree;}
	public double getwDegree() {return wDegree;}
	public void setwDegree(double wDegree) {this.wDegree = wDegree;}

}
