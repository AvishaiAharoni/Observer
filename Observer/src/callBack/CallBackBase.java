package callBack;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Avishai
 *
 * @param <E> - an event that start the functions
 * @throws IllegalAccessException - if the method can't access to the instance
 * @throws IllegalArgumentException - if the argument is not legal
 * @throws InvocationTargetException
 */
public interface CallBackBase<E> {	
	public void eventNotify(E event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}