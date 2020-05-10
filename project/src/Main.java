
public class Main {

	public static void main extends Application {
		// TODO Auto-generated method stub
		   public void initRootLayout() {
		        try {
		            // fxml 파일에서 상위 레이아웃을 가져온다.
		            FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
		            rootLayout = (BorderPane) loader.load();

		            // 상위 레이아웃을 포함하는 scene을 보여준다.
		            Scene scene = new Scene(rootLayout);
		            primaryStage.setScene(scene);
		            primaryStage.show();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

	}

}
