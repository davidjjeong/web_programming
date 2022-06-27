package polymorphism3;

// Factory 패턴 적용
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
