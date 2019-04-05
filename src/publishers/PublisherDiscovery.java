package publishers;

import java.util.Map;

import publishers.AbstractPublisher;


/**
 * @author kkontog, ktsiouni, mgrigori
 * MUST IMPLEMENT the Singleton design pattern
 * Allows for the discovery of available channels for subscription from {@link AbstractSubscriber} that want to subscribe to them
 */
public class PublisherDiscovery {
	
	private static PublisherDiscovery instance = null;
	
	private PublisherDiscovery() {}
	
	public static PublisherDiscovery getInstance() {
		if (instance == null)
			instance = new PublisherDiscovery();
		return instance;
	}
	
	/**
	 * @param subscriberID the ID number of the looked-up subscriber
	 * @return a {@link AbstractSubscriber} type object corresponding the the ID provided as input
	 */
	protected AbstractPublisher findPublisher(int publisherID) { //may not be able to use ID
		return PublisherPoolManager.getInstance().findPublisher(publisherID); //may not be able to use ID
	}
	
	protected int findID(AbstractPublisher publisher) { //may not be able to use ID
		return PublisherPoolManager.getInstance().findID(publisher); //may not be able to use ID
	}
	
}

