package events;

import publishers.AbstractPublisher;

/**
 * A Package-Protected concrete implementation of {@link AbstractEvent}. This class was added
 * simply to demonstrate that our PubSub system can handle different types of
 * {@link AbstractEvent Events}
 *
 */
class BetaEvent extends AbstractEvent {

	/**
	 * Protected constructor for {@link BetaEvent}. To create this object use {@link EventFactory#createEvent(EventType, AbstractPublisher, String, String)}
	 * 
	 * @see AbstractEvent#AbstractEvent(long, AbstractPublisher, EventMessage)
	 */
	protected BetaEvent(long eventID, AbstractPublisher eventPublisher, EventMessage payload) {
		super(eventID, eventPublisher, payload);
	}

}
