package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class LoginController {

    @FXML
    private TextArea id;

    @FXML
    private TextArea pw;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_back;

    public void initialize() {
    	
    	btn_login.setOnMouseClicked(e->{
    		
    		//아이디, 비밀번호 일치 확인 후 로그인완료. 이후 바로 main창으로 넘어가게 세팅
    		
    	});
    	
    	btn_back.setOnMouseClicked(e->{
    		App.go("main.fxml");
    	});
    	
    }
    
    
    
}
