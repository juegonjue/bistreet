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
		
		System.out.println("tbset����");
		
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
			System.out.println("������Ʈ������"+storeNumber+reviewField.getText()+evalbox.getValue()); ///���� ���� �̼��� �������ֱ�
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
		try {	//list�� ��ȯ�� �������� , ui�� �ѷ��ٶ� array�� ���;��ؼ� type casting �Ѱ���. �ʿ�� ���� !
			System.out.println("tbset�߰�"+storeNumber);	
			store = dao.review(storeNumber).toArray(new Store[dao.review(storeNumber).size()]);
			System.out.println(store.length+"tbset��");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		id.setCellValueFactory(new PropertyValueFactory<>("ID"));
		review.setCellValueFactory(new PropertyValueFactory<>("review"));
		eval.setCellValueFactory(new PropertyValueFactory<>("eval"));
		reviewtable.getItems().addAll(store);
    }
	

}


