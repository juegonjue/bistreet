package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

 
public class MainController {

	public static int CATEGORY =0;	//1:식사, 2:디저트, 3:주류
	
    @FXML
    private Button main_search;

    @FXML
    private Label login;

    @FXML
    private Button main_meal;

    @FXML
    private Button main_dessert;

    @FXML
    private Button main_beer;

    @FXML
    private Label myinfo;

    @FXML
    private Label c_register;	//손님 회원가입

    @FXML
    private Label o_register;	//업주 회원가입
    
    public void initialize() {
    	
    	if(App.logstate.isLogin==true)
    	{
    		
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
    	
    	o_register.setOnMouseClicked(e->{
    		App.go("O_regit.fxml");
    	});
    		
    	c_register.setOnMouseClicked(e->{
    		App.go("C_regit.fxml");
    	});	
    	
    	myinfo.setOnMouseClicked(e->{
    		App.go("");
    	});
    }
} 
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        btnLogin.setOnAction(e->handleBtnLogin(e));
//        btnmeal.setOnAction(e->handleBtnmeal(e));
//    }
    
//    public void  handleBtnLogin(ActionEvent event) 
//    {
//        try
//        { // 로그인 화면으로 이동
//            Parent login= FXMLLoader.load(getClass().getResource("login.fxml"));
//            StackPane root = (StackPane) btnLogin.getScene().getRoot();
//            root.getChildren().add(login);
//            
//
//        } catch(Exception e) 
//        {
//            e.printStackTrace();
//        }
//    }
//    
//    public void  handleBtnmeal(ActionEvent event) 
//    {
//        try
//        { //밀로 이동
//            Parent meal= FXMLLoader.load(getClass().getResource("meal.fxml"));
//            StackPane root = (StackPane) btnmeal.getScene().getRoot();
//            root.getChildren().add(meal);
//            
//
//        } catch(Exception e) 
//        {
//            e.printStackTrace();
//        }
//    }
    

