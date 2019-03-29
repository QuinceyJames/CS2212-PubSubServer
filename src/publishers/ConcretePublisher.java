package publishers;

import events.AbstractEvent;
import strategies.publisher.IStrategy;
import strategies.publisher.StrategyFactory;

/**
 * @author kkontog, ktsiouni, mgrigori
 * 
 *         the WeatherPublisher class is an example of a ConcretePublisher
 *         implementing the IPublisher interface. Of course the publish methods
 *         could have far more interesting logics
 */
public class ConcretePublisher extends AbstractPublisher {

	/**
	 * @param concreteStrategy attaches a concreteStrategy generated from the
	 *                         {@link StrategyFactory#createStrategy(strategies.publisher.StrategyName)}
	 *                         method
	 */
	protected ConcretePublisher(IStrategy concreteStrategy) {
		super(concreteStrategy);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see publishers.IPublisher#publish(events.AbstractEvent)
	 */
	@Override
	public void publish(AbstractEvent event) {
		if (event == null)
			System.err.println("EVENT WAS NULL");
		else
			publishingStrategy.doPublish(event, this.hashCode());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see publishers.IPublisher#publish()
	 */
	@Override
	public void publish() {
		publishingStrategy.doPublish(this.hashCode());
	}

}
