package subscribers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import states.subscriber.StateName;

/**
 * @author kkontog, ktsiouni, mgrigori
 * 
 *         implements the Singleton Design Pattern
 * 
 *         holds the collection of AbstractChannel type entities and provides
 *         the methods for manipulating thes collections
 */
public class SubscriberPoolManager {

	private static SubscriberPoolManager INSTANCE = null;
	private Map<AbstractSubscriber, Integer> subscribersMap = new HashMap<>();

	private SubscriberPoolManager() {
		try (Scanner scanner = new Scanner("States.sts")) {

			for (int subscriberID = 0; scanner.hasNextLine(); subscriberID++) {
				SubscriberType subscriberType = SubscriberType.values()[scanner.nextInt()];
				StateName stateName = StateName.values()[scanner.nextInt()];

				subscribersMap.put(SubscriberFactory.createSubscriber(subscriberType, stateName), subscriberID);
			}

		}
	}

	protected static SubscriberPoolManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SubscriberPoolManager();
		
		return INSTANCE;
	}

	/**
	 * returns the object of AbstractChannel using a name as lookup information
	 * 
	 * @param channelName the name of the AbstractChannel to be returned
	 * @return the appropriate instance of an AbstractChannel subclass
	 */
	protected AbstractSubscriber findSubscriber(int subscriberID) {
		for (Entry<AbstractSubscriber, Integer> entry : subscribersMap.entrySet())
			if (entry.getValue().equals(subscriberID))
				return entry.getKey();
		
		return null;
	}

	protected int findID(AbstractSubscriber subscriber) {
		return subscribersMap.get(subscriber);
	}
}
