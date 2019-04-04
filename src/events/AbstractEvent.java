package events;

import publishers.AbstractPublisher;

/**
 * @author kkontog, ktsiouni, mgrigori
 *
 */
public abstract class AbstractEvent {
	private long eventId;
	private AbstractPublisher eventPublisher;
	private EventMessage payload;

	/**
	 * Default Constructor for the abstract class AbstractEvent
	 * 
	 * @param eventID        must be a number of type long generated from the
	 *                       {@link EventIDMaker#getNewEventID()} method
	 * @param eventPublisher must be a number (currently is the hashCode of the
	 *                       object) designating the object issuing the event
	 * @param payload        is a {@link EventMessage} which contains a title and a
	 *                       message for the event. Normally there should be a rich
	 *                       hierarchy of EventMessage types.
	 */
	public AbstractEvent(long eventID, AbstractPublisher eventPublisher, EventMessage payload) {
		this.eventPublisher = eventPublisher;
		this.eventId = eventID;
		this.payload = payload;
	}

	/**
	 * 
	 * @return a long value designating the EventType
	 */
	protected long getEventType() {
		return eventId;
	}

	protected AbstractPublisher getEventPublisher() {
		return eventPublisher;
	}

	/**
	 * @return an object of the Class {@link EventMessage}
	 */
	protected EventMessage getPayload() {
		return payload;
	}

}
