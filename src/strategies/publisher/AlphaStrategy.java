package strategies.publisher;

import java.util.ArrayList;
import java.util.List;

import events.AbstractEvent;
import pubSubServer.AbstractChannel;
import pubSubServer.ChannelDiscovery;
import pubSubServer.ChannelEventDispatcher;
import publishers.AbstractPublisher;

public class AlphaStrategy extends AbstractStrategy {

	protected AlphaStrategy() {
		super(); //Calls parent
	}

	public void doPublish(AbstractEvent event, AbstractPublisher publisher) {
		super.doPublish(event, publisher);
		List<AbstractChannel> channelList = ChannelDiscovery.getInstance().listChannels(); //Get the list of channels
		
		ArrayList<String> outputList = new ArrayList<>();
		for (AbstractChannel channel : channelList) {
			if (channel.getChannelTopic().length() <= 3) //add the channel topic if length is less than or equal to 3
				outputList.add(channel.getChannelTopic());
		}

		ChannelEventDispatcher.getInstance().postEvent(event, outputList); 
	}
}
