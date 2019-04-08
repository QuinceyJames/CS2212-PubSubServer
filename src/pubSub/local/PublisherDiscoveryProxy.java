package pubSub.local;

import pubSub.server.IChannel;
import pubSub.server.PubSubServerFacade;
import publishers.IPublisher;

/**
 * Implements the Singleton design pattern.
 * 
 * Allows for the discovery of existing {@link IChannel}.
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 * 
 */
public class PublisherDiscoveryProxy implements IDiscoveryProxy<IPublisher, Integer> {

	/**
	 * Attribute holding reference to the single instance of this class
	 */
	private static PublisherDiscoveryProxy INSTANCE = null;

	/**
	 * Private constructor as per the Singleton Design Pattern
	 */
	private PublisherDiscoveryProxy() {
	}

	/**
	 * Method controlling the constructor as per the Singleton Design Pattern that
	 * returns the one instance of {@link PublisherDiscoveryProxy} if it exists, and if
	 * it does not exist , create it.
	 * 
	 * @return is the existing instance of {@link PublisherDiscoveryProxy}
	 */
	public static PublisherDiscoveryProxy getInstance() {
		if (INSTANCE == null)
			INSTANCE = new PublisherDiscoveryProxy();

		return INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see baseEntities.IDiscoveryProxy#findUsingID(int)
	 */
	public IPublisher findUsingID(Integer publisherID) {
		return PubSubServerFacade.getInstance().findPublisher(publisherID);
	}
}
