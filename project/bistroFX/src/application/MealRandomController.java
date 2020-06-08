package application;


import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class MealRandomController {
@FXML Button btnmain;



public void initialize() {
	
	btnmain.setOnMouseClicked(e->App.go("main.fxml"));

	
}
	
	
}
