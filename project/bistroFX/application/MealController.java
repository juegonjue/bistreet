package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CategoryController {


    @FXML
    private Button btn_main;

    @FXML
    private Button btn_nearRound;

    @FXML
    private Button btn_random;

    @FXML
    private Label category;	//ī�װ�-  1:�Ļ�,  2:����Ʈ,  3:����
    
    public void initialize() {
    
    	if (MainController.CATEGORY==1) category.setText("�Ļ�");
    	else if (MainController.CATEGORY==2) category.setText("����Ʈ");
    	else category.setText("����");
    	
    	btn_main.setOnMouseClicked(e->App.go("main.fxml"));
    	btn_random.setOnMouseClicked(e->App.go("random.fxml"));
    	btn_nearRound.setOnMouseClicked(e->App.go("NearRecom.fxml"));
    	
    }
}

//package application;
//
//import java.net.URL;
//import java.util.ResourceBundle;
// 
//import javafx.animation.KeyFrame;
//import javafx.animation.KeyValue;
//import javafx.animation.Timeline;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.util.Duration;
//
// 
//public class MealController implements Initializable {
//    @FXML private Button btnMain;
//    @FXML private Button btnnearRecom;
//
//    
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        btnMain.setOnAction(e->btnMain(e));
//        btnnearRecom.setOnAction(e-> handlebtnnearRecom(e));
//    }
//    
//    public void  btnMain(ActionEvent event) 
//    {
//        try
//        { //����ȭ������ �̵�
//            Parent Main= FXMLLoader.load(getClass().getResource("root.fxml"));
//            StackPane root = (StackPane) btnMain.getScene().getRoot();
//            root.getChildren().add(Main);
//            
//
//        } catch(Exception e) 
//        {
//            e.printStackTrace();
//        }
//    }
//    
//    public void  handlebtnnearRecom(ActionEvent event) 
//    {
//        try
//        { //�з� �̵�
//            Parent Main= FXMLLoader.load(getClass().getResource("NearRecom.fxml"));
//            StackPane root = (StackPane) btnnearRecom.getScene().getRoot();
//            root.getChildren().add(Main);
//            
//
//        } catch(Exception e) 
//        {
//            e.printStackTrace();
//        }
//    }
//    
//}
