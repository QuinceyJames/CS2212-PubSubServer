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
	 * A private constructor for this class. Since all of the methods are static, no
	 * instance of this class needs to be created
	 */
	private SubscriberFactory() {
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
	public static AbstractSubscriber createSubscriber(SubscriberType type, StateName name, int subscriberID) {

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
