package events;

import publishers.AbstractPublisher;
import publishers.IPublisher;

public interface IEventFactory {

	/**
	 * This is an implementation of the Factory Method design pattern Creates an
	 * instance of any of the subclasses derived from the top level class
	 * {@link AbstractEvent} according to the {@link EventType} parameter
	 * 
	 * @param type      a member of the {@link EventType} enumeration
	 * @param publisher a reference to the {@link AbstractPublisher Publisher} that
	 *                  created this event
	 * @param header    the header message
	 * @param body      the body message
	 * @return returns the concrete {@link AbstractEvent Event} created by this
	 *         factory
	 */
	AbstractEvent createEvent(EventType type, IPublisher publisher, String header, String body);

}