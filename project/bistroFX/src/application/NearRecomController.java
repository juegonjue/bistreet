package application;



import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

 
public class NearRecomController implements Initializable {
   @FXML private Button btnMain;
    @FXML private Button btnsearch;
  @FXML private WebView webView;
  @FXML private TextField textAddress;
  private WebEngine webEngine; 
  

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       btnMain.setOnAction(e->handleBtnLogin(e));
       btnsearch.setOnAction(e->handleBtnSearch(e));
      
       
       
       webEngine = webView.getEngine();
     //webEngine.load("https://dean7347.github.io/BistroMap/map");
     webEngine.load("http://127.0.0.1:5500/map.html");
     
     //webEngine.load("https://google.com");
	 	webEngine.getLoadWorker().stateProperty().addListener(
			    new ChangeListener() {
			        @Override
			        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
			            System.out.println("oldValue: " + oldValue);
			            System.out.println("newValue: " + newValue);

			            if (newValue != Worker.State.SUCCEEDED) {
		
			                return;
			            }
			            
			            
			            
			            if (newValue == Worker.State.SUCCEEDED) {
			                //markPosiont ����ִ� �Լ��Դϴ�
			            	//webEngine.executeScript("markPosition('������°',33.953705, 126.570677)");
			            	//webEngine.executeScript("insertMarkInfo('īī��',33.450705, 126.570677)");
			            	//webEngine.executeScript("insertMarkInfo('���¿���',33.450936, 126.569477)");
			            	//webEngine.executeScript("mark()");
			            	System.out.println(webEngine.executeScript("addrsearch('abcv')"));
			            	
			                return;
			            }
			            //webEngine.reload();			           			        
			        }
			    }
			);
		 
    }
    
    
    public void  handleBtnSearch(ActionEvent event) 
    {
     String address =textAddress.getText();
     System.out.println("�ּ� :"+address);
    }
    
    public void  handleBtnLogin(ActionEvent event) 
    {
        try
        { // ���� ȭ������ �̵�
            Parent login= FXMLLoader.load(getClass().getResource("root.fxml"));
            StackPane root = (StackPane) btnMain.getScene().getRoot();
            root.getChildren().add(login);
            

        } catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    //new LoadMap();
    
    
    
    
}