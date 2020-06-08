package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
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
	
	
	//로그인 상태관리
	public static LoginInfo logstate = new LoginInfo(true,"bis12");
    public static void main(String[] args) {
//      try {
//			DBManager db = new DBManager();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    
      launch(args); 
  }
    @Override
    public void start(Stage stage) throws IOException {
//        Parent root= FXMLLoader.load(getClass().getResource("main.fxml"));
//        primaryStage.setScene(new Scene(root)); // 메인 화면 설정
//        primaryStage.setTitle("Bistreet");
//        primaryStage.show();
//    }
    	
		App.stage = stage;
		root = new Pane();
		go("DataTest.fxml");
		stage.setScene(new Scene(root));
		stage.show();
	}

	public static void logout() {
		App.go("app/login.fxml");
	}
	

    
	// 화연 이동하는 메소드
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
	// 팝업 창을 띄우는 메소드
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
			popStage.initStyle(StageStyle.UNDECORATED);
			popStage.showAndWait();
		} catch (IOException e) {
			System.err.println("pop 에러");
			e.printStackTrace();
		}
		
	}
}
