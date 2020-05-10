package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("LayOut.fxml"));
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			primaryStage.setTitle("BISTRO");
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		/*
			
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("BISTRO");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			*/
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
