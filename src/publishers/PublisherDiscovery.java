package publishers;

import subscribers.AbstractSubscriber;

/**
 * @author kkontog, ktsiouni, mgrigori MUST IMPLEMENT the Singleton design
 *         pattern Allows for the discovery of available channels for
 *         subscription from {@link AbstractSubscriber} that want to subscribe
 *         to them
 */
public class PublisherDiscovery {

	private static PublisherDiscovery INSTANCE = new PublisherDiscovery();

	private PublisherDiscovery() {
	}

	public static PublisherDiscovery getInstance() {
		return INSTANCE;
	}

	/**
	 * @param subscriberID the ID number of the looked-up subscriber
	 * @return a {@link AbstractSubscriber} type object corresponding the the ID
	 *         provided as input
	 */
	public AbstractPublisher findPublisher(int publisherID) { // may not be able to use ID
		return PublisherPoolManager.getInstance().findPublisher(publisherID); // may not be able to use ID
	}
}
