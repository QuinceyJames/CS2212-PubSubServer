package pubSubServer;

import java.util.List;

import subscribers.AbstractSubscriber;


/**
 * @author kkontog, ktsiouni, mgrigori
 * MUST IMPLEMENT the Singleton design pattern
 * Allows for the discovery of available channels for subscription from {@link AbstractSubscriber} that want to subscribe to them
 */
public class ChannelDiscovery {
	
	private static ChannelDiscovery INSTANCE = null;
	
	private ChannelDiscovery() {}
	
	public static ChannelDiscovery getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ChannelDiscovery(); //create a new instance if null
		return INSTANCE;
	}
	
	
	
	/**
	 * 
	 * @return a list of {@link AbstractChannel} type elements containing all available channels 
	 * currently in the PubSubServer 
	 */
	public List<AbstractChannel> listChannels() {
		return ChannelPoolManager.getInstance().listChannels();
	}

	/**
	 * @param channelName the topic/name of the looked-up channel
	 * @return a {@link AbstractChannel} type object corresponding the the channelName provided as input
	 */
	public AbstractChannel findChannel(String channelName) {
		return ChannelPoolManager.getInstance().getChannelsMap().get(channelName);
	}
	
}
