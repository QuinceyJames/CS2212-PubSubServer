package events;

public class AlphaEvent extends AbstractEvent {
	public AlphaEvent(long eventID, int eventPublisher, EventMessage payload) {
		super(eventID, eventPublisher, payload);
	}
}
