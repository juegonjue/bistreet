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
    		
    		//���̵�, ��й�ȣ ��ġ Ȯ�� �� �α��οϷ�. ���� �ٷ� mainâ���� �Ѿ�� ����
    		
    	});
    	
    	btn_back.setOnMouseClicked(e->{
    		App.go("main.fxml");
    	});
    	
    }
    
    
    
}
