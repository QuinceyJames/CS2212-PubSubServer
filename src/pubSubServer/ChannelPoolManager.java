package pubSubServer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * implements the Singleton Design Pattern
 * 
 * holds the collection of AbstractChannel type entities and provides the
 * methods for manipulating these collections
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43  
 */
public class ChannelPoolManager {

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static ChannelPoolManager INSTANCE = null;

	/**
	 * A map of channel names to the object
	 */
	private final HashMap<String, AbstractChannel> channelsMap = new HashMap<String, AbstractChannel>();

	/**
	 * A private constructor used to help implement the "Singleton Design Pattern"
	 */
	private ChannelPoolManager() {
		try (BufferedReader channelListReader = new BufferedReader(new FileReader("Channels.chl"))) {

			while (channelListReader.ready())
				addChannel(channelListReader.readLine()); // read from Channel file and add to list of channels

		} catch (IOException e) {
			System.out.println("Error with loading from file, creating one no_theme_channel");
			addChannel("no_theme");
		}
	}

	/**
	 * Gets the Singleton instance of this class or creates it if it has not been
	 * instantiated before
	 * 
	 * @return the Singleton instance of this class
	 */
	protected static ChannelPoolManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ChannelPoolManager();

		return INSTANCE;
	}

	/**
	 * creates a new AbstractChannel, adds it to the collections and returns it to
	 * the caller
	 * 
	 * @param channelName the name of the new AbstractChannel
	 * @return the new AbstractChannel
	 */
	protected AbstractChannel addChannel(String channelName) {
		Channel ch = new Channel(channelName);
		channelsMap.put(channelName, ch);
		return ch;
	}

	/**
	 * removes an AbstractChannel from the collections of available AbstractChannels
	 * 
	 * @param channelName the name of the AbstractChannel to be removed
	 */
	protected void deleteChannel(String channelName) {
		channelsMap.remove(channelName);
	}

	/**
	 * can be used to list all the Channels available in the PubSubServer
	 * 
	 * @return a list of type {@link AbstractChannel}
	 */
	protected List<AbstractChannel> listChannels() {
		return new ArrayList<>(channelsMap.values());
	}

	/**
	 * returns the object of AbstractChannel using a name as lookup information
	 * 
	 * @param channelName the name of the AbstractChannel to be returned
	 * @return the appropriate instance of an AbstractChannel subclass
	 */
	protected AbstractChannel findChannel(String channelName) {
		return channelsMap.get(channelName);
	}

	/**
	 * accessor for the ChannelMap use with great caution
	 * 
	 * @return a Map from String to {@link AbstractChannel}
	 */
	protected Map<String, AbstractChannel> getChannelsMap() {
		return channelsMap;
	}

}
