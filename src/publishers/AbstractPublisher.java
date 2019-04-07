package publishers;

import baseEntities.IEntity;
import events.AbstractEvent;
import publishers.strategies.AbstractStrategy;
import publishers.strategies.StrategyFactory;
import publishers.strategies.StrategyName;

/**
 * 
 * Package-Protected class that implements the "State Design Pattern". It forces
 * all implementing classes to define an interchangeable state that is
 * encapsulated in the concrete classes. This allows for easy incorporation of
 * various states that can define unique logic. These classes should not be used
 * outside of this package.
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
public abstract class AbstractPublisher implements IEntity {

	/**
	 * A reference to the {@link StrategyFactory} singleton
	 */
	private static final StrategyFactory STRATEGY_FACTORY = StrategyFactory.getInstance();

	/**
	 * Variable encapsulating the {@link publishers.strategies.AbstractStrategy
	 * AbstractStrategy} associated with an {@link AbstractPublisher}
	 */
	protected AbstractStrategy publishingStrategy;

	/**
	 * Variable encapsulating the ID number associated with an
	 * {@link AbstractPublisher}
	 */
	protected int publisherID;

	/**
	 * Protected Constructor for an {@link AbstractPublisher} that sets the
	 * {@link #publishingStrategy} and {@link #publisherID} for said Publisher. This
	 * ensures that only {@link PublisherFactory} can create publishers
	 * 
	 * All concrete publisher instances utilize this method.
	 * 
	 * @param strategyName is the {@link publishers.strategies.StrategyName
	 *                     StrategyName} of the {@link publishingStrategy} to be
	 *                     associated with the given {@link AbstractPublisher}.
	 * @param publisherID  is the {@link #publisherID} to be associated with the
	 *                     given {@link AbstractPublisher}.
	 */
	protected AbstractPublisher(StrategyName strategyName, int publisherID) {
		this.publishingStrategy = STRATEGY_FACTORY.createStrategy(strategyName); // setting strategy
		this.publisherID = publisherID; // setting ID

		// printing required output as per document using defined toString method in
		// AbstractPublisher
		System.out.println(String.format("%s has been created.", this));
	}

	@Override
	public String toString() {
		// creates string in the form "AlphaPublisher #1"
		return String.format("%s %d", getClass().getSimpleName(), publisherID);
	}

	/**
	 * Sets the {@link publishers.strategies.AbstractStrategy AbstractStrategy} for
	 * this {@link AbstractPublisher} implementation using the
	 * {@link StrategyFactory}
	 * 
	 * @param strategyName the entry from the {@link StrategyName} enumeration that
	 *                     we want the new AbstractStrategy of the AbstractPublisher
	 *                     to be
	 */
	public void setStrategy(AbstractStrategy publishingStrategy) {
		this.publishingStrategy = publishingStrategy;

		// printing required output as per document using defined toString methods in
		// AbstractPublisher and AbstractStrategy
		System.out.println(String.format("%s has %s.", this, publishingStrategy));
	}

	/**
	 * Method to publish a default event via the {@link #publishingStrategy} that is
	 * also generated by this strategy, in the case that an event was not specified
	 */
	public void publish() {
		publishingStrategy.doPublish(this);
	}

	/**
	 * Method to publish event specified as per the parameter via the
	 * {@link #publishingStrategy} in the case that an event was specified
	 *
	 * @param event event specified to be published
	 */
	public void publish(AbstractEvent event) {
		publishingStrategy.doPublish(event, this);
	}
}
