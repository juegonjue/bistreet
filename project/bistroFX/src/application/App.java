package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
	public static Object handle;
	public static String apath = "admin/view/", spath = "student/view/";
	@FXML 
	public static Pane root;
	@FXML 
	public static Stage stage;
	
	
	//�α��� ���°���
	public static LoginInfo logininfo = new LoginInfo();
	public static int POPSTATE = 0;	//1:�α��ν���, 2:�α׾ƿ��ȳ� , ...
	
    public static void main(String[] args) { 
    	launch(args); 
  }
    @Override
    public void start(Stage stage) throws IOException {

		App.stage = stage;
		root = new Pane();
		go("main.fxml");
		//go("DataTest.fxml");
		stage.setScene(new Scene(root));
		stage.show();
	}

	public static void logout() {
		App.go("app/login.fxml");
	}
   
	// ȭ�� �̵��ϴ� �޼ҵ�
	public static void goFade(String fxml) {
		go(fxml);
	}
	public static void go(String fxml) {
		try {
			Parent scene = FXMLLoader.load(App.class.getResource(fxml));
			root.getChildren().removeAll();
			root.getChildren().setAll(scene);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	// �˾� â�� ���� �޼ҵ�
	public static void pop(String fxml) {
		try {
			Stage popStage = new Stage();
			popStage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
			        if (KeyCode.ESCAPE == event.getCode())
			        	popStage.close();
			 });
			Pane pop = new Pane();
			Parent scene = FXMLLoader.load(App.class.getResource(fxml));
			pop.getChildren().setAll(scene);
			popStage.setScene(new Scene(pop));
			popStage.initModality(Modality.APPLICATION_MODAL);
			popStage.showAndWait();
		} catch (IOException e) {
			System.err.println("pop ����");
			e.printStackTrace();
		}
		
	}

}
