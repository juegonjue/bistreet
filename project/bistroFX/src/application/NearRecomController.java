package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import core.Store;
import core.StoreDAO;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

 
public class NearRecomController implements Initializable {
   @FXML private Button btnMain;
   @FXML private Button btnSearch;
   @FXML private Button btnpick;
   @FXML private TextField textAddress;
   @FXML private WebView webView;
   @FXML private ComboBox comboBoxcat; 
   @FXML private Button btncat;
   @FXML private TableView<Store> mealtable;
   @FXML private TableColumn<?, ?> name;
   @FXML private TableColumn<?, Double> distance;
   @FXML private TableColumn<?, ?> col3;
   
   double x;
   double y;
  private WebEngine webEngine; 

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	btnMain.setOnMouseClicked(e->App.go("main.fxml"));
    	btncat.setOnAction(e->handlebtncat(e));
       btnSearch.setOnAction(e->handleBtns(e));
       btnpick.setOnAction(e->handlebtnpick(e));
       webEngine = webView.getEngine();
     webEngine.load("https://dean7347.github.io/BistroMap/map");
     //webEngine.load("https://google.com");
     //webEngine.load("http://127.0.0.1:5500/map.html");
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
			                //markPosiont 찍어주는 함수입니다
			            	//webEngine.executeScript("markPosition('ㅇㄹ번째',33.953705, 126.570677)");
			            	//webEngine.executeScript("insertMarkInfo('카카오',36.1447281247339, 128.388374591701)");
			            	//webEngine.executeScript("insertMarkInfo('생태연못',36.450936, 128.388374591701)");
			            	//webEngine.executeScript("mark()");
			            	//System.out.println(webEngine.executeScript("placexy()"));
			            	
			                return;
			            }
			            //webEngine.reload();

			           
			        
			        }
			    }
			);
		 
    }
    
    public void  handleBtnLogin(ActionEvent event) 
    {
        try
        { // 메인 화면으로 이동
            Parent login= FXMLLoader.load(getClass().getResource("root.fxml"));
            StackPane root = (StackPane) btnMain.getScene().getRoot();
            root.getChildren().add(login);
            

        } catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    
    
    public void  handleBtns(ActionEvent event) 
    {
    	String address = textAddress.getText();
    	System.out.println(address);
    	String search="addrsearch("+"'"+address+"'"+")";
    	webEngine.executeScript(search);
    	
    }
    
    public void  handlebtnpick(ActionEvent event) 
    {
    	System.out.println(webEngine.executeScript("pushX()"));
    	System.out.println(webEngine.executeScript("pushY()"));
    	
    	
    }
    public void  handlebtncat(ActionEvent event) 
    {
    	StoreDAO dao = new StoreDAO();
    	Store[] store = null;
    	
		try {	//list로 반환된 값이지만 , ui에 뿌려줄땐 array로 들고와야해서 type casting 한것임. 필요시 참고 !
			store = dao.whereAllmeal(Double.parseDouble((String) webEngine.executeScript("pushX()")) 
					,Double.parseDouble((String) webEngine.executeScript("pushY()")))
					.toArray(new Store[dao.whereAllmeal(Double.parseDouble((String) webEngine.executeScript("pushX()")),
					                   Double.parseDouble((String) webEngine.executeScript("pushX()"))).size()]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    	name.setCellValueFactory(new PropertyValueFactory<>("storeName"));
    	distance.setCellValueFactory(new PropertyValueFactory<>("storeAddress"));
    	col3.setCellValueFactory(new PropertyValueFactory<>("dst"));
    	mealtable.getItems().addAll(store);
    	System.out.println(store[1].getStoreName()+store[1].getStoreAddress()+store.length);
    	for(int i =0; i<store.length; i++)
    	{
    		String parm = "insertMarkInfo('"+store[i].getStoreName()+"',"+store[i].getwDegree()+","+store[i].getkDegree()+")";
    	webEngine.executeScript(parm);
    	}
    	
    	//webEngine.executeScript("insertMarkInfo('생태연못',36.450936, 128.388374591701)");
    	webEngine.executeScript("mark()");
    	System.out.println("마킹완료");
    	
    	
    	
    }
    //new LoadMap();
    
    
    
    
}
