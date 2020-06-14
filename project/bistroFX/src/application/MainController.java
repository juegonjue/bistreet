package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

 
public class MainController {

	public static int CATEGORY =0;	//1:식사, 2:디저트, 3:주류
	public static String USER = "";
	
    @FXML
    private Button main_search;

    @FXML
    private Button main_meal;

    @FXML
    private Button main_dessert;

    @FXML
    private Button main_beer;

    @FXML
    private Button myinfo;

    @FXML
    private Button login;

    @FXML
    private Button logout;
    
    @FXML
    private Button c_register;

    @FXML
    private Button o_register;

    
    public void initialize() {
    	
    	
    	if(App.logininfo.getIsLogin()==true)
    	{
    		USER = App.logininfo.getId();
    		System.out.println("로그인완료");
    	}
    	main_meal.setOnMouseClicked(event->{
    		CATEGORY=1;
    		App.go("category.fxml");
    	});
    	
    	main_dessert.setOnMouseClicked(event->{
    		CATEGORY=2;
    		App.go("category.fxml");
    	});
    	
    	main_beer.setOnMouseClicked(event->{
    		CATEGORY=3;
    		App.go("category.fxml");
    	});
    	
    	main_search.setOnMouseClicked(event->{
    		System.out.println("search");
    	});
    	
    	login.setOnMouseClicked(e->{
    		App.go("login.fxml");
    	});
    	
    	logout.setOnMouseClicked(e->{
    		App.logininfo.setIsLogin(false);
    		App.logininfo.setId(null);
    		App.logininfo.setType(0);
    		
    		login.setVisible(true);
    		logout.setVisible(false);
    		myinfo.setVisible(false);  
    		c_register.setVisible(true);
    		o_register.setVisible(true);

    		App.POPSTATE=2;
    		App.pop("pop.fxml");

    	});
    	
    	o_register.setOnMouseClicked(e->{
    		App.go("O_regit.fxml");
    	});
    		
    	c_register.setOnMouseClicked(e->{
    		App.go("C_regit.fxml");
    	});	
    	
    	if (App.logininfo.getType()==0) {
    		myinfo.setVisible(false);
        	logout.setVisible(false);
    	}
    	else {
    		login.setVisible(false);
    		c_register.setVisible(false);
    		o_register.setVisible(false);
    	}
    	
    	myinfo.setOnMouseClicked(e->{
    		if (App.logininfo.getType()==1) App.go("C_myinfo.fxml");
    		else if (App.logininfo.getType()==2) App.go("O_myinfo.fxml");   
    	});
    }
} 
    

