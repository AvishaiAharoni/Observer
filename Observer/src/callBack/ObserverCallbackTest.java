package callBack;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

class ObserverCallbackTest {	
	
	@Test
	void test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		Person<String> uri = new Person<>("Uri");
		Person<String> eliana = new Person<>("Eliana");
		Person<String> avishay = new Person<>("Avishay");
		
		String event_barce = "Welcome to Barce match\n";
		String event_real = "Welcome to Real match\n";
		String event_match_started = "Match started!\n";
		String event_goal_to_barce = "Goaaaaaaaal! Messi... Barce leads 1 : 0\n";
		String event_goal_to_real = "Goaaaaaaaal! Bale scores! The result is 1 : 1\n";
		String event_victory_goal = "Goaaaaaaaal! Another one by Messi!\n";
		String end_of_match = "There is the final whistle! Barce won by 2 goals to 1!!!\n";
		
		Dispatcher<String> d = new Dispatcher<>();

		uri.subscribeMe("notifyMe", d);
		eliana.subscribeMe("notifyMe", d);

		try {
			uri.callBackFunction.eventNotify(event_barce);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		eliana.callBackFunction.eventNotify(event_real);
		
		d.notifyAllObservers(event_match_started);
		d.notifyAllObservers(event_goal_to_barce);
		
		avishay.subscribeMe("notifyMeAsPremium", d);
		
		d.notifyAllObservers(event_goal_to_real);
		d.notifyAllObservers(event_victory_goal);
		
		eliana.unSubscribeMe(d);
		
		d.notifyAllObservers(end_of_match);	
	}	
}
