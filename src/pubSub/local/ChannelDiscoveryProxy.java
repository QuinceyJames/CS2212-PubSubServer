package pubSub.local;

import java.util.List;

import pubSub.server.AbstractChannel;
import pubSub.server.IChannel;
import pubSub.server.IPubSubServerFacade;
import pubSub.server.PubSubServerFacade;
import subscribers.ISubscriber;

/**
 * MUST IMPLEMENT the Singleton design pattern Allows for the discovery of
 * available channels for subscription from {@link ISubscriber} that want to
 * subscribe to them
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class ChannelDiscoveryProxy implements IDiscoveryProxy<IChannel, String> {

	private static final IPubSubServerFacade PUB_SUB_SERVER_FACADE = PubSubServerFacade.getInstance();
	/**
	 * A reference to the Singleton instance of this class
	 */
	private static ChannelDiscoveryProxy INSTANCE = null;

	/**
	 * A private constructor used to help implement the "Singleton Design Pattern"
	 */
	private ChannelDiscoveryProxy() {
	}

	/**
	 * Gets the Singleton instance of this class or creates it if it has not been
	 * instantiated before
	 * 
	 * @return the Singleton instance of this class
	 */
	public static ChannelDiscoveryProxy getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ChannelDiscoveryProxy(); // create a new instance if null

		return INSTANCE;
	}

	/**
	 * 
	 * @return a list of {@link AbstractChannel} type elements containing all
	 *         available channels currently in the PubSubServer
	 */
	public List<IChannel> listChannels() {
		return PUB_SUB_SERVER_FACADE.listChannels();
	}

	/**
	 * @param channelName the topic/name of the looked-up channel
	 * @return a {@link IChannel} type object corresponding the the channelName
	 *         provided as input
	 */
	public IChannel findUsingID(String channelName) {
		return PUB_SUB_SERVER_FACADE.findChannel(channelName);
	}

}
