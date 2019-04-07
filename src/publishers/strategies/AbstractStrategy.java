package publishers.strategies;

import events.AbstractEvent;
import events.EventFactory;
import events.EventType;
import events.IEventFactory;
import publishers.AbstractPublisher;
import publishers.IPublisher;

/**
 * Base class for the implementation of the "State Design Pattern" with regards
 * to publisher strategies
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public abstract class AbstractStrategy implements IStrategy {

	/**
	 * A reference to the {@link events.EventFactory} singleton
	 */
	private static final IEventFactory EVENT_FACTORY = EventFactory.getInstance();

	/**
	 * The protected constructor for a {@link AbstractStrategy}. This ensures that
	 * only {@link StrategyFactory} can create strategies
	 */
	protected AbstractStrategy() {
	}

	/* (non-Javadoc)
	 * @see publishers.strategies.IStrategy#doPublish(publishers.IPublisher)
	 */
	@Override
	public final void doPublish(IPublisher publisher) {
		doPublish(EVENT_FACTORY.createEvent(EventType.DEFAULT_EVENT, publisher, "Default Header", "Default Payload"),
				publisher); // Creates a default event for the publisher
	}

	/* (non-Javadoc)
	 * @see publishers.strategies.IStrategy#doPublish(events.AbstractEvent, publishers.IPublisher)
	 */
	@Override
	public final void doPublish(AbstractEvent event, IPublisher publisher) {
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
	protected abstract void doPublishStrategy(AbstractEvent event, IPublisher publisher);

	@Override
	public String toString() {
		return getClass().getSimpleName(); // toString method
	}
}
