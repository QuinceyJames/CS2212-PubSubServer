package pubSub.local;

import java.util.List;

import pubSub.server.AbstractChannel;
import pubSub.server.PubSubServerFacade;
import subscribers.AbstractSubscriber;

/**
 * MUST IMPLEMENT the Singleton design pattern Allows for the discovery of
 * available channels for subscription from {@link AbstractSubscriber} that want
 * to subscribe to them
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class ChannelDiscoveryProxy implements IDiscoveryProxy<AbstractChannel, String> {

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
	public List<AbstractChannel> listChannels() {
		return PubSubServerFacade.getInstance().listChannels();
	}

	/**
	 * @param channelName the topic/name of the looked-up channel
	 * @return a {@link AbstractChannel} type object corresponding the the
	 *         channelName provided as input
	 */
	public AbstractChannel findUsingID(String channelName) {
		return PubSubServerFacade.getInstance().findChannel(channelName);
	}

}
