package callBack;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Avishai
 *
 * @param <E> - an event that start the functions
 */
public class CallBackStandart<T, E> implements CallBackBase<E> {	
	private T instance;
	private Method method;
	
	/**
	 * constructor
	 * @param instance
	 * @param method
	 */
	public CallBackStandart(T instance, String method) {
		this.instance = instance;
		try {
			this.method = this.instance.getClass().getMethod(method, Object.class);
		} 
		catch (NoSuchMethodException | SecurityException e) { e.printStackTrace(); }
	}
	
	/* 
	 * to notify about an event
	 * @see callBack.CallBackBase#eventNotify(java.lang.Object)
	 * @throws IllegalAccessException - if the method can't access to the instance
	 * @throws IllegalArgumentException - if the argument is not legal
	 * @throws InvocationTargetException
	 */
	@Override
	public void eventNotify(E event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.method.invoke(instance, event);
	}
}	