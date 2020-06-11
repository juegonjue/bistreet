package core;

import java.text.DecimalFormat;

public class Store {

	private Integer storeNumber;		//�󰡾��ҹ�ȣ
	private String storeName;		//��ȣ��
	private String storeLocation;	//������			
	private String codeMedium;		//��Ǿ����ߺз��ڵ�
	private String codeSmall;		//��Ǿ����Һз��ڵ�
	private String storeAddress;	//���θ��ּ�
	private Double kDegree;			//�浵
	private Double wDegree;			//����

	public Store() {}
	public Store(Integer storeNumber, String storeName, String storeLocation, String codeMedium, String codeSmall, String storeAddress, double kDegree, double wDegree)
	{
		this.storeNumber = storeNumber;
		this.storeName = storeName;
		this.storeLocation = storeLocation;
		this.codeMedium = codeMedium;
		this.codeSmall = codeSmall;
		this.storeAddress = storeAddress;
		this.kDegree =  kDegree;
		this.wDegree = wDegree;
	}
	public Store(String storeName,double kDegree,double wDegree,double distance,String storeAddress)
	{
		this.storeName= storeName;
		this.kDegree=kDegree;
		this.wDegree=wDegree;
		this.storeNumber = storeNumber;
		
		double d = distance;
		d = Double.parseDouble(String.format("%.2f", d));

		this.storeAddress =  Double.toString(d);
		
		
		//this.dst=Double.toString(distance);
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
