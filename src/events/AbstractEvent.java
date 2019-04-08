package events;

import publishers.IPublisher;

/**
 * This class defines the behavior that is shared between all extending classes.
 * A {@link publishers.AbstractPublisher Publisher} will use a
 * {@link publishers.strategies.AbstractStrategy Strategy} to publish a concrete
 * {@link AbstractEvent Event} to a {@link pubSub.server.Channel Channel} which
 * would then notify all of the {@link subscribers.AbstractSubscriber
 * Subscribers} that are subscribed to that channel
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public abstract class AbstractEvent implements IEvent {
	/**
	 * A unique number used to identify this event
	 */
	private long eventId;

	/**
	 * A reference to the {@link publishers.IPublisher Publisher} of this
	 * {@link AbstractEvent Event}
	 */
	private IPublisher eventPublisher;

	/**
	 * The {@link Message} that this {@link AbstractEvent Event} references
	 */
	private EventMessage eventMessage;

	/**
	 * Protected Constructor for the abstract class AbstractEvent. This ensures only
	 * the {@link EventFactory} can create events
	 * 
	 * @param eventID        must be a number of type long generated from the
	 *                       {@link EventIDMaker#getNewEventID()} method
	 * @param eventPublisher must be a number designating the
	 *                       {@link publishers.IPublisher Publisher} issuing
	 *                       the event
	 * @param eventMessage   is a {@link EventMessage} which contains a title and a
	 *                       message for the event.
	 */
	protected AbstractEvent(long eventID, IPublisher eventPublisher, EventMessage eventMessage) {
		this.eventPublisher = eventPublisher;
		this.eventMessage = eventMessage;
		this.eventId = eventID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s %d, MESSAGE=%s", getClass().getSimpleName(), eventId, eventMessage);
	}

	/**
	 * Gets the eventID
	 * 
	 * @return a long value representing the ID of this {@link AbstractEvent Event}
	 */
	protected long getEventID() {
		return eventId;
	}

	/**
	 * Gets the {@link publishers.IPublisher Publisher} that created this
	 * {@link AbstractEvent Event}
	 * 
	 * @return the {@link publishers.IPublisher Publisher} that created this
	 *         {@link AbstractEvent Event}
	 */
	protected IPublisher getEventPublisher() {
		return eventPublisher;
	}

	/*
	 * Gets the {@link EventMessage} associated with this object
	 * 
	 * @return an object of the Class {@link EventMessage}
	 */
	protected EventMessage getEventMessage() {
		return eventMessage;
	}
}
