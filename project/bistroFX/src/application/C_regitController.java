package application;

import java.sql.SQLException;

import core.UserCustomerDAO;

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
    
    UserCustomerDAO dao;
    
    public void initialize() {
    	
    	register.setOnAction(e->{
    		
    		String getid = id.getText();
    		String getpw = pw.getText();
    		String getname = name.getText();
    		//손님 생성 후 DB에 등록
    		dao = new UserCustomerDAO();
    		
    		try {
				if (dao.registerC(getid, getpw, getname)==true) {
					App.POPSTATE=3;
					App.pop("pop.fxml");
					App.go("main.fxml");
				}
				else {
					App.POPSTATE=7;
					App.pop("pop.fxml");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	});
    	
    	btn_main.setOnMouseClicked(e->{
    		App.go("main.fxml");	
    	});
    }
}
