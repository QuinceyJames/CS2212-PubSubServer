package subscribers;

/**
 * @author kkontog, ktsiouni, mgrigori
 * MUST IMPLEMENT the Singleton design pattern
 * Allows for the discovery of available channels for subscription from {@link AbstractSubscriber} that want to subscribe to them
 */
public class SubscriberDiscovery {
	
	private static SubscriberDiscovery instance = null;
	
	private SubscriberDiscovery() {}
	
	public static SubscriberDiscovery getInstance() {
		if (instance == null)
			instance = new SubscriberDiscovery();
		return instance;
	}
	
	/**
	 * @param subscriberID the ID number of the looked-up subscriber
	 * @return a {@link AbstractSubscriber} type object corresponding the the ID provided as input
	 */
	public AbstractSubscriber findSubscriber(int subscriberID) { //may not be able to use ID
		return SubscriberPoolManager.getInstance().findSubscriber(subscriberID); //may not be able to use ID
	}
	
	public int findID(AbstractSubscriber subscriber) { //may not be able to use ID
		return SubscriberPoolManager.getInstance().findID(subscriber); //may not be able to use ID
	}
	
}
