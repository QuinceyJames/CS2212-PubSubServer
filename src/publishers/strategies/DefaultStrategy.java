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
public class DefaultStrategy extends AbstractStrategy {

	/**
	 * Protected constructor for {@link DefaultStrategy}. To create this object use
	 * {@link StrategyFactory#createStrategy(StrategyName)}
	 * 
	 * @see AbstractStrategy#AbstractStrategy()
	 */
	protected DefaultStrategy() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see publishers.strategies.AbstractStrategy#doPublishStrategy(events.
	 * AbstractEvent, publishers.AbstractPublisher)
	 */
	@Override
	protected void doPublishStrategy(IEvent event, IPublisher publisher) {
		List<IChannel> channelList = CHANNEL_DISCOVERY.listChannels();

		ArrayList<String> outputList = new ArrayList<>();
		for (IChannel channel : channelList) {
			outputList.add(channel.getChannelTopic()); // add the channel without parameters
		}

		PUB_SUB_SERVER_FACADE.postEvent(event, outputList);
	}
}
