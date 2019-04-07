package publishers.strategies;

import java.util.ArrayList;
import java.util.List;

import events.AbstractEvent;
import pubSub.local.ChannelDiscoveryProxy;
import pubSub.server.AbstractChannel;
import pubSub.server.PubSubServerFacade;
import publishers.IPublisher;

/**
 * An implementation of a concrete {@link AbstractStrategy}
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public class AlphaStrategy extends AbstractStrategy {

	/**
	 * A reference to the {@link pubSub.local.ChannelDiscoveryProxy} singleton
	 */
	private static final ChannelDiscoveryProxy CHANNEL_DISCOVERY = ChannelDiscoveryProxy.getInstance();

	/**
	 * Protected constructor for {@link AlphaStrategy}. To create this object use
	 * {@link StrategyFactory#createStrategy(StrategyName)}
	 * 
	 * @see AbstractStrategy#AbstractStrategy()
	 */
	protected AlphaStrategy() {
		super(); // Calls parent
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * publishers.strategies.AbstractStrategy#doPublishStrategy(events.AbstractEvent,
	 * publishers.AbstractPublisher)
	 */
	@Override
	protected void doPublishStrategy(AbstractEvent event, IPublisher publisher) {
		List<AbstractChannel> channelList = CHANNEL_DISCOVERY.listChannels(); // Get the list of channels

		ArrayList<String> outputList = new ArrayList<>();
		for (AbstractChannel channel : channelList) {
			if (channel.getChannelTopic().length() <= 3) // add the channel topic if length is less than or equal to 3
				outputList.add(channel.getChannelTopic());
		}

		PubSubServerFacade.getInstance().postEvent(event, outputList);
	}

}
