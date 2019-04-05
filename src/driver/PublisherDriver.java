package driver;

import java.util.StringTokenizer;

import events.AbstractEvent;
import events.EventFactory;
import events.EventType;
import orchestration.Orchestration;
import publishers .AbstractPublisher;

public class  PublisherDriver implements DriverInterface {

	@Override
	public void execute(StringTokenizer tokenizer) {
		AbstractPublisher publisher = Orchestration.getInstance().getPublisher(Integer.parseInt(tokenizer.nextToken()));
		if (tokenizer.countTokens() > 2) {
			int eventType = Integer.parseInt(tokenizer.nextToken());
			EventType type = EventType.values()[eventType];
			AbstractEvent newEvent = EventFactory.createEvent(type, publisher, tokenizer.nextToken("|"), tokenizer.nextToken("|"));
			publisher.publish(newEvent);
		}
		
		else {
			publisher.publish();
		}
		
	}
	public static void main (String[] args) {
		String test = "1 2 This is a header | This is a payload |";
		StringTokenizer tokenizer = new StringTokenizer(test);
		System.out.println("This is the publisher ID: " + Integer.parseInt(tokenizer.nextToken()));
		System.out.println("This is the event type: " + Integer.parseInt(tokenizer.nextToken()));
		System.out.println("This is the header: " + tokenizer.nextToken("|"));
		System.out.println("This is the payload: " + tokenizer.nextToken("|"));
	}


	


	
	

}