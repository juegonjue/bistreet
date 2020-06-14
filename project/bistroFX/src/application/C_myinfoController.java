package application;

import java.sql.SQLException;

import core.Review;
import core.ReviewDAO;
import core.UserCustomerDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class C_myinfoController {

		
    @FXML
    private TableView<Review> reviewTable;

    @FXML
    private TableColumn<?, ?> r_storeName;

    @FXML
    private TableColumn<?, ?> reviewStar;

    @FXML
    private TableColumn<?, ?> reviewText;

   // @FXML
    //private TableColumn<?, ?> createDate;

    @FXML
    private Label id;

    @FXML
    private TableView<Review> interestTable;

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
    	
    	Review[] review = null;
    	
    	try {
    		ReviewDAO rdao = new ReviewDAO();
			review =rdao.selectCustomerReview(cid).toArray(new Review[rdao.selectCustomerReview(cid).size()]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	r_storeName.setCellValueFactory(new PropertyValueFactory<>("storeNumber"));
    	reviewStar.setCellValueFactory(new PropertyValueFactory<>("reviewStar"));
    	reviewText.setCellValueFactory(new PropertyValueFactory<>("reviewText"));
    	
    	reviewTable.getItems().addAll(review);
    	
    	
    }
}
