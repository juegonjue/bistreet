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

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnMain.setOnAction(e->btnMain(e));
        btnnearRecom.setOnAction(e-> handlebtnnearRecom(e));
    }
    
    public void  btnMain(ActionEvent event) 
    {
        try
        { //메인화면으로 이동
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
        { //밀로 이동
            Parent Main= FXMLLoader.load(getClass().getResource("NearRecom.fxml"));
            StackPane root = (StackPane) btnnearRecom.getScene().getRoot();
            root.getChildren().add(Main);
            

        } catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
}
