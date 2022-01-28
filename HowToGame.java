import javax.swing.*;
import java.awt.*;
//게임 방법 버튼을 누르면 나오는 프레임
public class HowToGame extends JFrame{
	JLabel gameDescribe, rullTitle;
	public HowToGame() {
		//프레임 사이즈, 레이아웃 설정
		setSize(900, 200);
		setTitle("게임방법 보기");
		setLayout(new GridLayout(2,1));
		//게임 방법 타이틀 설정
		rullTitle = new JLabel("게임 방법");
		rullTitle.setHorizontalAlignment(JLabel.CENTER);
		Font rtF = new Font("맑은 고딕", Font.BOLD, 30);
		rullTitle.setFont(rtF);
		//게임 방법 설명 설정
		gameDescribe = new JLabel("<html>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp왼쪽에 나와 있는 숫자의 순서대로 오른쪽 숫자판에 있는 숫자를 삭제해보세요!<br>"
				+ "   시작 버튼을 누르면 시간이 흘러가기 시작하고, 마지막 숫자를 누르면 시간이 멈추게 됩니다.</html>");
		gameDescribe.setHorizontalAlignment(JLabel.CENTER);
		Font descF = new Font("맑은 고딕", Font.BOLD, 20);
		gameDescribe.setFont(descF);
		//게임 방법 타이틀과 게임 방법 설명 프레임에 부착
		add(rullTitle);
		add(gameDescribe);
		setVisible(true);
	}
	
}
