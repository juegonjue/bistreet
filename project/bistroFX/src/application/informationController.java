package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import core.Store;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

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
   private String storeNumber;
   


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		main.setOnMouseClicked(e->App.go("main.fxml"));
		btnreview.setOnAction(e->handleBtnreview(e));
		save.setOnAction(e->handleBtnsave(e));
		reviewPane.setVisible(false);

	}
	
	public void setData(String data,Integer integer)
	{

		storeName.setText(data);
		System.out.println (integer);

		
		
	}

    public void  handleBtnreview(ActionEvent event) 
    {
    	
    	reviewPane.setVisible(true);
    }
    
    public void  handleBtnsave(ActionEvent event) 
    {
    	
    	reviewPane.setVisible(false);
    }

	

}


