package pubSub.server;

import java.util.List;

import events.AbstractEvent;
import publishers.AbstractPublisher;
import subscribers.AbstractSubscriber;
import subscribers.ISubscriber;

public class PubSubServerFacade implements IPubSubServerFacade {
	private static final ChannelAccessControl CHANNEL_ACCESS_CONTROL = ChannelAccessControl.getInstance();
	private static final ChannelEventDispatcher CHANNEL_EVENT_DISPATCHER = ChannelEventDispatcher.getInstance();
	private static final ChannelPoolManager CHANNEL_POOL_MANAGER = ChannelPoolManager.getInstance();
	private static final PublisherPoolManager PUBLISHER_POOL_MANAGER = PublisherPoolManager.getInstance();
	private static final SubscriberPoolManager SUBSCRIBER_POOL_MANAGER = SubscriberPoolManager.getInstance();
	/**
	 * A reference to the Singleton instance of this class
	 */
	private static IPubSubServerFacade INSTANCE = null;

	/**
	 * A private constructor used to help implement the "Singleton Design Pattern"
	 */
	private PubSubServerFacade() {
	}

	/**
	 * Gets the Singleton instance of this class or creates it if it has not been
	 * instantiated before
	 * 
	 * @return the Singleton instance of this class
	 */
	public static IPubSubServerFacade getInstance() {
		if (INSTANCE == null)
			INSTANCE = new PubSubServerFacade(); // create a new instance if null

		return INSTANCE;
	}

	/* (non-Javadoc)
	 * @see pubSub.server.IPubSubServerFacade#blockSubcriber(subscribers.AbstractSubscriber, java.lang.String)
	 */
	@Override
	public boolean blockSubcriber(AbstractSubscriber subscriber, String channelName) {
		return CHANNEL_ACCESS_CONTROL.blockSubcriber(subscriber, channelName);
	}

	/* (non-Javadoc)
	 * @see pubSub.server.IPubSubServerFacade#unBlockSubscriber(subscribers.AbstractSubscriber, java.lang.String)
	 */
	@Override
	public boolean unBlockSubscriber(ISubscriber subscriber, String channelName) {
		return CHANNEL_ACCESS_CONTROL.unBlockSubscriber(subscriber, channelName);
	}

	/* (non-Javadoc)
	 * @see pubSub.server.IPubSubServerFacade#checkIfBlocked(subscribers.AbstractSubscriber, java.lang.String)
	 */
	@Override
	public boolean checkIfBlocked(ISubscriber subscriber, String channelName) {
		return CHANNEL_ACCESS_CONTROL.checkIfBlocked(subscriber, channelName);
	}

	/* (non-Javadoc)
	 * @see pubSub.server.IPubSubServerFacade#postEvent(events.AbstractEvent, java.util.List)
	 */
	@Override
	public void postEvent(AbstractEvent event, List<String> listOfChannels) {
		CHANNEL_EVENT_DISPATCHER.postEvent(event, listOfChannels);
	}

	/* (non-Javadoc)
	 * @see pubSub.server.IPubSubServerFacade#listChannels()
	 */
	@Override
	public List<AbstractChannel> listChannels() {
		return CHANNEL_POOL_MANAGER.listChannels();
	}

	/* (non-Javadoc)
	 * @see pubSub.server.IPubSubServerFacade#findChannel(java.lang.String)
	 */
	@Override
	public AbstractChannel findChannel(String channelTopic) {
		return CHANNEL_POOL_MANAGER.findChannel(channelTopic);
	}

	/* (non-Javadoc)
	 * @see pubSub.server.IPubSubServerFacade#findPublisher(int)
	 */
	@Override
	public AbstractPublisher findPublisher(int publisherID) {
		return PUBLISHER_POOL_MANAGER.findPublisher(publisherID);
	}

	/* (non-Javadoc)
	 * @see pubSub.server.IPubSubServerFacade#findSubscriber(int)
	 */
	@Override
	public AbstractSubscriber findSubscriber(int subscriberID) {
		return SUBSCRIBER_POOL_MANAGER.findSubscriber(subscriberID);
	}

	/* (non-Javadoc)
	 * @see pubSub.server.IPubSubServerFacade#subscribe(subscribers.AbstractSubscriber, java.lang.String)
	 */
	@Override
	public void subscribe(AbstractSubscriber subscriber, String channelTopic) {
		findChannel(channelTopic).subscribe(subscriber);
	}

	/* (non-Javadoc)
	 * @see pubSub.server.IPubSubServerFacade#unsubscribe(subscribers.AbstractSubscriber, java.lang.String)
	 */
	@Override
	public void unsubscribe(ISubscriber subscriber, String channelTopic) {
		findChannel(channelTopic).unsubscribe(subscriber);
	}

}
