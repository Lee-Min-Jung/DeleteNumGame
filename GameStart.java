import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class GameStart extends JFrame implements ActionListener{
	static boolean isStopWatch = false;
	static JLabel timeTextLb;
	static String timeText;
	
	JPanel seeNumP, clickNumP;
	JPanel total25Pleft, total25Pright;
	JPanel downControlP, upControlP;
	JPanel resultP;
	JPanel p1, p2,p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15;//빈 패널
	
	JLabel [] numLabArr1 = new JLabel[25];
	JLabel resultTime;
	
	String[] numArr1 = new String[25];
	String[] numArr2 = new String[25];
	
	RoundedButton2 [] numBtnArr2 = new RoundedButton2[25];
	RoundedButton startBtn, resetBtn;
	RoundedButton seeRull;
	
	ArrayList<String> result = new ArrayList<String>();
	
	boolean[] checkNumOrder = new boolean[24];
	
	StopWatch timeThread;
		
	GridBagConstraints gbc, gbc2;
		
	int arrLength1 = numArr1.length;
	int arrLength2 = numArr2.length;
	int checkNumLength = checkNumOrder.length;
	int playCount = 0;
	
	GameStart(){
		//프레임 생성 및 레이아웃 설정
		setSize(600, 500);
		setTitle("이민정의 숫자 지우기 게임");
		setLayout(new GridLayout(1,2));
	
		
		//숫자 보는 패널 생성
		seeNumP = new JPanel();
		seeNumP.setLayout(new GridLayout(1,1));
		
		
		//숫자 나올 패널 생성
		total25Pleft = new JPanel();
		total25Pleft.setLayout(new GridLayout(26,1));
		numLabArr1 = make25numsforL(total25Pleft, numArr1, numLabArr1);
		seeNumP.add(total25Pleft);
	
		add(seeNumP);//전체 프레임에 숫자 보기 패널 부착
		
		//숫자 클릭 패널 생성
		clickNumP = new JPanel();
		clickNumP.setLayout(new GridLayout(3,1));
		
		//위쪽 컨트롤 패널
		upControlP = new JPanel();
		upControlP.setLayout(new GridLayout(4,1));
		seeRull = new RoundedButton("게임 방법");
		Font seeRullF = new Font("맑은 고딕", Font.BOLD, 20);
		seeRull.setFont(seeRullF);
		seeRull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==seeRull) {
					HowToGame seeRullFrame = new HowToGame();
				}
				
			}
		});
		upControlP.add(seeRull);//위쪽 컨트롤 패널에 게임 방법 버튼 부착
		
		//스탑워치
		timeTextLb = new JLabel("0:0:0");
		Font timeF = new Font("돋움", Font.BOLD, 50);
		timeTextLb.setFont(timeF);
		timeTextLb.setHorizontalAlignment(JLabel.CENTER);
		
		upControlP.add(timeTextLb);//위쪽 컨트롤 패널에 스탑워치 부착
		clickNumP.add(upControlP);//숫자 클릭 패널에 위쪽 컨트롤 패널 부착
		
	
		//25개 숫자판 패널
		total25Pright = new JPanel();
		total25Pright.setLayout(new GridLayout(5,5));
		numBtnArr2 = (RoundedButton2[]) make25nums(total25Pright, numArr2, numBtnArr2);

		clickNumP.add(total25Pright);//숫자 클릭 패널에 25개 숫자판 패널 부착
		
		//아래쪽 컨트롤 패널
		downControlP = new JPanel();
		downControlP.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        p1 = new JPanel();//p1~p8은 아래쪽 컨트롤 패널 버튼 배치를 위한 빈 패널
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
        makeP(p1, 0,0,1,1);
        makeP(p2, 1,0,1,1);
        makeP(p3, 2,0,1,1);
        makeP(p4, 0,1,1,1);
        
		startBtn = new RoundedButton("시작");//아래쪽 컨트롤 패널에 들어갈 버튼
		Font conBtnF = new Font("맑은 고딕", Font.BOLD, 20);
		startBtn.setFont(conBtnF);
		 makeBtn(startBtn, 1,1,1,1);
		 makeP(p5, 2,1,1,1);
		 makeP(p6, 0,2,1,1);
		 makeP(p7, 1,2,1,1);
		 makeP(p8, 1,2,1,1);
		 
		//시작과 다시하기 버튼 이벤트
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getActionCommand()=="시작") {//스탑워치 실행 시작 후 버튼 라벨을 다시하기로 바꿈
					isStopWatch = true;
					StopWatch.preTime=System.currentTimeMillis();
					startBtn.setText("다시하기");
				}
				if(e.getActionCommand()=="다시하기") {//스탑워치, 숫자 배열, 숫자판 초기화
					for(int i = 0; i<checkNumLength;i++) {
						checkNumOrder[i] = false;
					}
					total25Pleft.removeAll();
					numLabArr1 = make25numsforL(total25Pleft, numArr1, numLabArr1);
					total25Pright.removeAll();
					numBtnArr2 = (RoundedButton2[]) make25nums(total25Pright, numArr2, numBtnArr2);
					timeTextLb.setText("0:0:0");
					isStopWatch = false;
					StopWatch.preTime=System.currentTimeMillis();
					startBtn.setText("시작");
				}
			}
		});
       
		
		clickNumP.add(downControlP);//숫자 클릭 패널에 아래쪽 컨트롤 패널 부

		add(clickNumP);//전체 프레임에 숫자 클릭 패널 부착
		
		//프레임 보이게 설정
		setVisible(true);
	
		//스탑워치 쓰레드 실행
		timeThread = new StopWatch();
		timeThread.start();
		
		
		
	}
	
	//오른쪽에 나오는 숫자판 배열 생성
	public JButton[] make25nums(JPanel p, String [] numArr,  RoundedButton2 [] numBtnArr) {
		p.setLayout(new GridLayout(5,5));
		//배열에 집어넣기
			for (int i=0;i<25;i++) {
				numArr[i]=Integer.toString(i+1);
			}
		//배열 랜덤으로 섞기
			Random rd = new Random();
			for (int i = 24;i>0;i--) {
				int j = rd.nextInt(i+1);
				String temp = numArr[i];
				numArr[i] = numArr[j];
				numArr[j] = temp;
			}
		//버튼 만들기
			int indexBtn = 0;
			for(int y=0;y<5;y++) {
					for(int x=0;x<5;x++) {
						numBtnArr[indexBtn] = new RoundedButton2(numArr[indexBtn]);
						Font numBtnF = new Font("맑은 고딕", Font.BOLD, 15);
						numBtnArr[indexBtn].setFont(numBtnF);
						p.add(numBtnArr[indexBtn]);
						indexBtn++;
						
					}
				}
			//버튼에 이벤트 설정
			for(int k=0;k<arrLength2;k++) {
				numBtnArr[k].addActionListener(this);
			}
			return numBtnArr;
		}
	//왼쪽에 나오는 숫자 배열 생성
	public JLabel[] make25numsforL(JPanel p, String [] numArr,  JLabel [] numLabArr) {
		
		//배열에 집어넣기
			for (int i=0;i<25;i++) {
				numArr[i]=Integer.toString(i+1);
			}
		//배열 랜덤으로 섞기
			Random rd = new Random();
			for (int i = 24;i>0;i--) {
				int j = rd.nextInt(i+1);
				String temp = numArr[i];
				numArr[i] = numArr[j];
				numArr[j] = temp;
			}
		//라벨 만들기
			int indexBtn = 0;
			for(int y=0;y<5;y++) {
					for(int x=0;x<5;x++) {
						numLabArr[indexBtn] = new JLabel(numArr[indexBtn]);
						Font numLabF = new Font("맑은 고딕", Font.BOLD, 18);
						numLabArr[indexBtn].setFont(numLabF);
						numLabArr[indexBtn].setHorizontalAlignment(JLabel.CENTER);
						p.add(numLabArr[indexBtn]);
						indexBtn++;
						
					}
				}
			
			return numLabArr;
		}
	//버튼 생성 
	public void makeBtn(JButton btn, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        downControlP.add(btn, gbc);
 }
	//패널 생성
	public void makeP(JPanel p, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        downControlP.add(p, gbc);
 }
	//숫자판 숫자 클릭했을 때의 이벤트 - 왼쪽 숫자 배열 순서대로 클릭할 경우 숫자가 사라지고 순서에 맞지 않는 것을 클릭하면 아무 일도 일어나지 않음
		public void actionPerformed(ActionEvent e) {
			if(startBtn.getText()=="시작") {
			}
			else if(e.getActionCommand().equals(numLabArr1[0].getText())) {
				JButton a = (JButton)e.getSource();
				a.setVisible(false);
				numLabArr1[0].setVisible(false);
				checkNumOrder[0] = true;
			}else if(checkNumOrder[0]) {
				if(e.getActionCommand().equals(numLabArr1[1].getText())) {
					JButton b = (JButton)e.getSource();
					b.setVisible(false);
					numLabArr1[1].setVisible(false);
					checkNumOrder[1] = true;
				}else if(checkNumOrder[1]) {
					if(e.getActionCommand().equals(numLabArr1[2].getText())) {
						JButton c = (JButton)e.getSource();
						c.setVisible(false);
						numLabArr1[2].setVisible(false);
						checkNumOrder[2] = true;
					}else if(checkNumOrder[2]) {
						if(e.getActionCommand().equals(numLabArr1[3].getText())) {
							JButton d = (JButton)e.getSource();
							d.setVisible(false);
							numLabArr1[3].setVisible(false);
							checkNumOrder[3] = true;
						}else if(checkNumOrder[3]) {
							if(e.getActionCommand().equals(numLabArr1[4].getText())) {
								JButton ee = (JButton)e.getSource();
								ee.setVisible(false);
								numLabArr1[4].setVisible(false);
								checkNumOrder[4] = true;
							}else if(checkNumOrder[4]) {
								if(e.getActionCommand().equals(numLabArr1[5].getText())) {
									JButton f = (JButton)e.getSource();
									f.setVisible(false);
									numLabArr1[5].setVisible(false);
									checkNumOrder[5] = true;
								}else if(checkNumOrder[5]) {
									if(e.getActionCommand().equals(numLabArr1[6].getText())) {
										JButton g = (JButton)e.getSource();
										g.setVisible(false);
										numLabArr1[6].setVisible(false);
										checkNumOrder[6] = true;
									}else if(checkNumOrder[6]) {
										if(e.getActionCommand().equals(numLabArr1[7].getText())) {
											JButton h = (JButton)e.getSource();
											h.setVisible(false);
											numLabArr1[7].setVisible(false);
											checkNumOrder[7] = true;
										}else if(checkNumOrder[7]) {
											if(e.getActionCommand().equals(numLabArr1[8].getText())) {
												JButton i = (JButton)e.getSource();
												i.setVisible(false);
												numLabArr1[8].setVisible(false);
												checkNumOrder[8] = true;
											}else if(checkNumOrder[8]) {
												if(e.getActionCommand().equals(numLabArr1[9].getText())) {
													JButton j = (JButton)e.getSource();
													j.setVisible(false);
													numLabArr1[9].setVisible(false);
													checkNumOrder[9] = true;
												}else if(checkNumOrder[9]) {
													if(e.getActionCommand().equals(numLabArr1[10].getText())) {
														JButton k = (JButton)e.getSource();
														k.setVisible(false);
														numLabArr1[10].setVisible(false);
														checkNumOrder[10] = true;
													}else if(checkNumOrder[10]) {
														if(e.getActionCommand().equals(numLabArr1[11].getText())) {
															JButton l = (JButton)e.getSource();
															l.setVisible(false);
															numLabArr1[11].setVisible(false);
															checkNumOrder[11] = true;
														}else if(checkNumOrder[11]) {
															if(e.getActionCommand().equals(numLabArr1[12].getText())) {
																JButton m = (JButton)e.getSource();
																m.setVisible(false);
																numLabArr1[12].setVisible(false);
																checkNumOrder[12] = true;
															}else if(checkNumOrder[12]) {
																if(e.getActionCommand().equals(numLabArr1[13].getText())) {
																	JButton n = (JButton)e.getSource();
																	n.setVisible(false);
																	numLabArr1[13].setVisible(false);
																	checkNumOrder[13]= true;
																}else if(checkNumOrder[13]) {
																	if(e.getActionCommand().equals(numLabArr1[14].getText())) {
																		JButton o = (JButton)e.getSource();
																		o.setVisible(false);
																		numLabArr1[14].setVisible(false);
																		checkNumOrder[14] = true;
																	}else if(checkNumOrder[14]) {
																		if(e.getActionCommand().equals(numLabArr1[15].getText())) {
																			JButton p = (JButton)e.getSource();
																			p.setVisible(false);
																			numLabArr1[15].setVisible(false);
																			checkNumOrder[15] = true;
																		}else if(checkNumOrder[15]) {
																			if(e.getActionCommand().equals(numLabArr1[16].getText())) {
																				JButton q = (JButton)e.getSource();
																				q.setVisible(false);
																				numLabArr1[16].setVisible(false);
																				checkNumOrder[16] = true;
																			}else if(checkNumOrder[16]) {
																				if(e.getActionCommand().equals(numLabArr1[17].getText())) {
																					JButton r = (JButton)e.getSource();
																					r.setVisible(false);
																					numLabArr1[17].setVisible(false);
																					checkNumOrder[17] = true;
																				}else if(checkNumOrder[17]) {
																					if(e.getActionCommand().equals(numLabArr1[18].getText())) {
																						JButton s = (JButton)e.getSource();
																						s.setVisible(false);
																						numLabArr1[18].setVisible(false);
																						checkNumOrder[18] = true;
																					}else if(checkNumOrder[18]) {
																						if(e.getActionCommand().equals(numLabArr1[19].getText())) {
																							JButton t = (JButton)e.getSource();
																							t.setVisible(false);
																							numLabArr1[19].setVisible(false);
																							checkNumOrder[19] = true;
																						}else if(checkNumOrder[19]) {
																							if(e.getActionCommand().equals(numLabArr1[20].getText())) {
																								JButton u = (JButton)e.getSource();
																								u.setVisible(false);
																								numLabArr1[20].setVisible(false);
																								checkNumOrder[20] = true;
																							}else if(checkNumOrder[20]) {
																								if(e.getActionCommand().equals(numLabArr1[21].getText())) {
																									JButton v = (JButton)e.getSource();
																									v.setVisible(false);
																									numLabArr1[21].setVisible(false);
																									checkNumOrder[21] = true;
																								}else if(checkNumOrder[21]) {
																									if(e.getActionCommand().equals(numLabArr1[22].getText())) {
																										JButton w = (JButton)e.getSource();
																										w.setVisible(false);
																										numLabArr1[22].setVisible(false);
																										checkNumOrder[22] = true;
																									}else if(checkNumOrder[22]) {
																										if(e.getActionCommand().equals(numLabArr1[23].getText())) {
																											JButton x = (JButton)e.getSource();
																											x.setVisible(false);
																											numLabArr1[23].setVisible(false);
																											checkNumOrder[23] = true;
																										}else if(checkNumOrder[23]) {
																											if(e.getActionCommand().equals(numLabArr1[24].getText())) {//마지막 순서의 숫자 클릭  
																												JButton y = (JButton)e.getSource();
																												y.setVisible(false);
																												numLabArr1[24].setVisible(false);
																												//스탑워치 멈추고 숫자판 패널에 결과 보여줌
																												isStopWatch = false;
																													playCount+=1;
																													result.add(timeTextLb.getText());
																													Collections.sort(result);
																													total25Pright.setLayout(new FlowLayout());
																													for(int i = 1;i<playCount+1;i++) {
																														resultTime = new JLabel(" "+ i+"위 "+result.get(i-1));
																												
																														Font resultF = new Font("맑은 고딕", Font.BOLD, 20);
																														resultTime.setFont(resultF);
																														
																														total25Pright.add(resultTime);
																													}		
																												
																									
																												
																														
																											}
																											
																										}
																										
																										
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
									
		}
			
					 
		}

}
