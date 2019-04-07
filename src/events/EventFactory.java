package events;

import publishers.AbstractPublisher;

/**
 * A class that is used to generate a concrete {@link AbstractEvent Event}
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 *
 * 
 */
public class EventFactory {

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static EventFactory INSTANCE = null;

	/**
	 * A private constructor used to help implement the "Singleton Design Pattern"
	 */
	private EventFactory() {
	}

	/**
	 * Gets the Singleton instance of this class or creates it if it has not been
	 * instantiated before
	 * 
	 * @return the Singleton instance of this class
	 */
	public static EventFactory getInstance() {
		if (INSTANCE == null)
			INSTANCE = new EventFactory(); // create a new instance if null

		return INSTANCE;
	}

	/**
	 * This is an implementation of the Factory Method design pattern Creates an
	 * instance of any of the subclasses derived from the top level class
	 * {@link AbstractEvent} according to the {@link EventType} parameter
	 * 
	 * @param type      a member of the {@link EventType} enumeration
	 * @param publisher a reference to the {@link AbstractPublisher Publisher} that
	 *                  created this event
	 * @param header    the header message
	 * @param body      the body message
	 * @return returns the concrete {@link AbstractEvent Event} created by this
	 *         factory
	 */
	public AbstractEvent createEvent(EventType type, AbstractPublisher publisher, String header, String body) {

		switch (type) {
		case ALPHA_EVENT:
			return new AlphaEvent(EventIDMaker.getNewEventID(), publisher, new EventMessage(header, body));

		case BETA_EVENT:
			return new BetaEvent(EventIDMaker.getNewEventID(), publisher, new EventMessage(header, body));

		case GAMMA_EVENT:
			return new GammaEvent(EventIDMaker.getNewEventID(), publisher, new EventMessage(header, body));

		default:
			return new DefaultEvent(EventIDMaker.getNewEventID(), publisher, new EventMessage(header, body));
		}

	}

}
