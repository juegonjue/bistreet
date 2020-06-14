package application;

import java.sql.SQLException;

import core.Review;
import core.ReviewDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class C_myinfoController {

	
	String cid = App.logininfo.getId();
	
    @FXML
    private TableView<Review> reviewTable;

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
    private TableView<Review> interestTable;

    @FXML
    private TableColumn<?, ?> i_storeName;

    @FXML
    private TableColumn<?, ?> storeAddress;

    @FXML
    private Button btn_main;
 
    
    public void initialize() {
    	
    	btn_main.setOnMouseClicked(e->{App.go("main.fxml");});
    	
    	id.setText(cid);
    	
    	ReviewDAO dao = new ReviewDAO();
    	Review[] review = null;
    	
    	try {
			review =dao.selectCustomerReview(cid).toArray(new Review[dao.selectCustomerReview(cid).size()]);
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
