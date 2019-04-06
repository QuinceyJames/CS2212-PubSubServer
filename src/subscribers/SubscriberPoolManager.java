package subscribers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import publishers.PublisherPoolManager;
import states.subscriber.StateName;

/**
 * @author kkontog, ktsiouni, mgrigori
 * 
 *         implements the Singleton Design Pattern
 * 
 *         holds the collection of AbstractChannel type entities and provides
 *         the methods for manipulating these collections
 */
public class SubscriberPoolManager {

	/**
	 * Attribute holding reference to the single instance of this class
	 */
	private static SubscriberPoolManager INSTANCE = new SubscriberPoolManager();
	
	
	/**
	 * Map used as a list to hold existing {@link AbstractSubscriber}s and their respective {@link AbstractSubscriber#subscriberID ID}s 
	 */
	private Map<Integer, AbstractSubscriber> subscribersMap = new HashMap<>();

	
	/**
	 * Creates {@link #subscribersMap} based on input file, associating {@link AbstractSubscriber}s with {@link AbstractSubscriber#state state}s
	 */
	private SubscriberPoolManager() {
		try (Scanner scanner = new Scanner(new File("States.sts"))) {

			for (int subscriberID = 0; scanner.hasNextLine(); subscriberID++) { //continue until all lines have been read in
				SubscriberType subscriberType = SubscriberType.values()[scanner.nextInt()];
				StateName stateName = StateName.values()[scanner.nextInt()];

				subscribersMap.put(subscriberID, SubscriberFactory.createSubscriber(subscriberType, stateName, subscriberID)); //create new subscriber and add to list
			}

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Method controlling the constructor as per the Singleton Design Pattern that returns
	 * the one instance of {@link SubscriberPoolManager} if it exists, and if it does not exist
	 * , create it.
	 * 
	 * @return is the existing instance of {@link SubscriberDiscovery}
	 */
	protected static SubscriberPoolManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SubscriberPoolManager();
		
		return INSTANCE;
	}

	/**
	 * returns {@link SubscriberDiscovery} using a name as lookup information
	 * 
	 * @param channelName the name of the AbstractChannel to be returned
	 * @return the appropriate instance of an AbstractChannel subclass
	 */
	protected AbstractSubscriber findSubscriber(int subscriberID) {
		return subscribersMap.get(subscriberID);
	}
}
