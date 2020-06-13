package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class C_myinfoController {

	String customerId = App.logstate.getId();
	
    @FXML
    private TableView<?> reviewTable;

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
    private TableView<?> interestTable;

    @FXML
    private TableColumn<?, ?> i_storeName;

    @FXML
    private TableColumn<?, ?> storeAddress;
 
    
    public void initialize() {
    	
    	id.setText(customerId);
    	
    	
    	
    	
    }
}
