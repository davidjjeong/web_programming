package polymorphism2;

// 다형성 = 상속 + 오버라이딩 + 형변환
public class TVUser {

	public static void main(String[] args) {
		TV tv = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
