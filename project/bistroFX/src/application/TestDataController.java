package application;

import java.sql.SQLException;
import core.Store;
import core.StoreDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TestDataController {
	
	/* ui �۾� �� ���ǻ��� */
	//1. ���� ��Ʈ�ѷ� �� fxml����, ��ľ����� Meal ī�װ��� ������ ��� ���ɴϴ�
	//2. ���� �ѷ��ִ� ������ �󰡾��ҹ�ȣ�� ��ȣ���Դϴ�. Į������ �� �߰��Ͽ� ��������� ������ �߰��� �� �ֽ��ϴ�.
	//3. Į���� ���� �Ӽ��� �̸��� ��ġ��Ű�°��� ���������� ���� �����ϴ�.

    @FXML
    private TableView<Store> testTable;

    @FXML
    private TableColumn<?, ?> testCol1;

    @FXML
    private TableColumn<?, ?> testCol2;

    public void initialize() {
    	
    	StoreDAO dao = new StoreDAO();
    	Store[] store = null;
		try {	//list�� ��ȯ�� �������� , ui�� �ѷ��ٶ� array�� ���;��ؼ� type casting �Ѱ���. �ʿ�� ���� !
			store = dao.selectAllMeal().toArray(new Store[dao.selectAllMeal().size()]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	testCol1.setCellValueFactory(new PropertyValueFactory<>("storeNumber"));
    	testCol2.setCellValueFactory(new PropertyValueFactory<>("storeName"));
    	
    	testTable.getItems().addAll(store);
    }
}
