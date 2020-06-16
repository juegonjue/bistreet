package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import core.InterestDAO;
import core.MenuPrice;
import core.MenuPriceDAO;
import core.Review;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

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
   @FXML private TableColumn<?,?> buttoncol;
   @FXML private Button btncancle;
   @FXML private Button btninter;

   /*이거 추가했어요*/
   @FXML private TextField mp1, mp2, mp3;
   @FXML private Label category;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		main.setOnMouseClicked(e->App.go("main.fxml"));
		btnreview.setOnAction(e->handleBtnreview(e));
		btncancle.setOnAction(e->handleBtncancle(e));
		save.setOnAction(e->handleBtnsave(e));
		reviewPane.setVisible(false);
		btninter.setOnAction(e->{
			try {
				handleBtninter(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		tableset();
		addButtonToTable();
		

	



	}
	
	public void setData(String data,Integer integer)
	{

		storeName.setText(data);
		storeNumber=integer;
		
		System.out.println("tbset시작");
		
		tableset();
    	
	
    
		
		
	}

    public void  handleBtnreview(ActionEvent event) 
    {
    	reviewField.setText(" ");
    	reviewPane.setVisible(true);
    }
    
    

    public void  handleBtninter(ActionEvent event) throws SQLException 
    {
    	System.out.println("스토어넘버"+storeNumber);
    	InterestDAO IDAO = new InterestDAO();
    	IDAO.addInterest(storeNumber.toString());
    }
    public void  handleBtncancle(ActionEvent event) 
    {
    	
    	reviewPane.setVisible(false);
    }
    
    public void  handleedit(ActionEvent event,Integer Num,String review,String eval) throws SQLException 
    {
    	
    	StoreDAO dao = new StoreDAO();
    	dao.Editreview(Num, review, eval);
    	
    	save.setOnAction(e->handleBtnsave(e));
    	reviewtable.getItems().clear();
    	tableset();
    	reviewPane.setVisible(false);
    }
    
    
    public void  handleBtnsave(ActionEvent event) 
    {
    	
    	StoreDAO dao= new StoreDAO();
    	try {
			dao.updatereview(storeNumber, reviewField.getText(), evalbox.getValue().toString());
			System.out.println("업데이트할정보"+storeNumber+reviewField.getText()+evalbox.getValue()); ///여기 평점 미선택 경고문띄워주기
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
		try {	//list로 반환된 값이지만 , ui에 뿌려줄땐 array로 들고와야해서 type casting 한것임. 필요시 참고 !
			System.out.println("tbset중간"+storeNumber);	
			store = dao.review(storeNumber).toArray(new Store[dao.review(storeNumber).size()]);
			System.out.println(store.length+"tbset중");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		id.setCellValueFactory(new PropertyValueFactory<>("ID"));
		review.setCellValueFactory(new PropertyValueFactory<>("review"));
		eval.setCellValueFactory(new PropertyValueFactory<>("eval"));
		
		
		
		
		reviewtable.getItems().addAll(store);
    }
    
    

    
    private void addButtonToTable() {
        TableColumn<Store, Void> colBtn = new TableColumn("Button Column");

        Callback<TableColumn<Store, Void>, TableCell<Store, Void>> cellFactory = new Callback<TableColumn<Store, Void>
        , TableCell<Store, Void>>() {
            @Override
            public TableCell<Store, Void> call(final TableColumn<Store, Void> param) {
                final TableCell<Store, Void> cell = new TableCell<Store, Void>() {
                	private final Button btndel = new Button("삭제");
                    private final Button btnchan = new Button("수정");
                    private final HBox hpane = new HBox(btndel,btnchan);
                    
           

                    {
                        btndel.setOnAction((ActionEvent event) -> {
                        	StoreDAO dao = new StoreDAO();
                        	try {
								dao.delreview(reviewtable.getItems().get(this.getIndex()).getReviewNum());
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                			reviewtable.getItems().clear();
                			tableset();
                            System.out.println("delbtn");
                        });
                        
                        btnchan.setOnAction((ActionEvent event) -> {
                            int reviewindex =this.getIndex();
                            
                            System.out.println("chabtn");
                            //mealtable.getSelectionModel().getSelectedItem().getkDegree()
                            reviewPane.setVisible(true);
                            reviewField.requestFocus();
                            //UPDATE bistreet.리뷰                            SET 리뷰내용 = "chang"   		WHERE 리뷰번호 = 100002;
                            reviewField.setText(reviewtable.getItems().get(reviewindex).getReview());
                            System.out.println(reviewtable.getItems().get(reviewindex).getReviewNum());
                            reviewtable.getItems().get(reviewindex).getEval();
                           
                         
                            save.setOnAction(e->{
								try {
									handleedit(e, reviewtable.getItems().get(reviewindex).getReviewNum(), reviewField.getText(),
											reviewtable.getItems().get(reviewindex).getEval().toString());
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							});
                            
                            
                            
                            
                            
                        });
                    }
                    	//내 로그인아이다와 리뷰작성자의 아이디가 다르면  
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            
                        } else {
                            
                            System.out.println(reviewtable.getItems().get(this.getIndex()).getID().equals(MainController.USER)+"이라고 합니다");
                            if(reviewtable.getItems().get(this.getIndex()).getID().equals(MainController.USER))
                            		{
                            	setGraphic(hpane);
                            		}
                            else {
                            	setGraphic(null);	
                            }
                            
                           
                        }
                    }
                };
                return cell;
            }
        };

       
        colBtn.setCellFactory(cellFactory);
        reviewtable.getColumns().add(colBtn);
        

    }
    
    
    
    
	
}


