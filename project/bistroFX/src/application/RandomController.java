package application;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class RandomController {
	
    @FXML
    private Label category;

    @FXML
    private ComboBox<String> comboBoxcat;

    @FXML
    private Label submenu;

    @FXML
    private Button btn_ok;

    @FXML
    private Button btn_back;


    int cate = MainController.CATEGORY;	//1:�Ļ� 2:����Ʈ 3:����
    ObservableList<String> subcat;
    String[] sub;
	public void initialize() {
		
		if (cate==1) {
			subcat = FXCollections.observableArrayList("�ѽ�","�߽�","�Ͻ�","�н�","���","��Ÿ","����");
		}
		
		else if (cate==2) {
			subcat = FXCollections.observableArrayList("��������","��������������","ī��");

		}
		else if (cate==3) {
			subcat= FXCollections.observableArrayList("����");
		}
		
		comboBoxcat.setItems(subcat);
		
		btn_ok.setOnMouseClicked(e->{
			
			if (cate==1) {
				if (comboBoxcat.getValue().equals("�ѽ�")) {
					sub = new String[]{"�ѽ�","����","����","��â","�籸��","������","���屹","���ܺ����","�δ��","����","����","������","�ӹ�","�κο丮","��ø��","����","�߾���",
							"���κ�","������","�����丮","Ȳ��","�ø�","���Ĵ�","���ű��","�ع���","�Ʊ���","�ι����","�ſ���","��������","�ٴ尡��","��ġ","����","��¡��","�����","����","��","����","ȫ��","����",
							"�����","�߰���","�ߵ�����","���","�Ҵ�","�̴�","������","ġŲ","�������","�߹�","��","ǻ���丮","����"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else if (comboBoxcat.getValue().equals("�߽�")) {
					sub = new String[] {"¥���","������","«��","��ǳ��","�߳��쵿","��¥��","������","������","������"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else if (comboBoxcat.getValue().equals("�Ͻ�")) {
					sub = new String[] {"ȸ","��ġ","�ʹ�","�������","ö�ǿ丮"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}		
				else if (comboBoxcat.getValue().equals("�н�")) {
					sub =  new String[] {"���","���","����","����","Į����","������","�쵿"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}	
				else if (comboBoxcat.getValue().equals("���")) {
					sub = new String[] {"���","ī��","���İ�Ƽ","�йи��������","�ٺ�ť","������ũ","����","���ö�"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else if (comboBoxcat.getValue().equals("��Ÿ")) {
					sub = new String[] {"�ұ���","��ö��"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else {
					sub = new String[] {"���պ���","������","�ѽĺ���","ä�ĺ���","�ع�����"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
			}
			
			else if (cate==2) {
				if (comboBoxcat.getValue().equals("��������")) {
					sub = new String[] {"�ֵ���","������","���̽�ũ��","����վ��̽�ũ��","������","�佺Ʈ"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else if (comboBoxcat.getValue().equals("��������������")) {
					sub = new String[] {"��","����ũ","��","�Ѱ�","��"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
				else {
					sub = new String[] {"Ŀ��","�������ֽ�","�������ī��","����ī��","��������","�ְ�ī��"};
					int which = (int) (Math.random()*(sub.length));
					submenu.setText(sub[which]);
				}
			}
			
			else {
				sub = new String[] {"ȣ����", "���帶��", "��ġ����","�μ�����","�ιٴپ߳�","bar","��ī��","��������"};
				int which = (int) (Math.random()*(sub.length));
				submenu.setText(sub[which]);
			}
		});
		
    	if (MainController.CATEGORY==1) category.setText("�Ļ�");
    	else if (MainController.CATEGORY==2) category.setText("����Ʈ");
    	else category.setText("����");
		
		btn_back.setOnMouseClicked(e->App.go("category.fxml"));
	  	btn_ok.setOnAction(e->handlebtncat(e));
		
	  	
	  	
	}
		
	
	public void  handlebtncat(ActionEvent event) 
	{
		System.out.println(comboBoxcat.getValue());
		
	}
	
}
