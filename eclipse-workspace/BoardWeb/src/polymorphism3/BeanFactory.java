package polymorphism3;

// Factory ���� ����
public class BeanFactory {

	public static Object getBean(String id) {
		if(id.equals("samsung")) {
			return new SamsungTV();
		} else if(id.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
}
