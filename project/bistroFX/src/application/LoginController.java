package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.sql.SQLException;

import core.LoginLogoutDAO;

public class LoginController {

    @FXML
    private TextArea id;

    @FXML
    private TextArea pw;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_back;
    
    LoginLogoutDAO dao;

    public void initialize() {
    	
    	btn_login.setOnMouseClicked(e->{
    		String getid = id.getText();
    		String getpw = pw.getText();
    		
    		dao = new LoginLogoutDAO();
    		try {
				if (dao.login(getid, getpw)==true) {
					App.go("main.fxml");
				}
				
				else {
					//App.POPSTATE = 1;	//로그인실패
					App.pop("pop.fxml");
				}
			} catch (SQLException e1) {e1.printStackTrace();}

    	});
    	
    	btn_back.setOnMouseClicked(e->{
    		App.go("main.fxml");
    	});
    	
    }
    
    
    
}
