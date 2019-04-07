package driver;

import java.util.Scanner;

import events.AbstractEvent;
import events.EventFactory;
import events.EventType;
import publishers.AbstractPublisher;
import publishers.PublisherDiscovery;

/**
 * A Package-Protected concrete implementation of {@link IDriverStrategy} that
 * can create an {@link events.AbstractEvent Event} and get a
 * {@link publishers.AbstractPublisher Publisher}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
class PublisherDriverStrategy implements IDriverStrategy {

	/**
	 * A reference to the {@link events.EventFactory} singleton
	 */
	private static final EventFactory EVENT_FACTORY = EventFactory.getInstance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see driver.IDriverStrategy#executeDriverStrategy(java.util.Scanner)
	 */
	@Override
	public void executeDriverStrategy(Scanner scanner) {
		AbstractPublisher publisher = PublisherDiscovery.getInstance().findPublisher(scanner.nextInt());

		// If the event details have been given, then create the event and publish
		if (scanner.hasNextInt()) {
			EventType type = EventType.values()[scanner.nextInt()];

			scanner.useDelimiter("\\|");
			AbstractEvent newEvent = EVENT_FACTORY.createEvent(type, publisher, scanner.next(".*").trim(),
					scanner.next(".*").trim());

			publisher.publish(newEvent);
		}

		// Otherwise publish
		else {
			publisher.publish();
		}

	}

}
