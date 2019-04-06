package driver;

import java.util.Scanner;

import events.AbstractEvent;
import events.EventFactory;
import events.EventType;
import publishers.AbstractPublisher;
import publishers.PublisherDiscovery;


/**
 * A Package-Protected concrete implementation of {@link DriverStrategy}that can create an {@link events.AbstractEvent} and get a {@link publishers.AbstractPublisher} 
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
class PublisherDriver implements DriverStrategy {

	@Override
	public void executeDriverStrategy(Scanner scanner) {
		AbstractPublisher publisher = PublisherDiscovery.getInstance().findPublisher(scanner.nextInt());

		if (scanner.hasNextInt()) {
			EventType type = EventType.values()[scanner.nextInt()];

			scanner.useDelimiter("\\|");
			AbstractEvent newEvent = EventFactory.createEvent(type, publisher, scanner.next(".*").trim(),
					scanner.next(".*").trim());

			publisher.publish(newEvent);
		} else {
			publisher.publish();
		}

	}

}
