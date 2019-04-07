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
public class GammaEvent extends AbstractEvent {

	/**
	 * Protected constructor for {@link GammaEvent}. To create this object use
	 * {@link EventFactory#createEvent(EventType, AbstractPublisher, String, String)}
	 * 
	 * @see AbstractEvent#AbstractEvent(long, AbstractPublisher, EventMessage)
	 */
	protected GammaEvent(long eventID, IPublisher eventPublisher, EventMessage eventMessage) {
		super(eventID, eventPublisher, eventMessage);
	}
}
