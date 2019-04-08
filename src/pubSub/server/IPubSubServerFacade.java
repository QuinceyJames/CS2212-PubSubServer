package pubSub.server;

import java.util.List;

import events.IEvent;
import publishers.IPublisher;
import subscribers.ISubscriber;

public interface IPubSubServerFacade {

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.server.IPubSubServerFacade#blockSubcriber(subscribers.
	 * AbstractSubscriber, java.lang.String)
	 */
	boolean blockSubcriber(ISubscriber subscriber, String channelName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.server.IPubSubServerFacade#unBlockSubscriber(subscribers.
	 * AbstractSubscriber, java.lang.String)
	 */
	boolean unBlockSubscriber(ISubscriber subscriber, String channelName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.server.IPubSubServerFacade#checkIfBlocked(subscribers.
	 * AbstractSubscriber, java.lang.String)
	 */
	boolean checkIfBlocked(ISubscriber subscriber, String channelName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.server.IPubSubServerFacade#postEvent(events.AbstractEvent,
	 * java.util.List)
	 */
	void postEvent(IEvent event, List<String> listOfChannels);

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.server.IPubSubServerFacade#listChannels()
	 */
	List<IChannel> listChannels();

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.server.IPubSubServerFacade#findChannel(java.lang.String)
	 */
	IChannel findChannel(String channelTopic);

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.server.IPubSubServerFacade#findPublisher(int)
	 */
	IPublisher findPublisher(int publisherID);

	/*
	 * (non-Javadoc)
	 * 
	 * @see pubSub.server.IPubSubServerFacade#findSubscriber(int)
	 */
	ISubscriber findSubscriber(int subscriberID);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pubSub.server.IPubSubServerFacade#subscribe(subscribers.AbstractSubscriber,
	 * java.lang.String)
	 */
	void subscribe(ISubscriber subscriber, String channelTopic);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pubSub.server.IPubSubServerFacade#unsubscribe(subscribers.AbstractSubscriber,
	 * java.lang.String)
	 */
	void unsubscribe(ISubscriber subscriber, String channelTopic);

}