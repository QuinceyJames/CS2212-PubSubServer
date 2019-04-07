package subscribers;

import states.subscriber.StateName;

/**
 * creates new {@link AbstractSubscriber} objects contributes to the State
 * design pattern implements the FactoryMethod design pattern
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class SubscriberFactory {

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static SubscriberFactory INSTANCE = null;

	/**
	 * A private constructor used to help implement the "Singleton Design Pattern"
	 */
	private SubscriberFactory() {
	}

	/**
	 * Gets the Singleton instance of this class or creates it if it has not been
	 * instantiated before
	 * 
	 * @return the Singleton instance of this class
	 */
	public static SubscriberFactory getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SubscriberFactory(); // create a new instance if null

		return INSTANCE;
	}

	/**
	 * creates a new {@link AbstractSubscriber} using an entry from the
	 * {@link SubscriberType} enumeration
	 * 
	 * @param type         a value from the {@link SubscriberType} enumeration
	 *                     specifying the type of Subscriber to be created.
	 * @param name         {@link states.subscriber.StateName StateName} of the
	 *                     {@link state} to be associated with
	 *                     {@link AbstractSubscriber}.
	 * @param subscriberID {@link #subscriberID} to be associated with the given
	 *                     {@link AbstractSubscriber}.
	 * @return the newly created {@link AbstractSubscriber} instance
	 */
	public AbstractSubscriber createSubscriber(SubscriberType type, StateName name, int subscriberID) {

		switch (type) {
		case ALPHA_SUBSCRIBER:
			return new AlphaSubscriber(name, subscriberID);

		case BETA_SUBSCRIBER:
			return new BetaSubscriber(name, subscriberID);

		case GAMMA_SUBSCRIBER:
			return new GammaSubscriber(name, subscriberID);
		default:
			return new DefaultSubscriber(name, subscriberID);
		}

	}

}
