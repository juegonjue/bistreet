package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Bistor");
        Parent root= FXMLLoader.load(getClass().getResource("root.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene); // ���� ȭ�� ����
        primaryStage.setWidth(1024);       //�������� ���� �� ����
        primaryStage.setHeight(768);      //�������� ���� ���� ����
        primaryStage.setResizable(false);   //������ ũ�⸦ ������ �� ������ ��
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}