import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Intro implements ActionListener {
	JFrame introFrame;
	JLabel gameTitleL;
	RoundedButton gameStart, howToGame;
	JPanel gameTitleP, btnP;
	JPanel p1, p2, p3,p4;//�� �г�
	GridBagConstraints gbc;
	
	public Intro() {
		//������ ���� �� ũ��� ���̾ƿ� ����
		introFrame = new JFrame("�̹����� ���� ����� ����");
		introFrame.setSize(600,400);
		introFrame.setLayout(new GridLayout(3,1));
		p1 = new JPanel();//p1�� �� �гη� introFrame�� ��ġ�� ���� ����
		introFrame.add(p1);
		//���� Ÿ��Ʋ �г� ���� �� ���� Ÿ��Ʋ ���� �гο� �����ϰ� ���� Ÿ��Ʋ �г��� �����ӿ� ����
		gameTitleP = new JPanel();
		gameTitleL = new JLabel("���� ����� ����");
		gameTitleL.setHorizontalAlignment(JLabel.CENTER);
		Font titleF = new Font("���� ���", Font.BOLD, 40);
		gameTitleL.setFont(titleF);
		gameTitleP.add(gameTitleL);
		introFrame.add(gameTitleP);
		//��ư �г� ���� 
		btnP = new JPanel();
		btnP.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        //��ư�� ��ġ�� ���Ͽ� �� �гΰ� ���� ���� ��ư, ���� ��� ��ư�� ����� ��ư �гο� ����
        p2 = new JPanel();
        makeP(p2, 0,0,1,1);
        Font btnF = new Font("���� ���", Font.BOLD, 20);
		gameStart = new RoundedButton("���� ����");
		gameStart.setFont(btnF);
		makeBtn(gameStart, 1,0,1,1);
		gameStart.addActionListener(this);
		p3 = new JPanel();
		makeP(p3, 2,0,1,1);
		howToGame = new RoundedButton("���� ���");
		howToGame.setFont(btnF);
		makeBtn(howToGame, 3,0,1,1);
		howToGame.addActionListener(this);
		p4 = new JPanel();
		makeP(p4, 4,0,1,1);
		//�����ӿ� ��ư �г� ����
		introFrame.add(btnP);
		//������ ���̰� ����
		introFrame.setVisible(true);
		
	}
	//���� ���� ��ư�� ���� ��� ���� ��ư�� �̺�Ʈ
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==howToGame) {
			HowToGame seeHowGame = new HowToGame();
		}
		else if(e.getSource()==gameStart) {
			introFrame.setVisible(false);
			GameStart seeGameStart = new GameStart();
		}
	}
	//��ư ������ �г� ���� �Լ� 
	public void makeBtn(JButton btn, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        btnP.add(btn, gbc);
 }
	public void makeP(JPanel p, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        btnP.add(p, gbc);
 }
	
}
