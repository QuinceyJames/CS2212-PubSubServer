package events;

public class DefaultEvent extends AbstractEvent {
	public DefaultEvent(long eventID, int eventPublisher, EventMessage payload) {
		super(eventID, eventPublisher, payload);
	}
}
