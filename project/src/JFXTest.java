import javax.swing.*;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class JFXTest extends JFrame {
	public JFXTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JFXPanel fxPanel = new JFXPanel();
		add(fxPanel);
		
		Platform.runLater(new Runnable() {

			public void run() {

				initAndLoadWebView(fxPanel);

			}

		});
		
		setVisible(true);
	}
	
	private static void initAndLoadWebView(final JFXPanel fxPanel) {
		Group group = new Group();
		Scene scene = new Scene(group);
		fxPanel.setScene(scene);

		WebView webView = new WebView();

		group.getChildren().add(webView);
		webView.setMinSize(500, 500);
		webView.setMaxSize(500, 500);
		
		WebEngine webEngine = webView.getEngine();
		webEngine.setJavaScriptEnabled(true);
		//������
		webEngine.load("https://dean7347.github.io/BistroMap/map");
		//����
		//webEngine.load("http://127.0.0.1:5500/map.html");
		webEngine.reload();
			//webEngine.executeScript("markPosition('������°',33.953705, 126.570677)");
			//webEngine.executeScript("test()");
		
		
		//�׽�Ʈ
		//webEngine.load("https://naver.com");
		//�ε�üũ
		//System.out.println(webEngine.getLoadWorker().stateProperty());
		
	
		
		 	webEngine.getLoadWorker().stateProperty().addListener(
			    new ChangeListener() {
			        @Override
			        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
			            System.out.println("oldValue: " + oldValue);
			            System.out.println("newValue: " + newValue);

			            if (newValue != Worker.State.SUCCEEDED) {
		
			                return;
			            }
			            
			            
			            
			            if (newValue == Worker.State.SUCCEEDED) {
			                //markPosiont ����ִ� �Լ��Դϴ�
			            	//webEngine.executeScript("markPosition('������°',33.953705, 126.570677)");
			            	webEngine.executeScript("insertMarkInfo('īī��',33.450705, 126.570677)");
			            	webEngine.executeScript("insertMarkInfo('���¿���',33.450936, 126.569477)");
			            	webEngine.executeScript("mark()");
			            	
			                return;
			            }
			            //webEngine.reload();

			           
			        
			        }
			    }
			);
		 
		

		
		
	
		           
	
	}
	
	public static void main(String[] args) {
		new JFXTest();
		
		
	}
}