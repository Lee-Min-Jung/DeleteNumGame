//��ž��ġ ������
class StopWatch extends Thread{
	static String timeText;
    long time = 0l; static long preTime = 1;    
    boolean play = true;
        //thread Ŭ���� �ȿ� �ִ� �޼���
    public void run() {
    	while(play) {
    		try {
    			sleep(10);
    			//���� ��ư�� ���� ��� Ȱ��ȭ�Ǵ� �κ�
      			if(GameStart.isStopWatch) {
       				time=System.currentTimeMillis()-preTime;
    				int m=(int)(time/1000.0/60.0);
    				int s=(int)(time%(1000.0*60)/1000.0);
    				int ms=(int)(time%1000/10.0);
    				timeText=m+":"+s+":"+ms;
    				GameStart.timeTextLb.setText(timeText);
    			}
  
    		}catch(InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
}
