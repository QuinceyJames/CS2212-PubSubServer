package events;

import publishers.AbstractPublisher;

public class DefaultEvent extends AbstractEvent {
	public DefaultEvent(long eventID, AbstractPublisher eventPublisher, EventMessage payload) {
		super(eventID, eventPublisher, payload);
	}
}
