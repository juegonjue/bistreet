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
    		
    		//���̵�, ��й�ȣ ��ġ Ȯ�� �� �α��οϷ�. ���� �ٷ� mainâ���� �Ѿ�� ����
    		
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
//            login.setTranslateX(0); // ���۰��� 0���� ����
//            
//            Timeline timeline = new Timeline();
//            KeyValue keyValue = new KeyValue(login.translateXProperty(), 350); // ���ᰪ�� 350���� �����ϰ� 
//            KeyFrame keyFrame = new KeyFrame(
//                Duration.millis(100), // 0.1�ʰ� �ִϸ��̼� ����
//                new EventHandler<ActionEvent>() { // �ִϸ��̼��� ����Ǹ� handle() �޼ҵ尡 �ڵ� ȣ���
//                    @Override
//                    public void handle(ActionEvent event) {
//                        root.getChildren().remove(login); // StackPane���� �α��� ȭ�� ����
//                    }                                     // �ִϸ��̼� ���� �� �α��� ȭ�� ����
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