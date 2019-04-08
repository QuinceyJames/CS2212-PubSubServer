package publishers.strategies;

import java.util.ArrayList;
import java.util.List;

import events.IEvent;
import pubSub.server.IChannel;
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
	 * @see publishers.strategies.AbstractStrategy#doPublishStrategy(IEvent,
	 * IPublisher)
	 */
	@Override
	protected void doPublishStrategy(IEvent event, IPublisher publisher) {
		List<IChannel> channelList = CHANNEL_DISCOVERY.listChannels();

		ArrayList<String> outputList = new ArrayList<>();
		for (IChannel channel : channelList) {
			if (channel.getChannelTopic().length() == 4) // add if the length of topic is 4
				outputList.add(channel.getChannelTopic());
		}

		PUB_SUB_SERVER_FACADE.postEvent(event, outputList);
	}
}
