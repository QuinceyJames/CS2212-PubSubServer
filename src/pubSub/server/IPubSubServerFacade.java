package pubSub.server;

import java.util.List;

import events.AbstractEvent;
import publishers.AbstractPublisher;
import subscribers.AbstractSubscriber;
import subscribers.ISubscriber;

public interface IPubSubServerFacade {

	boolean blockSubcriber(AbstractSubscriber subscriber, String channelName);

	boolean unBlockSubscriber(ISubscriber subscriber, String channelName);

	boolean checkIfBlocked(ISubscriber subscriber, String channelName);

	void postEvent(AbstractEvent event, List<String> listOfChannels);

	List<AbstractChannel> listChannels();

	AbstractChannel findChannel(String channelTopic);

	AbstractPublisher findPublisher(int publisherID);

	AbstractSubscriber findSubscriber(int subscriberID);

	void subscribe(AbstractSubscriber subscriber, String channelTopic);

	void unsubscribe(ISubscriber subscriber, String channelTopic);

}