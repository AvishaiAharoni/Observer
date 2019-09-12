package Observer;

import java.util.function.Function;
import org.junit.jupiter.api.Test;


class ObserverFunctionTest {	
	@Test
	void test() {
		Person<String> p1 = new Person<>("Uri");
		Person<String> p2 = new Person<>("Eliana");
		
		String event_barce = "Welcome to Barce match\n";
		String event_real = "Welcome to Real match\n";
		String event_match_started = "Match started!\n";
		String event_goal_to_barce = "Goaaaaaaaal! Messi... Barce leads 1 : 0\n";
		String event_goal_to_real = "Goaaaaaaaal! Bale scores! The result is 1 : 1\n";
		String event_victory_goal = "Goaaaaaaaal! Another one by Messi!\n";
		String end_of_match = "There is the final whistle! Barce won by 2 goals to 1!!!\n";
		String Eliana_lost = "Eliana you looser!!!!\n";
		
		Dispatcher<String> d = new Dispatcher<String>();
		
		Function<String,Void> func1 = p1::notifyMe;
		Function<String,Void> func2 = p2::notifyMeWithModification;
		
//		Function<String, Void> func1 = Person.class.getMethod("notifyMe", String.class);
//		d.subscribe(Person.class.getMethod("notifyMe", String.class));
		
		// subscribe func1 and func2
		d.subscribe(func1);
		d.subscribe(func2);
		
		// notify each subscriber for his event
		p1.notifyMe(event_barce);
		p2.notifyMe(event_real);
		
		// notify all subscribers during the match
		d.notifyAllObservers(event_match_started);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) { e.printStackTrace();	}

		d.notifyAllObservers(event_goal_to_barce);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { e.printStackTrace();	}
		
		d.notifyAllObservers(event_goal_to_real);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { e.printStackTrace();	}
		
		d.notifyAllObservers(event_victory_goal);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) { e.printStackTrace();	}

		d.notifyAllObservers(Eliana_lost);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) { e.printStackTrace();	}
		
		// unsubscribe func2
		d.unSubscribe(func2);
		
		d.notifyAllObservers(end_of_match);
	}
}
