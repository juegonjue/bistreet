package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PopController {

    @FXML
    private Label message;
    
    
    public void initialize() {
    	if (App.POPSTATE==1) message.setText("���̵�� ��й�ȣ ������ ��ġ���� �ʽ��ϴ�.");
    	else if (App.POPSTATE==2) message.setText("�α׾ƿ� �Ǿ����ϴ�.");
    	else if (App.POPSTATE==3) message.setText("");
    	else message.setText("");
    }
}
