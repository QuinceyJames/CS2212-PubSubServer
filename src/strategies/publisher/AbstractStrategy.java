package strategies.publisher;

import events.AbstractEvent;
import events.EventFactory;
import events.EventType;
import publishers.AbstractPublisher;
import subscribers.AbstractSubscriber;


/**
 * Base class for the implementation of the Strategy Design Pattern with regards to Strategies
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public abstract class AbstractStrategy {

	/**
	 * Constructor for a {@link AbstractStrategy}
	 */
	public AbstractStrategy() {}

	/**
	 * Method to create and publish an {@link AbstractEvent} for an {@link AbstractPublisher}
	 * 
	 * @param publisher the {@link AbstractPublisher} that has requested an event to be published
	 */
	public void doPublish(AbstractPublisher publisher) {
		doPublish(EventFactory.createEvent(EventType.DEFAULT_EVENT, publisher, "Default Header", "Default Payload"),
				publisher); //Creates a default event for the publisher
	}

	/**
	 * Method to publish an specified {@link AbstractEvent} for an {@link AbstractPublisher}
	 * 
	 * @param publisher the {@link AbstractPublisher} that has requested an event to be published
	 * @param event the {@link AbstractEvent} to be published
	 */
	public void doPublish(AbstractEvent event, AbstractPublisher publisher) {
		System.out.println(String.format("%s publishes %s", publisher, event)); //Prints publisher with event
	}

	@Override
	public String toString() {
		return getClass().getSimpleName(); //toString method
	}

}
