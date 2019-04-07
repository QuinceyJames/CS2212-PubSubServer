package strategies.publisher;

import java.util.ArrayList;
import java.util.List;

import events.AbstractEvent;
import pubSubServer.AbstractChannel;
import pubSubServer.ChannelDiscovery;
import pubSubServer.ChannelEventDispatcher;
import publishers.AbstractPublisher;
import states.subscriber.StateName;
import subscribers.AbstractSubscriber;

/**
 * first instance of a concrete strategy
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public class AlphaStrategy extends AbstractStrategy {

	/**
	 * (non-Javadoc)
	 * 
	 * @see AbstractStrategy#AbstractStrategy()
	 */
	protected AlphaStrategy() {
		super(); //Calls parent
	}

	/* (non-Javadoc)
	 * 
	 * @see strategies.publisher.AbstractStrategy#doPublish(events.AbstractEvent, publishers.AbstractPublisher)
	 */
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
