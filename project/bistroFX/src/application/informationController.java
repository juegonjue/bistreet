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

   /*�̰� �߰��߾��*/
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
		
		System.out.println("tbset����");
		
		tableset();
    	
	
    
		
		
	}

    public void  handleBtnreview(ActionEvent event) 
    {
    	reviewField.setText(" ");
    	reviewPane.setVisible(true);
    }
    
    

    public void  handleBtninter(ActionEvent event) throws SQLException 
    {
    	System.out.println("�����ѹ�"+storeNumber);
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
			System.out.println("������Ʈ������"+storeNumber+reviewField.getText()+evalbox.getValue()); ///���� ���� �̼��� �������ֱ�
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
		try {	//list�� ��ȯ�� �������� , ui�� �ѷ��ٶ� array�� ���;��ؼ� type casting �Ѱ���. �ʿ�� ���� !
			System.out.println("tbset�߰�"+storeNumber);	
			store = dao.review(storeNumber).toArray(new Store[dao.review(storeNumber).size()]);
			System.out.println(store.length+"tbset��");
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
                	private final Button btndel = new Button("����");
                    private final Button btnchan = new Button("����");
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
                            //UPDATE bistreet.����                            SET ���䳻�� = "chang"   		WHERE �����ȣ = 100002;
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
                    	//�� �α��ξ��̴ٿ� �����ۼ����� ���̵� �ٸ���  
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            
                        } else {
                            
                            System.out.println(reviewtable.getItems().get(this.getIndex()).getID().equals(MainController.USER)+"�̶�� �մϴ�");
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


