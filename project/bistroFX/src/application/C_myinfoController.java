package application;

import java.sql.SQLException;

import core.InterestDAO;
import core.MyReview;
import core.MyReviewDAO;
import core.Store;
import core.UserCustomerDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class C_myinfoController {

		
    @FXML
    private TableView<MyReview> reviewTable;

    @FXML
    private TableColumn<?, ?> r_storeName;

    @FXML
    private TableColumn<?, ?> reviewStar;

    @FXML
    private TableColumn<?, ?> reviewText;

    @FXML
    private TableColumn<?, ?> createDate;

    @FXML
    private Label id;

    @FXML
    private TableView<Store> interestTable;

    @FXML
    private TableColumn<?, ?> i_storeName;

    @FXML
    private TableColumn<?, ?> storeAddress;

    @FXML
    private Button btn_main;
    
    UserCustomerDAO dao = new UserCustomerDAO();

	String cid = App.logininfo.getId();
	String customername;
    public void initialize() {
    	
    	btn_main.setOnMouseClicked(e->{App.go("main.fxml");});
    	
    	try {
			customername = dao.selectCustomerName(cid);
		} catch (SQLException e1) {e1.printStackTrace();}
    	
    	id.setText(customername);
    	
    	MyReviewDAO mrdao = new MyReviewDAO();
    	MyReview[] myreview = null;

    	try {
			myreview =mrdao.selectCustomerReview(cid).toArray(new MyReview[mrdao.selectCustomerReview(cid).size()]);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	r_storeName.setCellValueFactory(new PropertyValueFactory<>("storeName"));
    	reviewStar.setCellValueFactory(new PropertyValueFactory<>("reviewStar"));
    	reviewText.setCellValueFactory(new PropertyValueFactory<>("reviewText"));
    	createDate.setCellValueFactory(new PropertyValueFactory<>("createDate"));
    	
    	reviewTable.getItems().addAll(myreview);
    	
    	
    	InterestDAO idao = new InterestDAO();
    	Store[] store = null;
    	
    	try {
			store = idao.selectInterest(cid).toArray(new Store[idao.selectInterest(cid).size()]);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	i_storeName.setCellValueFactory(new PropertyValueFactory<>("storeName"));
    	storeAddress.setCellValueFactory(new PropertyValueFactory<>("storeAddress"));
    	
    	interestTable.getItems().addAll(store);
    	
    }
}
