package polymorphism3;

// ������ = ��� + �������̵� + ����ȯ
public class TVUser {

	public static void main(String[] args) {

		TV tv = (TV) BeanFactory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
