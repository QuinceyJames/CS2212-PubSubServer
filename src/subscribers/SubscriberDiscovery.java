package subscribers;

/**
 * Implements the Singleton design pattern. 
 * 
 * Allows for the discovery of existing {@link AbstractSubscriber} s.
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 * 
 */
public class SubscriberDiscovery {

	
	/**
	 * Attribute holding reference to the {@link SubscriberPoolManager} to access list of current subscribers
	 */
	private static final SubscriberPoolManager POOL_MANAGER = SubscriberPoolManager.getInstance();
	
	
	/**
	 * Attribute holding reference to the single instance of this class
	 */
	private static SubscriberDiscovery INSTANCE = null;

	/**
	 * Private constructor as per the Singleton Design Pattern
	 */
	private SubscriberDiscovery() {}

	
	/**
	 * Method controlling the constructor as per the Singleton Design Pattern that returns
	 * the one instance of {@link SubscriberDiscovery} if it exists, and if it does not exist
	 * , create it.
	 * 
	 * @return is the existing instance of {@link SubscriberDiscovery}
	 */
	public static SubscriberDiscovery getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SubscriberDiscovery();
		
		return INSTANCE;
	}

	/**
	 * Function to find and return an {@link AbstractSubscriber} given an {@link AbstractSubscriber#subscriberID ID}
	 * 
	 * @param subscriberID the ID number of the looked-up subscriber
	 * @return a {@link AbstractSubscriber} type object corresponding the the ID
	 *         provided as input
	 */
	public AbstractSubscriber findSubscriber(int subscriberID) { 
		return POOL_MANAGER.findSubscriber(subscriberID); 
	}

}
