package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PopController {

    @FXML
    private Label message;
    
    public void initialize() {
    	if (App.POPSTATE==1) message.setText("���̵�� ��й�ȣ ������ ��ġ���� �ʽ��ϴ�.");
    	else if (App.POPSTATE==2) message.setText("�α׾ƿ� �Ǿ����ϴ�.");
    	else if (App.POPSTATE==3) message.setText("ȸ������ �Ǿ����ϴ�.");
    	else if (App.POPSTATE==4) message.setText("ȸ�����Կ� �����Ͽ����ϴ�.");
    	else if (App.POPSTATE==5) message.setText("�������� �ʴ� �����Դϴ�.");
    	else if (App.POPSTATE==6) message.setText("�޴����� �����Ǿ����ϴ�.");
    	else if (App.POPSTATE==7) message.setText("�̹� �����ϴ� ���̵��Դϴ�.");
    	else if (App.POPSTATE==8) message.setText("�������� ��ġ�� �����ϰ� ī�װ��� �������ּ���");

    	else message.setText("");
    }
}
