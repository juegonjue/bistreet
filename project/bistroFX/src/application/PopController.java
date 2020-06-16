package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PopController {

    @FXML
    private Label message;
    
    public void initialize() {
    	if (App.POPSTATE==1) message.setText("아이디와 비밀번호 정보가 일치하지 않습니다.");
    	else if (App.POPSTATE==2) message.setText("로그아웃 되었습니다.");
    	else if (App.POPSTATE==3) message.setText("회원가입 되었습니다.");
    	else if (App.POPSTATE==4) message.setText("회원가입에 실패하였습니다.");
    	else if (App.POPSTATE==5) message.setText("존재하지 않는 계정입니다.");
    	else if (App.POPSTATE==6) message.setText("메뉴판이 수정되었습니다.");
    	else if (App.POPSTATE==7) message.setText("이미 존재하는 아이디입니다.");
    	else if (App.POPSTATE==8) message.setText("지도에서 위치를 선택하고 카테고리를 선택해주세요");

    	else message.setText("");
    }
}
