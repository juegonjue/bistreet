package application;

import java.sql.SQLException;
import core.Store;
import core.StoreDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TestDataController {
	
	/* ui 작업 시 유의사항 */
	//1. 예시 컨트롤러 및 fxml으로, 요식업소의 Meal 카테고리의 상점만 모두 들고옵니다
	//2. 현재 뿌려주는 값들은 상가업소번호와 상호명입니다. 칼럼들을 더 추가하여 들고오고싶은 값들을 추가할 수 있습니다.
	//3. 칼럼은 들고올 속성의 이름과 매치시키는것이 유지보수를 위해 좋습니다.

    @FXML
    private TableView<Store> testTable;

    @FXML
    private TableColumn<?, ?> testCol1;

    @FXML
    private TableColumn<?, ?> testCol2;

    public void initialize() {
    	
    	StoreDAO dao = new StoreDAO();
    	Store[] store = null;
		try {	//list로 반환된 값이지만 , ui에 뿌려줄땐 array로 들고와야해서 type casting 한것임. 필요시 참고 !
			store = dao.selectAllMeal().toArray(new Store[dao.selectAllMeal().size()]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	testCol1.setCellValueFactory(new PropertyValueFactory<>("storeNumber"));
    	testCol2.setCellValueFactory(new PropertyValueFactory<>("storeName"));
    	
    	testTable.getItems().addAll(store);
    }
}
