package core;

//메뉴및가격
public class MenuPrice {

	private int menuPriceNum;
	private int storeNumber;
	private String menu1;
	private int price1;
	private String menu2;
	private int price2;
	private String menu3;
	private int price3;
	
	public MenuPrice() {}
	
	public MenuPrice(int menuPriceNum, int storeNumber, String menu1, int price1, String menu2, int price2,String menu3, int price3) 
	{
		this.menuPriceNum = menuPriceNum;
		this.storeNumber = storeNumber;
		this.menu1 = menu1;
		this.price1 = price1;
		this.menu2 = menu2;
		this.price2 = price2;
		this.menu3 = menu3;
		this.price3 = price3;
	}

	public MenuPrice(String menu1, int price1, String menu2, int price2,String menu3, int price3) 
	{
		this.menu1 = menu1;
		this.price1 = price1;
		this.menu2 = menu2;
		this.price2 = price2;
		this.menu3 = menu3;
		this.price3 = price3;
	}
	
	public int getMenuPriceNum() {
		return menuPriceNum;
	}

	public void setMenuPriceNum(int menuPriceNum) {
		this.menuPriceNum = menuPriceNum;
	}

	public int getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getMenu1() {
		return menu1;
	}

	public void setMenu1(String menu1) {
		this.menu1 = menu1;
	}

	public int getPrice1() {
		return price1;
	}

	public void setPrice1(int price1) {
		this.price1 = price1;
	}

	public String getMenu2() {
		return menu2;
	}

	public void setMenu2(String menu2) {
		this.menu2 = menu2;
	}

	public int getPrice2() {
		return price2;
	}

	public void setPrice2(int price2) {
		this.price2 = price2;
	}

	public String getMenu3() {
		return menu3;
	}

	public void setMenu3(String menu3) {
		this.menu3 = menu3;
	}

	public int getPrice3() {
		return price3;
	}

	public void setPrice3(int price3) {
		this.price3 = price3;
	}

}
