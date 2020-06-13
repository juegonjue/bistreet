package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import core.Store;
import core.StoreDAO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class informationController implements Initializable {
	
    @FXML
    private Label storeName;

   @FXML
   private Label storeAddress;
   @FXML
   private Button main;
   @FXML
   private Button btnreview;
   @FXML
   private Pane reviewPane;
   @FXML private Button save;
   private String info;
   private Integer storeNumber;
   @FXML private TableView<Store> reviewtable;
   @FXML private TableColumn<?, ?> id;
   @FXML private TableColumn<?, ?> review;
   @FXML private TableColumn<?, ?> eval;
   @FXML private TextField reviewField;
   @FXML private ComboBox evalbox;
   @FXML private Button buttoncol;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		main.setOnMouseClicked(e->App.go("main.fxml"));
		btnreview.setOnAction(e->handleBtnreview(e));
		save.setOnAction(e->handleBtnsave(e));
		reviewPane.setVisible(false);
		tableset();
		
		
		

	}
	
	public void setData(String data,Integer integer)
	{

		storeName.setText(data);
		storeNumber=integer;
		
		System.out.println("tbset시작");
		
		tableset();
    	
	
    
		
		
	}

    public void  handleBtnreview(ActionEvent event) 
    {
    	
    	reviewPane.setVisible(true);
    }
    
    public void  handleBtnsave(ActionEvent event) 
    {
    	StoreDAO dao= new StoreDAO();
    	try {
			dao.updatereview(storeNumber, reviewField.getText(), evalbox.getValue().toString());
			System.out.println("업데이트할정보"+storeNumber+reviewField.getText()+evalbox.getValue()); ///여기 평점 미선택 경고문띄워주기
			reviewtable.getItems().clear();
			tableset();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	reviewPane.setVisible(false);
    }
    
    public void tableset()
    {
    	
    	StoreDAO dao = new StoreDAO();
    	Store[] store = null;
    	
    	
		reviewtable.getItems().clear();
		//webEngine.executeScript("refresh()");
		try {	//list로 반환된 값이지만 , ui에 뿌려줄땐 array로 들고와야해서 type casting 한것임. 필요시 참고 !
			System.out.println("tbset중간"+storeNumber);	
			store = dao.review(storeNumber).toArray(new Store[dao.review(storeNumber).size()]);
			System.out.println(store.length+"tbset중");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		id.setCellValueFactory(new PropertyValueFactory<>("ID"));
		review.setCellValueFactory(new PropertyValueFactory<>("review"));
		eval.setCellValueFactory(new PropertyValueFactory<>("eval"));
		reviewtable.getItems().addAll(store);
    }
	

}


