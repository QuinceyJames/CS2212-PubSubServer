package subscribers;

/**
 * @author kkontog, ktsiouni, mgrigori MUST IMPLEMENT the Singleton design
 *         pattern Allows for the discovery of available channels for
 *         subscription from {@link AbstractSubscriber} that want to subscribe
 *         to them
 */
public class SubscriberDiscovery {

	private static final SubscriberPoolManager POOL_MANAGER = SubscriberPoolManager.getInstance();
	private static SubscriberDiscovery INSTANCE = new SubscriberDiscovery();

	private SubscriberDiscovery() {
	}

	public static SubscriberDiscovery getInstance() {
		return INSTANCE;
	}

	/**
	 * @param subscriberID the ID number of the looked-up subscriber
	 * @return a {@link AbstractSubscriber} type object corresponding the the ID
	 *         provided as input
	 */
	public AbstractSubscriber findSubscriber(int subscriberID) { // may not be able to use ID
		return POOL_MANAGER.findSubscriber(subscriberID); // may not be able to use ID
	}

}
