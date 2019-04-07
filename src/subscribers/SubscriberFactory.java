package subscribers;

import subscribers.states.StateName;

/**
 * creates new {@link AbstractSubscriber} objects contributes to the State
 * design pattern implements the FactoryMethod design pattern
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class SubscriberFactory implements ISubscriberFactory {

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static ISubscriberFactory INSTANCE = null;

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
	public static ISubscriberFactory getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SubscriberFactory(); // create a new instance if null

		return INSTANCE;
	}

	/* (non-Javadoc)
	 * @see subscribers.ISubscriberFactory#createSubscriber(subscribers.SubscriberType, subscribers.states.StateName, int)
	 */
	@Override
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
