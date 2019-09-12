package Observer;

import java.util.function.Function;

class Person<E> {
	Function<String, Void> callBackFunction;
	String name;

	Person(String name) { 
		this.name = name; 
	}

	public void subscribeMe(String nameOfNotifyMethod, Dispatcher<String> d) {	
		try {
//			Method m = this.getClass().getMethod(nameOfNotifyMethod, String.class);
			callBackFunction = this::notifyMe;
			d.subscribe(callBackFunction);

		}
		catch (SecurityException e) { e.printStackTrace(); }
	}

	public Void notifyMe(String e) {
		System.out.println(this.name + " was notified with the event : " + e );
		return null;
	}	

	public Void notifyMeWithModification(String e) {
		System.out.println(name + " was notified with MODIFICATION the event : " + e );
		return null;
	}		
}