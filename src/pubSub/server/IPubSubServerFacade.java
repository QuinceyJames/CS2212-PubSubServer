package pubSub.server;

import java.util.List;

import events.IEvent;
import publishers.IPublisher;
import subscribers.ISubscriber;

public interface IPubSubServerFacade {

	boolean blockSubcriber(ISubscriber subscriber, String channelName);

	boolean unBlockSubscriber(ISubscriber subscriber, String channelName);

	boolean checkIfBlocked(ISubscriber subscriber, String channelName);

	void postEvent(IEvent event, List<String> listOfChannels);

	List<IChannel> listChannels();

	IChannel findChannel(String channelTopic);

	IPublisher findPublisher(int publisherID);

	ISubscriber findSubscriber(int subscriberID);

	void subscribe(ISubscriber subscriber, String channelTopic);

	void unsubscribe(ISubscriber subscriber, String channelTopic);

}