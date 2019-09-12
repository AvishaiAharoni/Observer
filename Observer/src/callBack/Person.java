package callBack;

//import java.lang.reflect.Method;

public class Person<E> {
	CallBackStandart<Person<E>, E> callBackFunction;
	String name;
	int premium_flag;

	Person(String name) { 
		this.name = name; 
	}
	
	public void subscribeMe(String nameOfNotifyMethod, Dispatcher<E> d) {	
		try {
			callBackFunction = new CallBackStandart<>(this, nameOfNotifyMethod);
			d.subscribe(this.callBackFunction);

		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	public void unSubscribeMe(Dispatcher<E> d) {
		d.unSubscribe(this.callBackFunction);
	}
	
	public void notifyMe(Object e) {
		System.out.println(name + " was notified with the event : " + e );
	}	

	public void notifyMeAsPremium(Object e) {
		System.out.println(name + " was notified ,as premium costumer, the event : " + e );
		
		if (premium_flag == 0) {
			System.out.println(name + " welcome, you get a voucher of 1000 USD for the 'Camp Nou' resturant\n");
			premium_flag = 1;
		}
	}		
}
