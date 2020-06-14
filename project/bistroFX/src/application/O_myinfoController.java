package application;

import java.sql.SQLException;

import core.MenuPrice;
import core.MenuPriceDAO;
import core.Review;
import core.ReviewDAO;
import core.UserOwnerDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class O_myinfoController {

    @FXML
    private Label id;

    @FXML
    private Label storeName;

    @FXML
    private Label storeAddress;

    @FXML
    private Button editMenuPrice;

    @FXML
    private TableView<Review> reviewTable;
    
    @FXML
    private TableColumn<?, ?> cid;

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
    
    @FXML
    private Button btn_main;
    
    UserOwnerDAO dao = new UserOwnerDAO();
	MenuPriceDAO mdao = new MenuPriceDAO();
	ReviewDAO rdao = new ReviewDAO();
	MenuPrice menuprice;
	String userid = App.logininfo.getId();
    public void initialize() {
    	
    	btn_main.setOnMouseClicked(e->{App.go("main.fxml");});
 
    	
    	/*아이디, 상호명, 도로명주소 set*/
    	id.setText(userid);
    	
    	try {
			storeName.setText(dao.selectStoreName(userid));
	    	storeAddress.setText(dao.selectStoreAddress(userid));

		} catch (SQLException e) {e.printStackTrace();}
    	
    	
    	
    	/*메뉴 리스트 set*/
    	try {
			menuprice = mdao.selectMenuPrice(userid);
		} catch (SQLException e1) {e1.printStackTrace();}
 		
    	menu1.setText(menuprice.getMenu1());
    	menu2.setText(menuprice.getMenu2());
    	menu3.setText(menuprice.getMenu3());
    	price1.setText(String.valueOf(menuprice.getPrice1()));
    	price2.setText(String.valueOf(menuprice.getPrice2()));
    	price3.setText(String.valueOf(menuprice.getPrice3()));
    	
    	
    	
    	/*리뷰 set*/
    	Review[] review = null;
    	int storenum = 0;
    	try {
			storenum = dao.selectStoreNumber(userid);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	System.out.println(storenum);
    	try {
			review = rdao.selectReview(storenum).toArray(new Review[rdao.selectReview(storenum).size()]);
		} catch (SQLException e1) {e1.printStackTrace();}
    	
    	cid.setCellValueFactory(new PropertyValueFactory<>("userId"));
    	reviewStar.setCellValueFactory(new PropertyValueFactory<>("reviewStar"));
    	reviewText.setCellValueFactory(new PropertyValueFactory<>("reviewText"));
    	
    	reviewTable.getItems().addAll(review);
    }
    

}