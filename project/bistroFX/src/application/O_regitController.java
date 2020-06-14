package application;

import java.sql.SQLException;

import core.UserOwnerDAO;
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
    
    UserOwnerDAO dao;
    
    public void initialize() {
    	
    	register.setOnMouseClicked(e->{
    		
    		String getid = id.getText();
    		String getpw = pw.getText();
    		String getname = name.getText();
    		int getstorenum = Integer.parseInt(storeNum.getText());
    		
    		dao = new UserOwnerDAO();
    		
    		try {
				if (dao.registerO(getid, getpw, getname, getstorenum) ==true) {
					App.POPSTATE = 3;
					App.pop("pop.fxml");
					App.go("main.fxml");
				}
				else {
					App.POPSTATE=7;	//존재하는 아이디
					App.pop("pop.fxml");
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    		//업주 생성 후 DB에 등록
    	});
    	
    	btn_main.setOnMouseClicked(e->{
    		App.go("main.fxml");
    	});
    }
    
}
