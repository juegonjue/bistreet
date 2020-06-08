package application;

import core.UserOwnerDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class O_myinfoController {

    @FXML
    private Label ownerID;

    @FXML
    private Label storeName;

    @FXML
    private Label storeAddress;

    @FXML
    private Button editMenuPrice;

    @FXML
    private TableColumn<?, ?> userId;

    @FXML
    private TableColumn<?, ?> reviewStar;

    @FXML
    private TableColumn<?, ?> reviewText;

    @FXML
    private TextField menu1;

    @FXML
    private TextField price1;

    @FXML
    private TextField menu2;

    @FXML
    private TextField menu3;

    @FXML
    private TextField price2;

    @FXML
    private TextField price3;
    
    UserOwnerDAO dao = new UserOwnerDAO();
    
    public void initialize() {
    	ownerID.setText("");
    	
    	
    	storeName.setText("");
    	
    }
    

}