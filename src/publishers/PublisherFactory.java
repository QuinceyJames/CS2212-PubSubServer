package publishers;

import publishers.strategies.StrategyName;

/**
 * creates new {@link IPublisher} objects contributes to the Strategy design
 * pattern implements the FactoryMethod design pattern
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 * 
 */
public class PublisherFactory implements IPublisherFactory {

	/**
	 * A reference to the Singleton instance of this class
	 */
	private static IPublisherFactory INSTANCE = null;

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
	public static IPublisherFactory getInstance() {
		if (INSTANCE == null)
			INSTANCE = new PublisherFactory(); // create a new instance if null

		return INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see publishers.IPublisherFactory#createPublisher(publishers.PublisherType,
	 * publishers.strategies.StrategyName, int)
	 */
	@Override
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
