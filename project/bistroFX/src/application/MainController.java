package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

 
public class MainController {

    @FXML
    private ImageView main_meal;

    @FXML
    private ImageView main_dessert;

    @FXML
    private ImageView main_beer;

    @FXML
    private Button main_search;
    
    @FXML
    private Label loginOrRegister;
    
    public void initialize() {
    	
    	if(App.logstate.isLogin==true)
    	{
    		System.out.println("로그인완료");
    	}
    	main_meal.setOnMouseClicked(event->{
    		App.go("meal.fxml");
    	});
    	
    	main_dessert.setOnMouseClicked(event->{
    		App.go("dessert.fxml");
    	});
    	
    	main_beer.setOnMouseClicked(event->{
    		App.go("beer.fxml");
    	});
    	
    	main_search.setOnMouseClicked(event->{
    		System.out.println("search");
    	});
    	
    	loginOrRegister.setOnMouseClicked(e->{
    		App.go("login.fxml");
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
    

