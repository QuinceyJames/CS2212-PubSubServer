package events;

/**
 * the enumeration of available options that can be used to create an Event
 * using the {@link EventFactory#createEvent(EventType, int, EventMessage)}
 * method
 * 
 * for every new @link {@link AbstractEvent} subclass created, a new entry
 * should be added here
 *
 * @author kkontog, ktsiouni, mgrigori
 * 
 */
public enum EventType {
	ALPHA_EVENT, BETA_EVENT, GAMMA_EVENT, DEFAULT_EVENT;
}
