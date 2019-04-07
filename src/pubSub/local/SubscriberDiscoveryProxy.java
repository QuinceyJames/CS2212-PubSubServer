package pubSub.local;

import pubSub.server.PubSubServerFacade;
import subscribers.AbstractSubscriber;

/**
 * Implements the Singleton design pattern.
 * 
 * Allows for the discovery of existing {@link AbstractSubscriber Subscribers}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 * 
 */
public class SubscriberDiscoveryProxy implements IDiscoveryProxy<AbstractSubscriber, Integer> {

	/**
	 * Attribute holding reference to the single instance of this class
	 */
	private static SubscriberDiscoveryProxy INSTANCE = null;

	/**
	 * Private constructor as per the Singleton Design Pattern
	 */
	private SubscriberDiscoveryProxy() {
	}

	/**
	 * Method controlling the constructor as per the Singleton Design Pattern that
	 * returns the one instance of {@link SubscriberDiscoveryProxy} if it exists,
	 * and if it does not exist , create it.
	 * 
	 * @return is the existing instance of {@link SubscriberDiscoveryProxy}
	 */
	public static SubscriberDiscoveryProxy getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SubscriberDiscoveryProxy();

		return INSTANCE;
	}

	/**
	 * Function to find and return an {@link AbstractSubscriber} given an
	 * {@link AbstractSubscriber#subscriberID ID}
	 * 
	 * @param subscriberID the ID number of the looked-up subscriber
	 * @return a {@link AbstractSubscriber} type object corresponding the the ID
	 *         provided as input
	 */
	@Override
	public AbstractSubscriber findUsingID(Integer subscriberID) {
		return PubSubServerFacade.getInstance().findSubscriber(subscriberID);
	}

}
