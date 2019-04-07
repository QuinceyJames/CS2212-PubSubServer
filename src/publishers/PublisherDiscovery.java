package publishers;


/**
 * Implements the Singleton design pattern. 
 * 
 * Allows for the discovery of existing {@link AbstractPublisher} s.
 * 
 * @author rblack43
 * 
 */
public class PublisherDiscovery {

	
	/**
	 * Attribute holding reference to the {@link PublisherPoolManager} to access list of current publishers
	 */
	private static final PublisherPoolManager POOL_MANAGER = PublisherPoolManager.getInstance();
	
	
	/**
	 * Attribute holding reference to the single instance of this class
	 */
	private static PublisherDiscovery INSTANCE = null;

	
	/**
	 * Private constructor as per the Singleton Design Pattern
	 */
	private PublisherDiscovery() {}

	
	/**
	 * Method controlling the constructor as per the Singleton Design Pattern that returns
	 * the one instance of {@link PublisherDiscovery} if it exists, and if it does not exist
	 * , create it.
	 * 
	 * @return is the existing instance of {@link PublisherDiscovery}
	 */
	public static PublisherDiscovery getInstance() {
		if (INSTANCE == null)
			INSTANCE = new PublisherDiscovery();
		
		return INSTANCE;
	}

	/**
	 * Function to find and return an {@link AbstractPublisher} given an {@link AbstractPublisher#publisherID ID}
	 * 
	 * @param publisherID the ID number of the looked-up publisher
	 * @return a {@link AbstractPublisher} type object corresponding the the ID
	 *         provided as input
	 */
	public AbstractPublisher findPublisher(int publisherID) { 
		return POOL_MANAGER.findPublisher(publisherID); 
	}
}
