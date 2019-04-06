package pubSubServer;

import java.util.List;

import events.AbstractEvent;
import publishers.AbstractPublisher;

/**
 * @author kkontog, ktsiouni, mgrigori MUST IMPLEMENT the Singleton design
 *         pattern Class providing an interface for {@link AbstractPublisher}
 *         objects to cover their publishing needs
 */
public class ChannelEventDispatcher {

	private static final ChannelDiscovery CHANNEL_DISCOVERY = ChannelDiscovery.getInstance();
	private static final ChannelCreator CHANNEL_CREATOR = ChannelCreator.getInstance();
	private static ChannelEventDispatcher INSTANCE = null;

	private ChannelEventDispatcher() {
	}

	public static ChannelEventDispatcher getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ChannelEventDispatcher();

		return INSTANCE;
	}

	/**
	 * @param event          event to be published
	 * @param listOfChannels list of channel names to which the event must be
	 *                       published to
	 */
	public void postEvent(AbstractEvent event, List<String> listOfChannels) {
		for (String channelName : listOfChannels) {
			AbstractChannel channel = CHANNEL_DISCOVERY.findChannel(channelName);

			if (channel == null)
				channel = CHANNEL_CREATOR.addChannel(channelName);

			channel.publishEvent(event);
		}

		// System.out.println(String.format("%s publishes %s", event.))
	}
}
