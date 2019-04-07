package subscribers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import publishers.AbstractPublisher;
import publishers.PublisherPoolManager;
import states.subscriber.StateName;

/**
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2, rblack43
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
	 * @return is the existing instance of {@link SubscriberPoolManager}
	 */
	protected static SubscriberPoolManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SubscriberPoolManager();
		
		return INSTANCE;
	}

	/**
	 * returns {@link AbstractSubscriber} using ID as lookup information
	 * 
	 * @param subscriberID the {@link AbstractSubscriber#subscriberID ID} of the AbstractSubscriber to be returned
	 * @return the appropriate instance of an AbstractSubscriber subclass
	 */
	protected AbstractSubscriber findSubscriber(int subscriberID) {
		return subscribersMap.get(subscriberID);
	}
}
