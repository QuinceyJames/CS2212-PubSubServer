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
public class BetaStrategy extends AbstractStrategy {

	/**
	 * Protected constructor for {@link BetaStrategy}. To create this object use
	 * {@link StrategyFactory#createStrategy(StrategyName)}
	 * 
	 * @see AbstractStrategy#AbstractStrategy()
	 */
	protected BetaStrategy() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see publishers.strategies.AbstractStrategy#doPublishStrategy(events.
	 * AbstractEvent, publishers.AbstractPublisher)
	 */
	@Override
	protected void doPublishStrategy(AbstractEvent event, IPublisher publisher) {
		List<AbstractChannel> channelList = ChannelDiscoveryProxy.getInstance().listChannels();

		ArrayList<String> outputList = new ArrayList<>();
		for (AbstractChannel channel : channelList) {
			if (channel.getChannelTopic().length() == 4) // add if the length of topic is 4
				outputList.add(channel.getChannelTopic());
		}

		PubSubServerFacade.getInstance().postEvent(event, outputList);
	}
}
