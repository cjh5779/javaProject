package threads.extendsthread;

import java.awt.Toolkit;

// Thread 클래스를 상속받은 하위 클래스
public class WorkerThread extends Thread {
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // 현재 시스템의 기본설정된 자원을 반환
		
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (Exception e) {

			}
		}
	}
}
