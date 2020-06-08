package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;


public class MealRandomController {
@FXML private Button btnmain;
@FXML private Button btnok;
@FXML private ComboBox comboBoxcat;



public void initialize() {
	
	btnmain.setOnMouseClicked(e->App.go("main.fxml"));
  	btnok.setOnAction(e->handlebtncat(e));
	
}
	

public void  handlebtncat(ActionEvent event) 
{
	
	System.out.println(comboBoxcat.getValue());
	
	
}
	
}
