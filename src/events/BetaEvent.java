package events;

public class BetaEvent extends AbstractEvent {

	public BetaEvent(long eventID, int eventPublisher, EventMessage payload) {
		super(eventID, eventPublisher, payload);
	}

}
