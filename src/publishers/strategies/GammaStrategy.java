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
public class GammaStrategy extends AbstractStrategy {

	/**
	 * Protected constructor for {@link GammaStrategy}. To create this object use
	 * {@link StrategyFactory#createStrategy(StrategyName)}
	 * 
	 * @see AbstractStrategy#AbstractStrategy()
	 */
	protected GammaStrategy() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see publishers.strategies.AbstractStrategy#doPublishStrategy(events.IEvent,
	 * publishers.IPublisher)
	 */
	@Override
	protected void doPublishStrategy(IEvent event, IPublisher publisher) {
		List<IChannel> channelList = CHANNEL_DISCOVERY.listChannels();

		ArrayList<String> outputList = new ArrayList<>();
		for (IChannel channel : channelList) {
			if (channel.getChannelTopic().length() == 5) // add a channel if it is length 5
				outputList.add(channel.getChannelTopic());
		}

		PUB_SUB_SERVER_FACADE.postEvent(event, outputList);
	}
}
