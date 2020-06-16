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


    int cate = MainController.CATEGORY;	//1:½Ä»ç 2:µðÀúÆ® 3:ÁÖÁ¡
    ObservableList<String> subcat;
    String[] sub;
	public void initialize() {
		
		if (cate==1) {
			subcat = FXCollections.observableArrayList("ÇÑ½Ä","Áß½Ä","ÀÏ½Ä","ºÐ½Ä","¾ç½Ä","±âÅ¸","ºßÆä");
		}
		
		else if (cate==2) {
			subcat = FXCollections.observableArrayList("±º°ÍÁú·ù","Á¦°úÁ¦»§¶±ÄÉÀÍ","Ä«Æä");

		}
		else if (cate==3) {
			subcat= FXCollections.observableArrayList("ÁÖÁ¡");
		}
		
		comboBoxcat.setItems(subcat);
		
		btn_ok.setOnMouseClicked(e->{
			
			if (cate==1) {
				if (comboBoxcat.getValue().equals("ÇÑ½Ä")) {
					sub = new String[]{"ÇÑ½Ä","°¥ºñ","»ï°ã»ì","°öÃ¢","¾ç±¸ÀÌ","ÇÑÁ¤½Ä","ÇØÀå±¹","µ¹¼Üºñºö¹ä","ºÎ´ëÂî°³","Á·¹ß","º¸½Ó","¼³··ÅÁ","½Ó¹ä","µÎºÎ¿ä¸®","ÀçÃ¸±¹","ÆÄÀü","Ãß¾îÅÁ",
							"¼øµÎºÎ","º¸¸®¹ä","¹ö¼¸¿ä¸®","È²ÅÂ","³Ã¸é","±â»ç½Ä´ç","°¥¸Å±â»ì","ÇØ¹°Âò","¾Æ±¸Âò","¹Î¹°Àå¾î","¸Å¿îÅÁ","Á¶°³±¸ÀÌ","¹Ù´å°¡Àç","°¥Ä¡","³«Áö","¿ÀÂ¡¾î","°õÀå¾î","°íµî¾î","±¼","°ÔÀå","È«¾î","º¹¾î",
							"»ï°èÅÁ","´ß°¥ºñ","´ßµµ¸®ÅÁ","Âò´ß","ºÒ´ß","¿Ì´ß","ÅäÁ¾´ß","Ä¡Å²","¿À¸®°í±â","´ß¹ß","Á×","Ç»Àü¿ä¸®","¼ø´ë"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else if (comboBoxcat.getValue().equals("Áß½Ä")) {
					sub = new String[] {"Â¥Àå¸é","ÅÁ¼öÀ°","Â«»Í","±ñÇ³±â","¾ß³¢¿ìµ¿","°£Â¥Àå","±ñ¼î»õ¿ì","ººÀ½¹ä","¸¶¶óÅÁ"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else if (comboBoxcat.getValue().equals("ÀÏ½Ä")) {
					sub = new String[] {"È¸","ÂüÄ¡","ÃÊ¹ä","»þºê»þºê","Ã¶ÆÇ¿ä¸®","µ¤¹ä","¿ÀÄÚ³ë¹Ì¾ß³¢"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}		
				else if (comboBoxcat.getValue().equals("ºÐ½Ä")) {
					sub =  new String[] {"¶ó¸é","±è¹ä","±¹¼ö","¸¸µÎ","Ä®±¹¼ö","¶±ººÀÌ","¿ìµ¿","¼ø´ë","¶±²¿Ä¡"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}	
				else if (comboBoxcat.getValue().equals("¾ç½Ä")) {
					sub = new String[] {"µ·±î½º","Ä«·¹","½ºÆÄ°ÔÆ¼","ÆÐ¹Ð¸®·¹½ºÅä¶û","¹Ùº£Å¥","½ºÅ×ÀÌÅ©","ÇÇÀÚ"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else if (comboBoxcat.getValue().equals("±âÅ¸")) {
					sub = new String[] {"½Ò±¹¼ö","»çÃ¶ÅÁ"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else {
					sub = new String[] {"Á¾ÇÕºÎÆä","°í±âºÎÆä","ÇÑ½ÄºÎÆä","Ã¤½ÄºÎÆä","ÇØ¹°ºÎÆä"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
			}
			
			else if (cate==2) {
				if (comboBoxcat.getValue().equals("±º°ÍÁú·ù")) {
					sub = new String[] {"ÇÖµµ±×","µµ³ÊÃ÷","¾ÆÀÌ½ºÅ©¸²","À¯»ê±Õ¾ÆÀÌ½ºÅ©¸²","»ý°úÀÚ","Åä½ºÆ®","¾Ë°¨ÀÚ","¼Ò¶±¼Ò¶±","ÇÖ¹Ù"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else if (comboBoxcat.getValue().equals("Á¦°úÁ¦»§¶±ÄÉÀÍ")) {
					sub = new String[] {"»§","ÄÉÀÌÅ©","¶±","ÇÑ°ú","Âð»§"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else {
					sub = new String[] {"Ä¿ÇÇ","»ý°úÀÏÁÖ½º","º¸µå°ÔÀÓÄ«Æä","»çÁÖÄ«Æä","ÀüÅëÂþÁý","¾Ö°ßÄ«Æä"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
			}
			
			else {
				sub = new String[] {"È£ÇÁÁý", "Æ÷Àå¸¶Â÷", "²¿Ä¡±¸ÀÌ","¹Î¼ÓÁÖÁ¡","·Î¹Ù´Ù¾ß³¢","bar","¶ôÄ«Æä","°¨¼ºÁÖÁ¡"};
				int which = (int) (Math.random()*(sub.length));
				submenu.setText(sub[which]);
			}
		});
		
    	if (MainController.CATEGORY==1) category.setText("½Ä»ç");
    	else if (MainController.CATEGORY==2) category.setText("µðÀúÆ®");
    	else category.setText("ÁÖÁ¡");
		
		btn_back.setOnMouseClicked(e->App.go("category.fxml"));
	  	
		//btn_ok.setOnAction(e->handlebtncat(e));
		
	  	
	  	
	}
		
//	
//	public void  handlebtncat(ActionEvent event) 
//	{
//		System.out.println(comboBoxcat.getValue());
//		
//	}
	
}
