package driver;

import java.util.Scanner;
import java.util.StringTokenizer;

import events.AbstractEvent;
import events.EventFactory;
import events.EventType;
import publishers .AbstractPublisher;
import publishers.PublisherDiscovery;

public class PublisherDriver implements DriverInterface {

	@Override
	public void execute(Scanner scanner) {
		AbstractPublisher publisher = PublisherDiscovery.getInstance().findPublisher(scanner.nextInt());
		if (scanner.hasNext())	{
			int eventType = scanner.nextInt();
			EventType type = EventType.values()[eventType];
			AbstractEvent newEvent = EventFactory.createEvent(type, publisher, scanner.next("|"), scanner.next("|"));
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
