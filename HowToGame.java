import javax.swing.*;
import java.awt.*;
//���� ��� ��ư�� ������ ������ ������
public class HowToGame extends JFrame{
	JLabel gameDescribe, rullTitle;
	public HowToGame() {
		//������ ������, ���̾ƿ� ����
		setSize(900, 200);
		setTitle("���ӹ�� ����");
		setLayout(new GridLayout(2,1));
		//���� ��� Ÿ��Ʋ ����
		rullTitle = new JLabel("���� ���");
		rullTitle.setHorizontalAlignment(JLabel.CENTER);
		Font rtF = new Font("���� ���", Font.BOLD, 30);
		rullTitle.setFont(rtF);
		//���� ��� ���� ����
		gameDescribe = new JLabel("<html>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp���ʿ� ���� �ִ� ������ ������� ������ �����ǿ� �ִ� ���ڸ� �����غ�����!<br>"
				+ "   ���� ��ư�� ������ �ð��� �귯���� �����ϰ�, ������ ���ڸ� ������ �ð��� ���߰� �˴ϴ�.</html>");
		gameDescribe.setHorizontalAlignment(JLabel.CENTER);
		Font descF = new Font("���� ���", Font.BOLD, 20);
		gameDescribe.setFont(descF);
		//���� ��� Ÿ��Ʋ�� ���� ��� ���� �����ӿ� ����
		add(rullTitle);
		add(gameDescribe);
		setVisible(true);
	}
	
}
