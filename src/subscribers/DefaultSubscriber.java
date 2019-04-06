package subscribers;

import java.util.ArrayList;
import java.util.List;

import events.AbstractEvent;
import pubSubServer.AbstractChannel;
import pubSubServer.ChannelDiscovery;
import pubSubServer.ChannelEventDispatcher;
import publishers.AbstractPublisher;
import states.subscriber.StateFactory;
import states.subscriber.StateName;

/**
 * @author kkontog, ktsiouni, mgrigori an example concrete subscriber
 */
public class DefaultSubscriber extends AbstractSubscriber {

	protected DefaultSubscriber(StateName stateName, int subscriberID) {
		super(stateName, subscriberID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see subscribers.ISubscriber#setState(states.subscriber.StateName)
	 */
	public void setState(StateName stateName) {
		state = StateFactory.createState(stateName);
	}

	public void doPublish(AbstractEvent event, AbstractPublisher publisher) {
		List<AbstractChannel> channelList = ChannelDiscovery.getInstance().listChannels();

		ArrayList<String> outputList = new ArrayList<>();
		for (AbstractChannel channel : channelList) {
			if (channel.getChannelTopic().length() > 6)
				outputList.add(channel.getChannelTopic());
		}

		ChannelEventDispatcher.getInstance().postEvent(event, outputList);
	}
}
