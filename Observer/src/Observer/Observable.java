package Observer;

import java.util.function.Function;

/**
 * @author Avishai
 *
 * @param <E> - an event that start the functions
 */
public interface Observable<E> {	
	void subscribe(Function<E, Void> c);
	void unSubscribe(Function<E, Void> c);
	void notifyAllObservers(E event);
}	