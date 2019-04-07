package publishers.strategies;

import events.AbstractEvent;
import events.EventFactory;
import events.EventType;
import publishers.AbstractPublisher;

/**
 * Base class for the implementation of the "State Design Pattern" with regards
 * to publisher strategies
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public abstract class AbstractStrategy {

	/**
	 * A reference to the {@link events.EventFactory} singleton
	 */
	private static final EventFactory EVENT_FACTORY = EventFactory.getInstance();

	/**
	 * The protected constructor for a {@link AbstractStrategy}. This ensures that
	 * only {@link StrategyFactory} can create strategies
	 */
	protected AbstractStrategy() {
	}

	/**
	 * Method to create and publish an {@link AbstractEvent} for an
	 * {@link AbstractPublisher}
	 * 
	 * @param publisher the {@link AbstractPublisher} that has requested an event to
	 *                  be published
	 */
	public final void doPublish(AbstractPublisher publisher) {
		doPublish(EVENT_FACTORY.createEvent(EventType.DEFAULT_EVENT, publisher, "Default Header", "Default Payload"),
				publisher); // Creates a default event for the publisher
	}

	/**
	 * Method to publish an specified {@link AbstractEvent} for an
	 * {@link AbstractPublisher}
	 * 
	 * @param publisher the {@link AbstractPublisher} that has requested an event to
	 *                  be published
	 * @param event     the {@link AbstractEvent} to be published
	 */
	public final void doPublish(AbstractEvent event, AbstractPublisher publisher) {
		System.out.println(String.format("%s publishes %s", publisher, event)); // Prints publisher with event
		doPublishStrategy(event, publisher);
	}

	/**
	 * The strategy logic should be defined in here for each of the concrete classes
	 * 
	 * @param event     the {@link AbstractPublisher} that has requested an event to
	 *                  be published
	 * @param publisher the {@link AbstractEvent} to be published
	 */
	protected abstract void doPublishStrategy(AbstractEvent event, AbstractPublisher publisher);

	@Override
	public String toString() {
		return getClass().getSimpleName(); // toString method
	}
}
