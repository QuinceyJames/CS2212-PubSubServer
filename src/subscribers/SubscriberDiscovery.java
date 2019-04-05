package subscribers;

import java.util.List;

import subscribers.AbstractSubscriber;


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
	 * 
	 * @return a list of {@link AbstractSubscriber} type elements containing all available subscribers 
	 * currently in the PubSubServer 
	 */
	public List<AbstractSubscriber> listSubscribers() {
		return SubscriberPoolManager.getInstance().listSubscribers();
	}

	/**
	 * @param subscriberID the ID number of the looked-up subscriber
	 * @return a {@link AbstractSubscriber} type object corresponding the the ID provided as input
	 */
	protected AbstractSubscriber findSubscriber(int subscriberID) { //may not be able to use ID
		return SubscriberPoolManager.getInstance().getSubscribersMap().get(subscriberID); //may not be able to use ID
	}
	
}
