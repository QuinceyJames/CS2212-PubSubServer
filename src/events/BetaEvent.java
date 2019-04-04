package events;

import publishers.AbstractPublisher;

public class BetaEvent extends AbstractEvent {

	public BetaEvent(long eventID, AbstractPublisher eventPublisher, EventMessage payload) {
		super(eventID, eventPublisher, payload);
	}

}
