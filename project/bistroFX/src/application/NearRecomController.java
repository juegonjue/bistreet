package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

import javax.swing.table.DefaultTableModel;

import core.Store;
import core.StoreDAO;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

 
public class NearRecomController implements Initializable {
   @FXML private Button btnMain;
   @FXML private Button btnSearch;
   @FXML private Button btnreser;
  // @FXML private Button btnpick;
   @FXML private TextField textAddress;
   @FXML private WebView webView;
   @FXML private ComboBox comboBoxcat; 
   @FXML private Button btncat;
   @FXML private TableView<Store> mealtable;
   @FXML private TableColumn<?, ?> name;
   @FXML private TableColumn<?, Double> distance;
   @FXML private TableColumn<?, ?> col3;
   @FXML private Pane reser;
   String search;
   String focus;
   double x;
   double y;
  private WebEngine webEngine;
  public String reviewname;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    	if(MainController.CATEGORY==2 ||MainController.CATEGORY==3)
    	{
    		comboBoxcat.setVisible(false);
    	}
    
    	//테이블뷰 클릭이벤트
    	mealtable.setOnMouseClicked(new EventHandler<MouseEvent>() 
    	{
		    @Override
		    public void handle(MouseEvent event) {
			      if(event.getClickCount() <2 ) 
			      {
			    	  
			    	  
			    	  
			    	  focus ="focus("+mealtable.getSelectionModel().getSelectedItem().getkDegree()
			    			  		+","+mealtable.getSelectionModel().getSelectedItem().getwDegree()+")";
			    	webEngine.executeScript(focus);
			        System.out.println(mealtable.getSelectionModel().getSelectedItem().getkDegree());
			        System.out.println(mealtable.getSelectionModel().getSelectedItem().getwDegree());
			        System.out.println(mealtable.getSelectionModel().getSelectedItem().getStoreNumber());
			       // mealtable.setOnMouseClicked(e->App.go("information.fxml"));
			      }
		    	if(event.getClickCount() > 1) 
		      {
		        System.out.println(mealtable.getSelectionModel().getSelectedItem().getStoreName());
		        
		        /*
		        String data = "Hello World!";
		       
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("information.fxml"));
		       
		        try {

					Parent root = loader.load();
					 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        informationController controller = loader.<informationController>getController();
	        	controller.setData("asdfasddfas");
	        	App.go("information.fxml");
		       */
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(getClass().getResource("information.fxml"));
		        try {
					Parent root =(Parent)loader.load();
					Scene scene = new Scene(root);
			        
			        informationController pop = loader.getController();
			        pop.setData(mealtable.getSelectionModel().getSelectedItem().getStoreName(),mealtable.getSelectionModel().getSelectedItem().getStoreNumber());
			        System.out.println("보내는데이터"+mealtable.getSelectionModel().getSelectedItem().getStoreNumber());
			        Stage stage = new Stage();
			        stage.setScene(scene);
			        stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        

		      }
		    	
		    }
    	});

    	
    	
    	
    	
    	btnMain.setOnMouseClicked(e->App.go("main.fxml"));
    	btncat.setOnAction(e->handlebtncat(e));
    	btnreser.setOnAction(e->handlebtnreser(e));
       btnSearch.setOnAction(e->handleBtns(e));
       //btnpick.setOnAction(e->handlebtnpick(e));
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
    
    public String reviewData()
    {
    	return reviewname;
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
    	search="addrsearch("+"'"+address+"'"+")";
    	webEngine.executeScript(search);
    	
    }
    
    public void  handlebtnpick(ActionEvent event) 
    {
    	System.out.println(webEngine.executeScript("pushX()"));
    	System.out.println(webEngine.executeScript("pushY()"));
    	
    	
    }
    
    
    public void  handlebtnreser(ActionEvent event) 
    {
    	webEngine.executeScript("refresh()");
    	reser.setVisible(false);
    	
    	
    }
    public void  handlebtncat(ActionEvent event) 
    {
    	String classsql = null;
		
		if(MainController.CATEGORY==1 ) //1:식사, 2:디저트, 3:주류
		{
			if(comboBoxcat.getSelectionModel().getSelectedItem()==null)
			{
				App.POPSTATE=8;
				App.pop("pop.fxml");
			}
			if(comboBoxcat.getSelectionModel().getSelectedItem().toString().equals("한식"))
			{ ///소분류기준
				System.out.println("한식");			
				classsql = "AND 상권업종소분류코드 IN('Q01A01','Q01A02','Q01A03','Q01A04','Q01A05',"
						+ "'Q01A06','Q01A07','Q01A08','Q01A09','Q01A10','Q01A11','Q01A12','Q01A13',"
						+ "'Q01A14','Q01A15','Q01A16','Q01A17','Q01A18','Q01A19','Q03A05','Q03A06','Q03A07',"
						+ "'Q03A08','Q03A09','Q03A10','Q03A11','Q03A13','Q03A14','Q03A15','Q03A16','Q03A17',"
						+ "'Q03A18','Q03A19','Q03A20','Q03A99','Q05A01','Q05A02','Q05A03','Q05A04','Q05A05',"
						+ "'Q05A06','Q05A07','Q05A08','Q05A09','Q05A10','Q10A01','Q10A04','Q10A05','Q13A01',"
						+ "'Q13A02','Q13A03')";
			}
			
			if(comboBoxcat.getSelectionModel().getSelectedItem().toString().equals("중식"))
			{
				System.out.println("중식");	
				classsql="AND 상권업종소분류코드 IN('Q02A00','Q02A01')";
			}
			
			if(comboBoxcat.getSelectionModel().getSelectedItem().toString().equals("일식"))
			{
				System.out.println("일식");	
				classsql="AND 상권업종소분류코드 IN('Q03A01','Q03A02','Q03A03','Q03A04','Q10A02','Q10A03')";
			}
			
			if(comboBoxcat.getSelectionModel().getSelectedItem().toString().equals("분식"))
			{
				System.out.println("분식");	
				classsql="AND 상권업종소분류코드 IN('Q04A01','Q04A02','Q04A03','Q04A04')";
			}
			
			if(comboBoxcat.getSelectionModel().getSelectedItem().toString().equals("양식"))
			{
				System.out.println("양식");
				classsql="AND 상권업종소분류코드 IN('Q06A01','Q06A02','Q06A03','Q06A04','Q06A05','Q06A06','Q06A07','Q06A08','Q07A01','Q07A02')";
			}
			
			if(comboBoxcat.getSelectionModel().getSelectedItem().toString().equals("뷔폐"))
			{
				System.out.println("뷔폐");	
				classsql="AND 상권업종소분류코드 IN('Q15A01','Q15A02','Q15A03','Q15A04','Q15A05')";
			}
			
			if(comboBoxcat.getSelectionModel().getSelectedItem().toString().equals("기타"))
			{
				System.out.println("기타");	
				classsql="AND 상권업종소분류코드 IN('Q10A06','Q10A08','Q10A09','Q14A01','Q14A02')";
			}
			
		}else if (MainController.CATEGORY==2)
		{
			System.out.println("디저트");	
			
			classsql="AND 상권업종소분류코드 IN('Q07A03','Q07A06','Q07A07','Q07A08','Q07A09','Q07A10',"
					+ "'Q08A01','Q08A02','Q08A03','Q08A04','Q08A05'"
					+ "'Q12A01','Q12A03','Q12A04','Q12A05','Q12A06','Q12A07')";
		}else
		{
			
			System.out.println("주점");	
			classsql="AND 상권업종소분류코드 IN('Q09A01','Q09A02','Q09A03','Q09A04','Q09A05','Q09A06','Q09A07','Q09A08','Q09A09','Q09A10')";
		}
		
		
		StoreDAO dao = new StoreDAO();
    	Store[] store = null;
    	
    	
		mealtable.getItems().clear();
		//webEngine.executeScript("refresh()");
		try {	//list로 반환된 값이지만 , ui에 뿌려줄땐 array로 들고와야해서 type casting 한것임. 필요시 참고 !
			store = dao.whereAllmeal(Double.parseDouble((String) webEngine.executeScript("pushX()")) 
					,Double.parseDouble((String) webEngine.executeScript("pushY()")),classsql)
					.toArray(new Store[dao.whereAllmeal(Double.parseDouble((String) webEngine.executeScript("pushX()")),
					                   Double.parseDouble((String) webEngine.executeScript("pushX()")),classsql).size()]);
		} catch (SQLException e) {
			e.printStackTrace();
	
		}
		
		//테이블 먼저 초기화
    	name.setCellValueFactory(new PropertyValueFactory<>("storeName"));
    	distance.setCellValueFactory(new PropertyValueFactory<>("storeAddress"));
    	col3.setCellValueFactory(new PropertyValueFactory<>("kDegrees"));
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
    	reser.setVisible(true);
    	
    	
    }
    //new LoadMap();
    
    
    //정보전달을 위한 메소드
    public void info(String _data)
    {
    	


    }
    
    
    
}
