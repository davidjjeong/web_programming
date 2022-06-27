package polymorphism3;

// 다형성 = 상속 + 오버라이딩 + 형변환
public class TVUser {

	public static void main(String[] args) {

		TV tv = (TV) BeanFactory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
