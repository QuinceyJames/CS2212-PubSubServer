package publishers;

import publishers.strategies.StrategyName;

public interface IPublisherFactory {

	/**
	 * creates a new {@link IPublisher} using an entry from the
	 * {@link PublisherType} enumeration
	 * 
	 * @param type         a value from the {@link PublisherType} enumeration
	 *                     specifying the type of Publisher to be created.
	 * @param strategyName {@link publishers.strategies.StrategyName StrategyName}
	 *                     of the {@link AbstractPublisher} to be associated with
	 *                     {@link IPublisher}.
	 * @param publisherID  ID to be associated with the given {@link IPublisher}.
	 * @return the newly created {@link IPublisher} instance
	 */
	AbstractPublisher createPublisher(PublisherType type, StrategyName strategyName, int publisherID);

}