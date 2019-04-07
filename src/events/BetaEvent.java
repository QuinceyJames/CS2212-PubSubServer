package events;

import publishers.AbstractPublisher;
import publishers.IPublisher;

/**
 * A concrete implementation of {@link AbstractEvent}. This
 * class was added simply to demonstrate that our PubSub system can handle
 * different types of {@link AbstractEvent Events}
 *
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public class BetaEvent extends AbstractEvent {

	/**
	 * Protected constructor for {@link BetaEvent}. To create this object use
	 * {@link EventFactory#createEvent(EventType, AbstractPublisher, String, String)}
	 * 
	 * @see AbstractEvent#AbstractEvent(long, AbstractPublisher, EventMessage)
	 */
	protected BetaEvent(long eventID, IPublisher eventPublisher, EventMessage payload) {
		super(eventID, eventPublisher, payload);
	}

}
