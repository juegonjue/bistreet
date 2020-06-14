package application;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class RandomController {
	
    @FXML
    private Label category;

    @FXML
    private ComboBox<String> comboBoxcat;

    @FXML
    private Label submenu;

    @FXML
    private Button btn_ok;

    @FXML
    private Button btn_back;


    int cate = MainController.CATEGORY;	//1:식사 2:디저트 3:주점
    ObservableList<String> subcat;
    String[] sub;
	public void initialize() {
		
		if (cate==1) {
			subcat = FXCollections.observableArrayList("한식","중식","일식","분식","양식","기타","뷔페");
		}
		
		else if (cate==2) {
			subcat = FXCollections.observableArrayList("군것질류","제과제빵떡케익","카페");

		}
		else if (cate==3) {
			subcat= FXCollections.observableArrayList("주점");
		}
		
		comboBoxcat.setItems(subcat);
		
		btn_ok.setOnMouseClicked(e->{
			
			if (cate==1) {
				if (comboBoxcat.getValue().equals("한식")) {
					sub = new String[]{"한식","갈비","삼겹살","곱창","양구이","한정식","해장국","돌솥비빔밥","부대찌개","족발","보쌈","설렁탕","쌈밥","두부요리","재첩국","파전","추어탕",
							"순두부","보리밥","버섯요리","황태","냉면","기사식당","갈매기살","해물찜","아구찜","민물장어","매운탕","조개구이","바닷가재","갈치","낙지","오징어","곰장어","고등어","굴","게장","홍어","복어",
							"삼계탕","닭갈비","닭도리탕","찜닭","불닭","옻닭","토종닭","치킨","오리고기","닭발","죽","퓨전요리","순대"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else if (comboBoxcat.getValue().equals("중식")) {
					sub = new String[] {"짜장면","탕수육","짬뽕","깐풍기","야끼우동","간짜장","깐쇼새우","볶음밥","마라탕"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else if (comboBoxcat.getValue().equals("일식")) {
					sub = new String[] {"회","참치","초밥","샤브샤브","철판요리"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}		
				else if (comboBoxcat.getValue().equals("분식")) {
					sub =  new String[] {"라면","김밥","국수","만두","칼국수","떡볶이","우동"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}	
				else if (comboBoxcat.getValue().equals("양식")) {
					sub = new String[] {"돈까스","카레","스파게티","패밀리레스토랑","바베큐","스테이크","피자","도시락"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else if (comboBoxcat.getValue().equals("기타")) {
					sub = new String[] {"쌀국수","사철탕"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else {
					sub = new String[] {"종합부페","고기부페","한식부페","채식부페","해물부페"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
			}
			
			else if (cate==2) {
				if (comboBoxcat.getValue().equals("군것질류")) {
					sub = new String[] {"핫도그","도너츠","아이스크림","유산균아이스크림","생과자","토스트"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else if (comboBoxcat.getValue().equals("제과제빵떡케익")) {
					sub = new String[] {"빵","케이크","떡","한과","찐빵"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else {
					sub = new String[] {"커피","생과일주스","보드게임카페","사주카페","전통찻집","애견카페"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
			}
			
			else {
				sub = new String[] {"호프집", "포장마차", "꼬치구이","민속주점","로바다야끼","bar","락카페","감성주점"};
				int which = (int) (Math.random()*(sub.length));
				submenu.setText(sub[which]);
			}
		});
		
    	if (MainController.CATEGORY==1) category.setText("식사");
    	else if (MainController.CATEGORY==2) category.setText("디저트");
    	else category.setText("주점");
		
		btn_back.setOnMouseClicked(e->App.go("category.fxml"));
	  	btn_ok.setOnAction(e->handlebtncat(e));
		
	  	
	  	
	}
		
	
	public void  handlebtncat(ActionEvent event) 
	{
		System.out.println(comboBoxcat.getValue());
		
	}
	
}
