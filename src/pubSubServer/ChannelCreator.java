package pubSubServer;

/**
 * MUST IMPLEMENT the Singleton design pattern this class is responsible for
 * creating and deleting channels it's also the only class that can do so
 * 
 * @author kkontog, ktsiouni, mgrigori
 */
public class ChannelCreator {

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static ChannelCreator INSTANCE = null;

	/**
	 * A reference to the {@link ChannelPoolManager}
	 */
	private static final ChannelPoolManager CHANNEL_POOL_MANAGER = ChannelPoolManager.getInstance();

	/**
	 * A private constructor used to help implement the "Singleton Design Pattern"
	 */
	private ChannelCreator() {
	}

	/**
	 * Gets the Singleton instance of this class or creates it if it has not been
	 * instantiated before
	 * 
	 * @return the Singleton instance of this class
	 */
	public static ChannelCreator getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ChannelCreator(); // create a new instance if null

		return INSTANCE;
	}

	/**
	 * creates a new Channel and adds it to the list of Channels so that it can be
	 * discovered using the {@link ChannelDiscovery} methods
	 * 
	 * @param channelName name of the Channel to be created
	 * @return the new channel (of any type that extends the {@link AbstractChannel}
	 *         that has been created
	 */
	protected AbstractChannel addChannel(String channelName) {
		return CHANNEL_POOL_MANAGER.addChannel(channelName);
	}

	/**
	 * deletes a channel and removes it from all channels stores so that no one can
	 * access it anymore
	 * 
	 * @param channelName name of the channel to be deleted
	 */
	protected void deleteChannel(String channelName) {
		CHANNEL_POOL_MANAGER.deleteChannel(channelName);
	}

}
