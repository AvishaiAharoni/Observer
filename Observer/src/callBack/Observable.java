package callBack;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Avishai
 *
 * @param <E> - an event that start the functions
 */
public interface Observable<E> {	
	void subscribe(CallBackBase<E> c);
	void unSubscribe(CallBackBase<E> c);
	void notifyAllObservers(E event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}	