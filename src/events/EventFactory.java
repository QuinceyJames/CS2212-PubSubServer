package events;

import publishers.AbstractPublisher;

/**
 * A class that is used to generate a concrete {@link AbstractEvent Event}
 * 
 * @author kkontog, ktsiouni, mgrigori
 *
 */
public class EventFactory {

	/**
	 * A private constructor for this class. Since all of the methods are static, no
	 * instance of this class needs to be created
	 */
	private EventFactory() {
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
	public static AbstractEvent createEvent(EventType type, AbstractPublisher publisher, String header, String body) {

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
