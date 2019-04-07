package publishers;

import strategies.publisher.StrategyName;

/**
 * @author kkontog, ktsiouni, mgrigori creates new {@link AbstractPublisher}
 *         objects contributes to the Strategy design pattern implements the
 *         FactoryMethod design pattern
 */
public class PublisherFactory {

	/**
	 * creates a new {@link AbstractPublisher} using an entry from the {@link PublisherType} enumeration
	 * @param publisherType a value from the {@link PublisherType} enumeration specifying the type of Publisher to be created.
	 * @param strategyName {@link strategies.publisher.StrategyName StrategyName} of the {@link strategy} to be associated with {@link AbstractPublisher}.
	 * @param publisherID {@link #publisherID} to be associated with the given {@link AbstractPublisher}.
	 * @return the newly created {@link AbstractPublisher} instance 
	 */
	public static AbstractPublisher createPublisher(PublisherType publisherType, StrategyName strategyName, int publisherID) {
		switch (publisherType) {
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
