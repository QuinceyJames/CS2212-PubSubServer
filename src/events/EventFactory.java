package events;

import publishers.IPublisher;

/**
 * A class that is used to generate a concrete {@link AbstractEvent Event}
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 *
 * 
 */
public class EventFactory implements IEventFactory {

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static IEventFactory INSTANCE = null;

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
	public static IEventFactory getInstance() {
		if (INSTANCE == null)
			INSTANCE = new EventFactory(); // create a new instance if null

		return INSTANCE;
	}

	/* (non-Javadoc)
	 * @see events.IEventFactory#createEvent(events.EventType, publishers.IPublisher, java.lang.String, java.lang.String)
	 */
	@Override
	public AbstractEvent createEvent(EventType type, IPublisher publisher, String header, String body) {

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
