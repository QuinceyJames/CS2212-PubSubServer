package events;

/**
 * A Package-Protected class used to store a message with a header and a body.
 * Used in {@link AbstractEvent}
 * 
 * @author kkontog, ktsiouni, mgrigori
 *
 */
class EventMessage {

	/**
	 * The header of this message
	 */
	private final String header;

	/**
	 * The body of this message
	 */
	private final String body;

	/**
	 * Protected constructor for this class. To create an {@link EventMessage}, use
	 * {@link EventFactory#createEvent(EventType, AbstractPublisher, String, String)}
	 * 
	 * @param header String value containing the header of the Event
	 * @param body   String value containing the body of the Event
	 */
	protected EventMessage(String header, String body) {
		this.header = header;
		this.body = body;
	}

	/**
	 * @return the String containing the Event.header data
	 */
	protected String getHeader() {
		return header;
	}

	/**
	 * @return the String containing the Event.body data
	 */
	protected String getBody() {
		return body;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("[{%s}, {%s}]", header, body);
	}
}
