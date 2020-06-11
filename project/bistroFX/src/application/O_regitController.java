package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class O_regitController {

    @FXML
    private Button btn_main;

    @FXML
    private Button register;

    @FXML
    private TextField name;

    @FXML
    private TextField pw;

    @FXML
    private TextField id;

    @FXML
    private TextField storeNum;
    
    public void initialize() {
    	
    	register.setOnMouseClicked(e->{
    		
    		//업주 생성 후 DB에 등록
    	});
    	
    	btn_main.setOnMouseClicked(e->{
    		App.go("main.fxml");
    	});
    }
    
}
