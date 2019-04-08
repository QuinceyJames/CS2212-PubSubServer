package publishers;

import baseEntities.AbstractEntity;
import events.IEvent;
import publishers.strategies.IStrategy;
import publishers.strategies.IStrategyFactory;
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
public abstract class AbstractPublisher extends AbstractEntity<Integer> implements IPublisher {

	/**
	 * A reference to the {@link StrategyFactory} singleton
	 */
	private static final IStrategyFactory STRATEGY_FACTORY = StrategyFactory.getInstance();

	/**
	 * Variable encapsulating the {@link IStrategy AbstractStrategy} associated with
	 * an {@link AbstractPublisher}
	 */
	protected IStrategy publishingStrategy;

	/**
	 * Protected Constructor for an {@link AbstractPublisher} that sets the
	 * {@link #publishingStrategy} and {@link #publisherID} for said Publisher. This
	 * ensures that only {@link PublisherFactory} can create publishers
	 * 
	 * All concrete publisher instances utilize this method.
	 * 
	 * @param strategyName is the {@link publishers.strategies.StrategyName
	 *                     StrategyName} of the publishingStrategy to be associated
	 *                     with the given {@link AbstractPublisher}.
	 * @param publisherID  is the {@link #publisherID} to be associated with the
	 *                     given {@link AbstractPublisher}.
	 */
	protected AbstractPublisher(StrategyName strategyName, int publisherID) {
		super(publisherID);

		this.publishingStrategy = STRATEGY_FACTORY.createStrategy(strategyName); // setting strategy

		// printing required output as per document using defined toString method in
		// AbstractPublisher
		System.out.println(String.format("%s has been created.", this));
	}

	@Override
	public String toString() {
		// creates string in the form "AlphaPublisher #1"
		return String.format("%s %d", getClass().getSimpleName(), getEntityID());
	}

	/**
	 * Sets the {@link IStrategy AbstractStrategy} for this
	 * {@link AbstractPublisher} implementation using the {@link StrategyFactory}
	 * 
	 * @param strategyName the entry from the {@link StrategyName} enumeration that
	 *                     we want the new AbstractStrategy of the AbstractPublisher
	 *                     to be
	 */
	public void setStrategy(IStrategy publishingStrategy) {
		this.publishingStrategy = publishingStrategy;

		// printing required output as per document using defined toString methods in
		// AbstractPublisher and AbstractStrategy
		System.out.println(String.format("%s has %s.", this, publishingStrategy));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see publishers.IPublisher#publish()
	 */
	@Override
	public void publish() {
		publishingStrategy.doPublish(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see publishers.IPublisher#publish(IEvent)
	 */
	@Override
	public void publish(IEvent event) {
		publishingStrategy.doPublish(event, this);
	}
}
