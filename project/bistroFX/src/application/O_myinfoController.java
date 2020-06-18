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
    
    @FXML
    private Label idid;
    
    UserOwnerDAO dao = new UserOwnerDAO();
	String userid = App.logininfo.getId();
	
	String storename="";
	int storenumber=0;
	String storeaddress="";
	String ownername="";
	
    public void initialize() {
    	
    	btn_main.setOnMouseClicked(e->{App.go("main.fxml");});

		try {
			storename = dao.selectStoreName(userid);
			storenumber = dao.selectStoreNumber(userid);
			storeaddress = dao.selectStoreAddress(userid);
			ownername = dao.selectownerName(userid);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

    	
    	/*아이디, 상호명, 도로명주소 set*/
    	id.setText(ownername);
    	idid.setText(userid);
		storeName.setText(storename);
	    storeAddress.setText(storeaddress);
    	
    	
    	/*메뉴 리스트 set*/
    	try {
    		MenuPriceDAO mdao = new MenuPriceDAO();

    		MenuPrice menuprice;
			menuprice = mdao.selectMenuPrice(userid);
			
			
			if (mdao.hasMenu(storenumber)==false) {
				menu1.setText(null);
		    	menu2.setText(null);
		    	menu3.setText(null);
		    	price1.setText(null);
		    	price2.setText(null);
		    	price3.setText(null);
			}
			else {
				menu1.setText(menuprice.getMenu1());
		    	menu2.setText(menuprice.getMenu2());
		    	menu3.setText(menuprice.getMenu3());
		    	price1.setText(String.valueOf(menuprice.getPrice1()));
		    	price2.setText(String.valueOf(menuprice.getPrice2()));
		    	price3.setText(String.valueOf(menuprice.getPrice3()));
			}
		} catch (SQLException e1) {e1.printStackTrace();}    	
    	
    	
    	/*리뷰 set*/
    	Review[] review = null;

    	try {
    		ReviewDAO rdao = new ReviewDAO();
			review = rdao.selectReview(storenumber).toArray(new Review[rdao.selectReview(storenumber).size()]);
		} catch (SQLException e1) {e1.printStackTrace();}
    	
    	cid.setCellValueFactory(new PropertyValueFactory<>("userId"));
    	reviewStar.setCellValueFactory(new PropertyValueFactory<>("reviewStar"));
    	reviewText.setCellValueFactory(new PropertyValueFactory<>("reviewText"));
    	
    	reviewTable.getItems().addAll(review);
    	

    	editMenuPrice.setOnMouseClicked(e->{
    		MenuPriceDAO dao = new MenuPriceDAO();
			int rs_cnt;
			try {
				rs_cnt = dao.updateMenuPrice(storenumber, menu1.getText(), Integer.parseInt(price1.getText()), menu2.getText(),Integer.parseInt(price2.getText()), menu3.getText(), Integer.parseInt(price3.getText()));
				if (rs_cnt==1) {
					App.POPSTATE=6;
					App.pop("pop.fxml");
				}
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

    	});
    }
    

}