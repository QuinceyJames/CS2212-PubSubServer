package publishers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import strategies.publisher.StrategyName;
import subscribers.AbstractSubscriber;
import subscribers.SubscriberDiscovery;
import subscribers.SubscriberPoolManager;

/**
 * @author kkontog, ktsiouni, mgrigori
 * 
 *         implements the Singleton Design Pattern
 * 
 *         holds the collection of AbstractChannel type entities and provides
 *         the methods for manipulating these collections
 */
public class PublisherPoolManager {
	
	/**
	 * Attribute holding reference to the single instance of this class
	 */
	private static PublisherPoolManager INSTANCE = null;

	/**
	 * Map used as a list to hold existing {@link AbstractPublisher}s and their respective {@link AbstractPublisher#publisherID ID}s 
	 */
	private Map<Integer, AbstractPublisher> publishersMap = new HashMap<>();

	/**
	 * Creates {@link #publishersMap} based on input file, associating {@link AbstractPublisher}s with {@link AbstractPublisher#publishingStrategy publishingStrategy}s
	 */
	private PublisherPoolManager() {
		try (Scanner scanner = new Scanner(new File("Strategies.str"))) {

			for (int publisherID = 0; scanner.hasNextLine(); publisherID++) { //continue until all lines have been read in
				PublisherType publisherType = PublisherType.values()[scanner.nextInt()];
				StrategyName strategyName = StrategyName.values()[scanner.nextInt()];

				publishersMap.put(publisherID, PublisherFactory.createPublisher(publisherType, strategyName, publisherID)); //create new publisher and add to list
			}
			
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Method controlling the constructor as per the Singleton Design Pattern that returns
	 * the one instance of {@link PublisherPoolManager} if it exists, and if it does not exist
	 * , create it.
	 * 
	 * @return is the existing instance of {@link PublisherPoolManager}
	 */
	protected static PublisherPoolManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new PublisherPoolManager();
		
		return INSTANCE;
	}

	/**
	 * returns {@link AbstractPublisher} using ID as lookup information
	 * 
	 * @param publisherID the {@link AbstractPublisher#publisherID ID} of the AbstractPublisher to be returned
	 * @return the appropriate instance of an AbstractPublisher subclass
	 */
	protected AbstractPublisher findPublisher(int publisherID) {
		return publishersMap.get(publisherID);
	}

}

