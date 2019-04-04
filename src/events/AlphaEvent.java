package events;

import publishers.AbstractPublisher;

public class AlphaEvent extends AbstractEvent {
	public AlphaEvent(long eventID, AbstractPublisher eventPublisher, EventMessage payload) {
		super(eventID, eventPublisher, payload);
	}
}
