package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class LoginController {

    @FXML
    private TextArea id;

    @FXML
    private TextArea pw;

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_back;

    public void initialize() {
    	
    	btn_login.setOnMouseClicked(e->{
    		
    		//아이디, 비밀번호 일치 확인 후 로그인완료. 이후 바로 main창으로 넘어가게 세팅
    		
    	});
    	
    	btn_back.setOnMouseClicked(e->{
    		App.go("main.fxml");
    	});
    	
    }
    
    
    
}

//public class LoginController implements Initializable {
//    @FXML private BorderPane login;
//    @FXML private Button btnMain;
//    
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        btnMain.setOnAction(e->handleBtnMain(e));
//    }
//    
//    public void handleBtnMain(ActionEvent event) {
//        try {
//            StackPane root = (StackPane) btnMain.getScene().getRoot();
//            
//            login.setTranslateX(0); // 시작값을 0으로 설정
//            
//            Timeline timeline = new Timeline();
//            KeyValue keyValue = new KeyValue(login.translateXProperty(), 350); // 종료값을 350으로 설정하고 
//            KeyFrame keyFrame = new KeyFrame(
//                Duration.millis(100), // 0.1초간 애니메이션 실행
//                new EventHandler<ActionEvent>() { // 애니메이션이 종료되면 handle() 메소드가 자동 호출됨
//                    @Override
//                    public void handle(ActionEvent event) {
//                        root.getChildren().remove(login); // StackPane에서 로그인 화면 제거
//                    }                                     // 애니메이션 종료 후 로그인 화면 제거
//                }, 
//                keyValue
//            );
//            timeline.getKeyFrames().add(keyFrame);
//            timeline.play();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//}