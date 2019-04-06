package strategies.publisher;

import java.util.ArrayList;
import java.util.List;

import events.AbstractEvent;
import pubSubServer.AbstractChannel;
import pubSubServer.ChannelDiscovery;
import pubSubServer.ChannelEventDispatcher;
import publishers.AbstractPublisher;

public class BetaStrategy extends AbstractStrategy {

	protected BetaStrategy() {
		super();
	}
	
	public void doPublish(AbstractEvent event, AbstractPublisher publisher) {
		List<AbstractChannel> channelList = ChannelDiscovery.getInstance().listChannels();

		ArrayList<String> outputList = new ArrayList<>();
		for (AbstractChannel channel : channelList) {
			if (channel.getChannelTopic().length() == 4) //add if the length of topic is 4
				outputList.add(channel.getChannelTopic());
		}

		ChannelEventDispatcher.getInstance().postEvent(event, outputList);
	}
}
