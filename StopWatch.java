//스탑워치 쓰레드
class StopWatch extends Thread{
	static String timeText;
    long time = 0l; static long preTime = 1;    
    boolean play = true;
        //thread 클래스 안에 있는 메서드
    public void run() {
    	while(play) {
    		try {
    			sleep(10);
    			//시작 버튼을 누를 경우 활성화되는 부분
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
