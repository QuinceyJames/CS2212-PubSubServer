package pubSubServer;

import subscribers.AbstractSubscriber;

/**
 * MUST IMPLEMENT the Singleton Design Pattern and already implements the Proxy
 * Design Pattern exposes the subscribe, and unsubscribe methods to the clients
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class SubscriptionManager {

	/**
	 * a reference to {@link ChannelAccessControl}
	 */
	private static final ChannelAccessControl CHANNEL_ACCESS_CONTROL = ChannelAccessControl.getInstance();

	/**
	 * A reference to the {@link ChannelPoolManager}
	 */
	private static final ChannelPoolManager CHANNEL_POOL_MANAGER = ChannelPoolManager.getInstance();

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static SubscriptionManager INSTANCE = null;

	/**
	 * A private constructor used to help implement the "Singleton Design Pattern"
	 */
	private SubscriptionManager() {
	}

	/**
	 * Gets the Singleton instance of this class or creates it if it has not been
	 * instantiated before
	 * 
	 * @return the Singleton instance of this class
	 */
	public static SubscriptionManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SubscriptionManager();

		return INSTANCE;
	}

	/**
	 * Completes the subscription of the provided ISubscriber to the appropriate
	 * AbstractChannel specified by the channelName
	 * 
	 * @param channelName the name of the {@link AbstractChannel Channel} to which
	 *                    the {@link subscribers.AbstractSubscriber Subscriber}
	 *                    wants to subscribe
	 * @param subscriber  the reference to an {@link subscribers.AbstractSubscriber
	 *                    Subscriber} object
	 */
	public void subscribe(String channelTopic, AbstractSubscriber subscriber) {
		AbstractChannel channel = CHANNEL_POOL_MANAGER.findChannel(channelTopic);
		channel.subscribe(subscriber);
		System.out.println(subscriber + " subscribes to Channel " + "'" + channelTopic + "'" + ".");
	}

	/**
	 * Completes the unsubscription of the provided ISubscriber from the specified,
	 * by the channelName, AbstractChannel
	 * 
	 * @param channelName the name of the {@link AbstractChannel Channel} from which
	 *                    the {@link subscribers.AbstractSubscriber Subscriber}
	 *                    wants to unsubscribe
	 * @param subscriber  the reference to an {@link subscribers.AbstractSubscriber
	 *                    Subscriber} object
	 */
	public void unSubscribe(String channelName, AbstractSubscriber subscriber) {
		AbstractChannel channel = CHANNEL_POOL_MANAGER.findChannel(channelName);
		channel.unsubscribe(subscriber);
		System.out.println(subscriber + " unsubscribes from " + channelName);
	}

	/**
	 * Proxy to
	 * {@link ChannelAccessControl#unBlockSubscriber(AbstractSubscriber, String)}
	 * 
	 * @param subscriber  who to unblock
	 * @param channelName from which channel
	 * @return true if the {@link subscribers.AbstractSubscriber} was previously
	 *         blocked. Otherwise return false.
	 */
	public boolean unblock(AbstractSubscriber subscriber, String channelName) {
		return CHANNEL_ACCESS_CONTROL.unBlockSubscriber(subscriber, channelName); // proxy method for unblocking
	}

	/**
	 * Proxy to
	 * {@link ChannelAccessControl#blockSubscriber(AbstractSubscriber, String)}
	 * 
	 * @param subscriber  who to block
	 * @param channelName from which channel
	 * @return true if the {@link AbstractSubscriber Subscriber} was not previously
	 *         blocked on this channel. Otherwise it returns false.
	 */
	public boolean block(AbstractSubscriber subscriber, String channelName) {
		return CHANNEL_ACCESS_CONTROL.blockSubcriber(subscriber, channelName); // proxy method for blocking
	}

}
