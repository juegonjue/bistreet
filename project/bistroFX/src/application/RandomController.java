package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class RandomController {
	
    @FXML
    private Label category;

    @FXML
    private ComboBox<?> comboBoxcat;

    @FXML
    private Label submenu;

    @FXML
    private Button btn_ok;

    @FXML
    private Button btn_back;


	public void initialize() {
		
    	if (MainController.CATEGORY==1) category.setText("�Ļ�");
    	else if (MainController.CATEGORY==2) category.setText("����Ʈ");
    	else category.setText("����");
		
		btn_back.setOnMouseClicked(e->App.go("category.fxml"));
	  	btn_ok.setOnAction(e->handlebtncat(e));
		
	}
		
	
	public void  handlebtncat(ActionEvent event) 
	{
		System.out.println(comboBoxcat.getValue());
		
	}
	
}
