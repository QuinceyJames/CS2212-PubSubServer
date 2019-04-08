package pubSub.server;

import java.util.List;

import events.IEvent;
import publishers.IPublisher;

/**
 * MUST IMPLEMENT the Singleton design pattern Class providing an interface for
 * {@link IPublisher} objects to cover their publishing needs
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class ChannelEventDispatcher {

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static ChannelEventDispatcher INSTANCE = null;

	/**
	 * A private constructor used to help implement the "Singleton Design Pattern"
	 */
	private ChannelEventDispatcher() {
	}

	/**
	 * Gets the Singleton instance of this class or creates it if it has not been
	 * instantiated before
	 * 
	 * @return the Singleton instance of this class
	 */
	protected static ChannelEventDispatcher getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ChannelEventDispatcher(); // create a new instance if null

		return INSTANCE;
	}

	/**
	 * Will post an {@link events.IEvent Event} to the specified
	 * {@link AbstractChannel Channels}
	 * 
	 * @param event          event to be published
	 * @param listOfChannels list of channel names to which the event must be
	 *                       published to
	 */
	protected void postEvent(IEvent event, List<String> listOfChannels) {
		for (String channelName : listOfChannels) {
			AbstractChannel channel = ChannelPoolManager.getInstance().findChannel(channelName); // find the channel

			if (channel == null)
				channel = ChannelPoolManager.getInstance().addChannel(channelName); // if channel is null, create

			channel.publishEvent(event); // publish the event to the channel
		}
	}
}
