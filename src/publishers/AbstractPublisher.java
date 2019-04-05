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
public abstract class AbstractPublisher implements IEntity {

	protected AbstractStrategy publishingStrategy;

	// Package-private method
	AbstractPublisher(StrategyName strategyName) {
		this.publishingStrategy = StrategyFactory.createStrategy(strategyName);
		//TODO add publisher discovery such that we can print IDs here 
		System.out.println(this + " has been created.");
		System.out.println(this + " has " + this.publishingStrategy + ".");
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

	public void setStrategy(AbstractStrategy publishingStrategy) {
		if (publishingStrategy == null)
			System.out.println("CANNOT BE NULL");
		else
			this.publishingStrategy = publishingStrategy;
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
		publishingStrategy.doPublish(event);
	}
}
