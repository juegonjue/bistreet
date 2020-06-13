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
    		String getid = id.getText();
    		String getpw = pw.getText();
    		
    		dao = new LoginRegisterDAO();
    		try {
				if (dao.login(getid, getpw)==true) {
					System.out.println("로그인 성공");
					App.go("main.fxml");
				}
					
				
				else 
					System.out.println("로그인 실패"); 
					//App.pop("");
			} catch (SQLException e1) {e1.printStackTrace();}

    	});
    	
    	btn_back.setOnMouseClicked(e->{
    		App.go("main.fxml");
    	});
    	
    }
    
    
    
}
