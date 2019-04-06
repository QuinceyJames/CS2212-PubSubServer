package publishers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import strategies.publisher.StrategyName;

/**
 * @author kkontog, ktsiouni, mgrigori
 * 
 *         implements the Singleton Design Pattern
 * 
 *         holds the collection of AbstractChannel type entities and provides
 *         the methods for manipulating thes collections
 */
public class PublisherPoolManager {

	private static PublisherPoolManager INSTANCE = null;
	private Map<Integer, AbstractPublisher> publishersMap = new HashMap<>();

	private PublisherPoolManager() {
		try (Scanner scanner = new Scanner(new File("Strategies.str"))) {

			for (int publisherID = 0; scanner.hasNextLine(); publisherID++) {
				PublisherType publisherType = PublisherType.values()[scanner.nextInt()];
				StrategyName strategyName = StrategyName.values()[scanner.nextInt()];

				publishersMap.put(publisherID, PublisherFactory.createPublisher(publisherType, strategyName, publisherID));
			}
			
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	protected static PublisherPoolManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new PublisherPoolManager();
		
		return INSTANCE;
	}

	/**
	 * returns the object of AbstractChannel using a name as lookup information
	 * 
	 * @param channelName the name of the AbstractChannel to be returned
	 * @return the appropriate instance of an AbstractChannel subclass
	 */
	protected AbstractPublisher findPublisher(int publisherID) {
		return publishersMap.get(publisherID);
	}

}

