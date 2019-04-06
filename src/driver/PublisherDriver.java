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
		if (scanner.hasNextInt()){
			int eventType = scanner.nextInt();
			EventType type = EventType.values()[eventType];
			scanner.useDelimiter("|");
			AbstractEvent newEvent = EventFactory.createEvent(type, publisher, scanner.next(), scanner.next());
			publisher.publish(newEvent);
			System.out.println(String.format("%s publishes %s @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@", publisher, newEvent));
		}
		
		else {
			publisher.publish();
			System.out.println(String.format("%s publishes ******************************", publisher));
		}
	}



	


	
	

}
