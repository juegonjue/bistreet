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

 
public class MainController implements Initializable {
    @FXML private Button btnLogin;
    @FXML private Button btnmeal;
    @FXML private Button btnpup;
    @FXML private Button btndesert;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnLogin.setOnAction(e->handleBtnLogin(e));
        btnmeal.setOnAction(e->handleBtnmeal(e));
    }
    
    public void  handleBtnLogin(ActionEvent event) 
    {
        try
        { // 로그인 화면으로 이동
            Parent login= FXMLLoader.load(getClass().getResource("login.fxml"));
            StackPane root = (StackPane) btnLogin.getScene().getRoot();
            root.getChildren().add(login);
            

        } catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void  handleBtnmeal(ActionEvent event) 
    {
        try
        { //밀로 이동
            Parent meal= FXMLLoader.load(getClass().getResource("meal.fxml"));
            StackPane root = (StackPane) btnmeal.getScene().getRoot();
            root.getChildren().add(meal);
            

        } catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
}
