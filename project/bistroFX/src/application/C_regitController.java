package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class C_regitController {

    @FXML
    private TextField id;

    @FXML
    private TextField pw;

    @FXML
    private TextField name;

    @FXML
    private Button register;

    @FXML
    private Button btn_main;
    
    public void initialize() {
    	
    	register.setOnAction(e->{
    		//�մ� ���� �� DB�� ���
    	});
    	
    	btn_main.setOnMouseClicked(e->{
    		App.go("main.fxml");	
    	});
    }
}
