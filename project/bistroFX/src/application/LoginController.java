package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.sql.SQLException;

import core.LoginRegisterDAO;

public class LoginController {

    @FXML
    private TextArea id;

    @FXML
    private TextArea pw;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_back;
    
    LoginRegisterDAO dao;

    public void initialize() {
    	
    	btn_login.setOnMouseClicked(e->{
    		
    		try {
				dao.login(id.getText(), pw.getText());
			} catch (SQLException e1) {e1.printStackTrace();}
    		
    		//���̵�, ��й�ȣ ��ġ Ȯ�� �� �α��οϷ�. ���� �ٷ� mainâ���� �Ѿ�� ����
    		//if ~~ {static String id = test; App.go(main.fxml);}
    		
    	});
    	
    	btn_back.setOnMouseClicked(e->{
    		App.go("main.fxml");
    	});
    	
    }
    
    
    
}
