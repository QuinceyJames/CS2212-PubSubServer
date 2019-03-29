package events;

public class GammaEvent extends AbstractEvent {
	public GammaEvent(long eventID, int eventPublisher, EventMessage payload) {
		super(eventID, eventPublisher, payload);
	}
}
