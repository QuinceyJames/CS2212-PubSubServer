
package pubSubServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import subscribers.AbstractSubscriber;


/**
 * @author kkontog, ktsiouni, mgrigori
 * MUST Implements the Singleton design pattern
 * Class that acts as an access control module that allows for the 
 * blocking and unblocking of specific subscribers for specific channels
 * 
 */

public class ChannelAccessControl {

	private static ChannelAccessControl instance = null;
	Map<String, TreeSet<AbstractSubscriber>> blackList = new HashMap<>();
	
	private ChannelAccessControl() {}
	
	protected static ChannelAccessControl getInstance() {
		if (instance == null)
			instance = new ChannelAccessControl();
		return instance;
	}
	
	
	/**
	 * 
	 * blocks the provided subscriber from accessing the designated channel
	 * @param subscriber an instance of any implementation of {@link AbstractSubscriber}
	 * @param channelName a String value representing a valid channel name
	 * @return 
	 */
	protected boolean blockSubcriber(AbstractSubscriber subscriber, String channelName) {
		TreeSet<AbstractSubscriber> blockedSubscribers = blackList.getOrDefault(channelName, new TreeSet<AbstractSubscriber>());
		boolean result = blockedSubscribers.add(subscriber);
		blackList.put(channelName, blockedSubscribers);
		System.out.println("Subscriber " + subscriber.toString() + " is blocked on channel " + channelName);
		return result;
	}

	/**
	 * unblocks the provided subscriber from accessing the designated channel
	 * @param subscriber an instance of any implementation of {@link AbstractSubscriber}
	 * @param channelName a String value representing a valid channel name
	 * @return 
	 */
	protected boolean unBlockSubscriber(AbstractSubscriber subscriber, String channelName) {
		
		TreeSet<AbstractSubscriber> blockedSubscribers;
		if((blockedSubscribers = blackList.get(channelName)) == null)
			return false;
		System.out.println("Subscriber " + subscriber.toString() + " is un-blocked on channel " + channelName);
		return blockedSubscribers.remove(subscriber);
	}

	
	/**
	 * checks if the provided subscriber is blocked from accessing the specified channel
	 * @param subscriber an instance of any implementation of {@link AbstractSubscriber}
	 * @param channelName a String value representing a valid channel name
	 * @return true if blocked false otherwise
	 */
	protected boolean checkIfBlocked(AbstractSubscriber subscriber, String channelName) {
		
		TreeSet<AbstractSubscriber> blockedSubscribers;
		if((blockedSubscribers = blackList.get(channelName)) == null)
			return false;
		return (blockedSubscribers.contains(subscriber));
	}


	
	
}
