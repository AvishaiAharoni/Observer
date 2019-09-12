package callBack;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Avishai
 *
 * @param <E> - an event that start the functions
 */
public class Dispatcher<E> implements Observable<E>{	
	List<CallBackBase<E>> observerlList;
	
	/**
	 * constructor
	 */
	Dispatcher () {
		observerlList = new ArrayList<>();
	}
	
	/* to subscribe to the dispatcher for notifications
	 * @see Observer.Observable#subscribe(java.util.function.Function)
	 * @param CallBackBase - the function to run when the event happen
	 */
	@Override
	public void subscribe(CallBackBase<E> func) {
		this.observerlList.add(func);
	}
	
	/* to unsubscribe for notifications
	 * @see Observer.Observable#unSubscribe(java.util.function.Function)
	 * @param CallBackBase - the function to run when the event happen
	 */
	@Override
	public void unSubscribe(CallBackBase<E> func) {
		this.observerlList.remove(func);
	}
	
	/* 
	 * to notify all the observers about the event
	 * @see Observer.Observable#notifyAllObservers(java.lang.Object)
	 * @param CallBackBase - the function to run when the event happen
	 */
	@Override
	public void notifyAllObservers(E event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (CallBackBase<E> func : this.observerlList) {
			func.eventNotify(event);
		}
	}
}	