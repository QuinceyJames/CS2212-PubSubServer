package pubSub.local;

import pubSub.server.IPubSubServerFacade;
import pubSub.server.PubSubServerFacade;
import subscribers.ISubscriber;

/**
 * MUST IMPLEMENT the Singleton Design Pattern and already implements the Proxy
 * Design Pattern exposes the subscribe, and unsubscribe methods to the clients
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class SubscriptionManagerProxy implements ISubscriptionManagerProxy {

	private static final IPubSubServerFacade PUB_SUB_SERVER_FACADE = PubSubServerFacade.getInstance();
	/**
	 * A reference to the Singleton instance of this class
	 */
	private static ISubscriptionManagerProxy INSTANCE = null;

	/**
	 * A private constructor used to help implement the "Singleton Design Pattern"
	 */
	private SubscriptionManagerProxy() {
	}

	/**
	 * Gets the Singleton instance of this class or creates it if it has not been
	 * instantiated before
	 * 
	 * @return the Singleton instance of this class
	 */
	public static ISubscriptionManagerProxy getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SubscriptionManagerProxy();

		return INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.local.ISubscriptionManagerProxy#subscribe(java.lang.String,
	 * subscribers.AbstractSubscriber)
	 */
	@Override
	public void subscribe(String channelTopic, ISubscriber subscriber) {
		PUB_SUB_SERVER_FACADE.subscribe(subscriber, channelTopic);
		System.out.println(subscriber + " subscribes to Channel " + "'" + channelTopic + "'" + ".");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.local.ISubscriptionManagerProxy#unSubscribe(java.lang.String,
	 * subscribers.AbstractSubscriber)
	 */
	@Override
	public void unSubscribe(String channelName, ISubscriber subscriber) {
		PUB_SUB_SERVER_FACADE.unsubscribe(subscriber, channelName);
		System.out.println(subscriber + " unsubscribes from Channel '" + channelName + "'.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.local.ISubscriptionManagerProxy#unblock(subscribers.
	 * AbstractSubscriber, java.lang.String)
	 */
	@Override
	public boolean unblock(ISubscriber subscriber, String channelName) {
		return PUB_SUB_SERVER_FACADE.unBlockSubscriber(subscriber, channelName); // proxy method for unblocking
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pubSub.local.ISubscriptionManagerProxy#block(subscribers.AbstractSubscriber,
	 * java.lang.String)
	 */
	@Override
	public boolean block(ISubscriber subscriber, String channelName) {
		return PUB_SUB_SERVER_FACADE.blockSubcriber(subscriber, channelName); // proxy method for blocking
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.local.ISubscriptionManagerProxy#checkIfBlocked(subscribers.
	 * AbstractSubscriber, java.lang.String)
	 */
	@Override
	public boolean checkIfBlocked(ISubscriber subscriber, String channelName) {
		return PUB_SUB_SERVER_FACADE.checkIfBlocked(subscriber, channelName);
	}

}
