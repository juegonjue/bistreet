package application;

import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

 
public class MealController implements Initializable {
    @FXML private Button btnMain;
    @FXML private Button btnnearRecom;
    @FXML private Button btnnearRandom;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnMain.setOnAction(e->btnMain(e));
        btnnearRecom.setOnAction(e-> handlebtnnearRecom(e));
        btnnearRandom.setOnAction(e-> handlebtnnearRandom(e));
    }
    
    public void  btnMain(ActionEvent event) 
    {
        try
        { //����ȭ������ �̵�
            Parent Main= FXMLLoader.load(getClass().getResource("root.fxml"));
            StackPane root = (StackPane) btnMain.getScene().getRoot();
            root.getChildren().add(Main);
            

        } catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void  handlebtnnearRecom(ActionEvent event) 
    {
        try
        { //�з� �̵�
            Parent Main= FXMLLoader.load(getClass().getResource("NearRecom.fxml"));
            StackPane root = (StackPane) btnnearRecom.getScene().getRoot();
            root.getChildren().add(Main);
            

        } catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    
    public void  handlebtnnearRandom(ActionEvent event) 
    {
        try
        { //�з� �̵�
            Parent Main= FXMLLoader.load(getClass().getResource("MealRandom.fxml"));
            StackPane root = (StackPane) btnnearRandom.getScene().getRoot();
            root.getChildren().add(Main);
            

        } catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
}
