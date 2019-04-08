package pubSub.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import subscribers.AbstractSubscriber;
import subscribers.ISubscriber;
import subscribers.ISubscriberFactory;
import subscribers.SubscriberFactory;
import subscribers.SubscriberType;
import subscribers.states.StateName;

/**
 * 
 * implements the Singleton Design Pattern
 * 
 * holds the collection of AbstractChannel type entities and provides the
 * methods for manipulating these collections
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public class SubscriberPoolManager {

	private static final ISubscriberFactory SUBSCRIBER_FACTORY = SubscriberFactory.getInstance();

	/**
	 * Attribute holding reference to the single instance of this class
	 */
	private static SubscriberPoolManager INSTANCE = null;

	/**
	 * Map used as a list to hold existing {@link AbstractSubscriber Subscribers}
	 * and their respective {@link AbstractSubscriber#subscriberID IDs}
	 */
	private Map<Integer, ISubscriber> subscribersMap = new HashMap<>();

	/**
	 * Creates {@link #subscribersMap} based on input file, associating
	 * {@link AbstractSubscriber Subscribers} with {@link AbstractSubscriber#state
	 * states}
	 */
	private SubscriberPoolManager() {
		try (Scanner scanner = new Scanner(new File("States.sts"))) {

			// continue until all lines have been read in
			for (int subscriberID = 0; scanner.hasNextLine(); subscriberID++) {
				SubscriberType type = SubscriberType.values()[scanner.nextInt()];
				StateName name = StateName.values()[scanner.nextInt()];

				// create new subscriber and add to list
				subscribersMap.put(subscriberID, SUBSCRIBER_FACTORY.createSubscriber(type, name, subscriberID));
			}

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Method controlling the constructor as per the Singleton Design Pattern that
	 * returns the one instance of {@link SubscriberPoolManager} if it exists, and
	 * if it does not exist , create it.
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
	 * @param subscriberID the {@link AbstractSubscriber#subscriberID ID} of the
	 *                     AbstractSubscriber to be returned
	 * @return the appropriate instance of an AbstractSubscriber subclass
	 */
	protected ISubscriber findSubscriber(int subscriberID) {
		return subscribersMap.get(subscriberID);
	}
}
