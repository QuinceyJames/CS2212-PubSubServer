package orchestration.driver;

import java.util.Scanner;

import events.EventFactory;
import events.EventType;
import events.IEvent;
import events.IEventFactory;
import pubSub.local.PublisherDiscoveryProxy;
import publishers.IPublisher;

/**
 * A Package-Protected concrete implementation of {@link DriverInterface} that
 * can create an {@link IEvent Event} and get a {@link IPublisher Publisher}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
class PublisherDriverStrategy implements IDriverStrategy {

	/**
	 * A reference to the {@link IEventFactory} singleton
	 */
	private static final IEventFactory EVENT_FACTORY = EventFactory.getInstance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * orchestration.driver.IDriverStrategy#executeDriverStrategy(java.util.Scanner)
	 */
	@Override
	public void executeDriverStrategy(Scanner scanner) {
		IPublisher publisher = PublisherDiscoveryProxy.getInstance().findUsingID(scanner.nextInt());

		// If the event details have been given, then create the event and publish
		if (scanner.hasNextInt()) {
			EventType type = EventType.values()[scanner.nextInt()];

			scanner.useDelimiter("\\|");
			IEvent newEvent = EVENT_FACTORY.createEvent(type, publisher, scanner.next(".*").trim(),
					scanner.next(".*").trim());

			publisher.publish(newEvent);
		}

		// Otherwise publish
		else {
			publisher.publish();
		}

	}

}
