package pubSubServer;

import java.util.List;

import events.AbstractEvent;
import publishers.AbstractPublisher;

/**
 * MUST IMPLEMENT the Singleton design pattern Class providing an interface for
 * {@link AbstractPublisher} objects to cover their publishing needs
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43 
 */
public class ChannelEventDispatcher {

	/**
	 * A reference to the {@link ChannelDiscovery} instance
	 */
	private static final ChannelDiscovery CHANNEL_DISCOVERY = ChannelDiscovery.getInstance();

	/**
	 * A reference to the {@link ChannelCreator} instance
	 */
	private static final ChannelCreator CHANNEL_CREATOR = ChannelCreator.getInstance();

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
	public static ChannelEventDispatcher getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ChannelEventDispatcher(); // create a new instance if null

		return INSTANCE;
	}

	/**
	 * Will post an {@link events.AbstractEvent Event} to the specified
	 * {@link AbstractChannel Channels}
	 * 
	 * @param event          event to be published
	 * @param listOfChannels list of channel names to which the event must be
	 *                       published to
	 */
	public void postEvent(AbstractEvent event, List<String> listOfChannels) {
		for (String channelName : listOfChannels) {
			AbstractChannel channel = CHANNEL_DISCOVERY.findChannel(channelName); // find the channel

			if (channel == null)
				channel = CHANNEL_CREATOR.addChannel(channelName); // if channel is null, create

			channel.publishEvent(event); // publish the event to the channel
		}
	}
}
