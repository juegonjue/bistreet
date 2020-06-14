package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PopController {

    @FXML
    private Label message;
    
    
    public void initialize() {
    	if (App.POPSTATE==1) message.setText("아이디와 비밀번호 정보가 일치하지 않습니다.");
    	else if (App.POPSTATE==2) message.setText("로그아웃 되었습니다.");
    	else if (App.POPSTATE==3) message.setText("");
    	else message.setText("");
    }
}
