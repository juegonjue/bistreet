
public class Main {

	public static void main extends Application {
		// TODO Auto-generated method stub
		   public void initRootLayout() {
		        try {
		            // fxml ���Ͽ��� ���� ���̾ƿ��� �����´�.
		            FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
		            rootLayout = (BorderPane) loader.load();

		            // ���� ���̾ƿ��� �����ϴ� scene�� �����ش�.
		            Scene scene = new Scene(rootLayout);
		            primaryStage.setScene(scene);
		            primaryStage.show();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

	}

}
