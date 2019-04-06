package events;

import publishers.AbstractPublisher;

/**
 * A Package-Protected concrete implementation of {@link AbstractEvent}. This class was added
 * simply to demonstrate that our PubSub system can handle different types of
 * {@link AbstractEvent Events}
 *
 */
class AlphaEvent extends AbstractEvent {

	/**
	 * Constructor for {@link AlphaEvent}. To create this object use {@link EventFactory#createEvent(EventType, AbstractPublisher, String, String)}
	 * 
	 * @see AbstractEvent#AbstractEvent(long, AbstractPublisher, EventMessage)
	 */
	protected AlphaEvent(long eventID, AbstractPublisher eventPublisher, EventMessage eventMessage) {
		super(eventID, eventPublisher, eventMessage);
	}
}
