package events;

/**
 * A Package-Protected class that can be used to produce a unique eventID for every
 * {@link AbstractEvent Event} that is created
 * 
 * @author kkontog, ktsiouni, mgrigori
 *
 */
class EventIDMaker {

	/**
	 * The next available EventID
	 */
	private static long eventUIDs = 0L;

	/**
	 * A private constructor for this class. This class should never need to be
	 * instantiated since all of its methods are static
	 */
	private EventIDMaker() {
	}

	/**
	 * @return the next number of type {@link long}in the series of UID for the
	 *         AbstractEvent derived classes
	 */
	protected static long getNewEventID() {
		return eventUIDs++;
	}

}
