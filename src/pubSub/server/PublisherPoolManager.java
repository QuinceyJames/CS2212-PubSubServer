package pubSub.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import publishers.AbstractPublisher;
import publishers.IPublisherFactory;
import publishers.PublisherFactory;
import publishers.PublisherType;
import publishers.strategies.StrategyName;

/**
 * implements the Singleton Design Pattern holds the collection of
 * AbstractChannel type entities and provides the methods for manipulating these
 * collections
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
class PublisherPoolManager {

	/**
	 * A reference to the {@link PublisherFactory} singleton
	 */
	private static final IPublisherFactory PUBLISHER_FACTORY = PublisherFactory.getInstance();

	/**
	 * Attribute holding reference to the single instance of this class
	 */
	private static PublisherPoolManager INSTANCE = null;

	/**
	 * Map used as a list to hold existing {@link AbstractPublisher Publishers} and
	 * their respective {@link AbstractPublisher#publisherID IDs}
	 */
	private Map<Integer, AbstractPublisher> publishersMap = new HashMap<>();

	/**
	 * Creates {@link #publishersMap} based on input file, associating
	 * {@link AbstractPublisher Publishers} with
	 * {@link AbstractPublisher#publishingStrategy publishingStrategys}
	 */
	private PublisherPoolManager() {
		try (Scanner scanner = new Scanner(new File("Strategies.str"))) {

			// continue until all lines have been read in
			for (int publisherID = 0; scanner.hasNextLine(); publisherID++) {
				PublisherType type = PublisherType.values()[scanner.nextInt()];
				StrategyName name = StrategyName.values()[scanner.nextInt()];

				// create new publisher and add to list
				publishersMap.put(publisherID, PUBLISHER_FACTORY.createPublisher(type, name, publisherID));
			}

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Method controlling the constructor as per the Singleton Design Pattern that
	 * returns the one instance of {@link PublisherPoolManager} if it exists, and if
	 * it does not exist , create it.
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
	 * @param publisherID the {@link AbstractPublisher#publisherID ID} of the
	 *                    AbstractPublisher to be returned
	 * @return the appropriate instance of an AbstractPublisher subclass
	 */
	protected AbstractPublisher findPublisher(int publisherID) {
		return publishersMap.get(publisherID);
	}

}
