package publishers;

import strategies.publisher.StrategyName;

/**
 * creates new {@link AbstractPublisher} objects contributes to the Strategy
 * design pattern implements the FactoryMethod design pattern
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 * 
 */
public class PublisherFactory {

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static PublisherFactory INSTANCE = null;

	/**
	 * A private constructor used to help implement the "Singleton Design Pattern"
	 */
	private PublisherFactory() {
	}

	/**
	 * Gets the Singleton instance of this class or creates it if it has not been
	 * instantiated before
	 * 
	 * @return the Singleton instance of this class
	 */
	public static PublisherFactory getInstance() {
		if (INSTANCE == null)
			INSTANCE = new PublisherFactory(); // create a new instance if null

		return INSTANCE;
	}

	/**
	 * creates a new {@link AbstractPublisher} using an entry from the
	 * {@link PublisherType} enumeration
	 * 
	 * @param type         a value from the {@link PublisherType} enumeration
	 *                     specifying the type of Publisher to be created.
	 * @param strategyName {@link strategies.publisher.StrategyName StrategyName} of
	 *                     the {@link strategy} to be associated with
	 *                     {@link AbstractPublisher}.
	 * @param publisherID  {@link #publisherID} to be associated with the given
	 *                     {@link AbstractPublisher}.
	 * @return the newly created {@link AbstractPublisher} instance
	 */
	public AbstractPublisher createPublisher(PublisherType type, StrategyName strategyName, int publisherID) {

		switch (type) {
		case ALPHA_PUBLISHER:
			return new AlphaPublisher(strategyName, publisherID);

		case BETA_PUBLISHER:
			return new BetaPublisher(strategyName, publisherID);

		case GAMMA_PUBLISHER:
			return new GammaPublisher(strategyName, publisherID);

		default:
			return new DefaultPublisher(strategyName, publisherID);
		}

	}

}
