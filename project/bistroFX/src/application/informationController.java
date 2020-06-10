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
   private String info;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		main.setOnMouseClicked(e->App.go("main.fxml"));
		btnreview.setOnAction(e->handleBtnreview(e));
		

	}
	
	public void setData(String data)
	{
		info=data;
		System.out.println("받았다니까용");
		storeName.setText("dd");
		
	}

    public void  handleBtnreview(ActionEvent event) 
    {
    	storeName.setText("aa");
    	System.out.println("init"+info);
    }

	

}


