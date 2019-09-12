package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Avishai
 *
 * @param <E> - an event that start the functions
 */
public class Dispatcher<E> implements Observable<E> {		
	List<Function<E, Void>> observerlList;	
		
	/**
	 * constructor
	 */
	public Dispatcher () {	
		this.observerlList = new ArrayList<>();
	}	
		
	/* 
	 * to notify all the observers about the event
	 * @see Observer.Observable#notifyAllObservers(java.lang.Object)
	 */
	@Override	
	public void notifyAllObservers(E event) {
		List<Function<E, Void>> copyList = new ArrayList<>();
		
		// copying all the functions to another array list,
		// for case of change in the middle of the iteration
		synchronized (this.observerlList) {
			for (Function<E, Void> func : this.observerlList) {
				copyList.add(func);
			}
		}
		
		for (Function<E, Void> func : copyList) {
			func.apply(event);
		}
	}

	/* to subscribe to the dispatcher for notifications
	 * @see Observer.Observable#subscribe(java.util.function.Function)
	 */
	@Override
	public void subscribe(Function<E, Void> func) {
		this.observerlList.add(func);
	}

	/* to unsubscribe for notifications
	 * @see Observer.Observable#unSubscribe(java.util.function.Function)
	 */
	@Override
	public void unSubscribe(Function<E, Void> func) {
		this.observerlList.remove(func);
	}	
}		