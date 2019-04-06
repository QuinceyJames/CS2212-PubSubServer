package publishers;

import baseEntities.IEntity;
import events.AbstractEvent;
import strategies.publisher.AbstractStrategy;
import strategies.publisher.StrategyFactory;
import strategies.publisher.StrategyName;

/**
 * @author kkontog, ktsiouni, mgrigori base Interface implemented by all
 *         ConcretePublisher Classes
 */
public abstract class AbstractPublisher implements IEntity, Comparable<AbstractPublisher> {

	protected AbstractStrategy publishingStrategy;
	protected int publisherID;

	protected AbstractPublisher(StrategyName strategyName, int publisherID) {
		this.publishingStrategy = StrategyFactory.createStrategy(strategyName);
		this.publisherID = publisherID;
		System.out.println(String.format("%s has been created", this));
		System.out.println(String.format("%s has %s", this, publishingStrategy));
	}

	@Override
	public String toString() {
		return String.format("%s with ID %d", getClass().getSimpleName(), publisherID);
	} 

	public void setStrategy(AbstractStrategy publishingStrategy) {
		if (publishingStrategy == null)
			System.out.println("CANNOT BE NULL");
		else {
			this.publishingStrategy = publishingStrategy;
			System.out.println(String.format("%s has %s", this, publishingStrategy));
		}
	}

	/**
	 * all implementations of this Interface MUST contain an instance variable of
	 * type {@link IStrategy} which has the methods: 1)
	 * {@link IStrategy#doPublish(int)} 2)
	 * {@link IStrategy#doPublish(AbstractEvent, int)} which allows for the
	 * publishing of an {@link AbstractEvent} object
	 * 
	 * @param event an event which is to be published
	 * 
	 */
	public void publish() {
		publishingStrategy.doPublish(this);
	}

	public void publish(AbstractEvent event) {
		publishingStrategy.doPublish(event, this);
	}

	@Override
	public int compareTo(AbstractPublisher o) {
		return o.publisherID - publisherID;
	}
}
