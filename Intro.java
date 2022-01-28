import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Intro implements ActionListener {
	JFrame introFrame;
	JLabel gameTitleL;
	RoundedButton gameStart, howToGame;
	JPanel gameTitleP, btnP;
	JPanel p1, p2, p3,p4;//빈 패널
	GridBagConstraints gbc;
	
	public Intro() {
		//프레임 생성 후 크기와 레이아웃 설정
		introFrame = new JFrame("이민정의 숫자 지우기 게임");
		introFrame.setSize(600,400);
		introFrame.setLayout(new GridLayout(3,1));
		p1 = new JPanel();//p1은 빈 패널로 introFrame의 배치를 위해 부착
		introFrame.add(p1);
		//게임 타이틀 패널 생성 후 게임 타이틀 라벨을 패널에 부착하고 게임 타이틀 패널을 프레임에 부착
		gameTitleP = new JPanel();
		gameTitleL = new JLabel("숫자 지우기 게임");
		gameTitleL.setHorizontalAlignment(JLabel.CENTER);
		Font titleF = new Font("맑은 고딕", Font.BOLD, 40);
		gameTitleL.setFont(titleF);
		gameTitleP.add(gameTitleL);
		introFrame.add(gameTitleP);
		//버튼 패널 생성 
		btnP = new JPanel();
		btnP.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        //버튼의 배치를 위하여 빈 패널과 게임 시작 버튼, 게임 방법 버튼을 만들고 버튼 패널에 부착
        p2 = new JPanel();
        makeP(p2, 0,0,1,1);
        Font btnF = new Font("맑은 고딕", Font.BOLD, 20);
		gameStart = new RoundedButton("게임 시작");
		gameStart.setFont(btnF);
		makeBtn(gameStart, 1,0,1,1);
		gameStart.addActionListener(this);
		p3 = new JPanel();
		makeP(p3, 2,0,1,1);
		howToGame = new RoundedButton("게임 방법");
		howToGame.setFont(btnF);
		makeBtn(howToGame, 3,0,1,1);
		howToGame.addActionListener(this);
		p4 = new JPanel();
		makeP(p4, 4,0,1,1);
		//프레임에 버튼 패널 부착
		introFrame.add(btnP);
		//프레임 보이게 설정
		introFrame.setVisible(true);
		
	}
	//게임 시작 버튼과 게임 방법 보기 버튼의 이벤트
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
	//버튼 생성과 패널 생성 함수 
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
