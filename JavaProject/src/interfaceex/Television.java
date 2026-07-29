package interfaceex;

public class Television implements IRemoteControl {

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
		
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("현재 Audio 볼륨 : " + volume);
		
	}
	
}
