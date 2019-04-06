package strategies.publisher;

import events.AbstractEvent;
import events.EventFactory;
import events.EventType;
import publishers.AbstractPublisher;

public abstract class AbstractStrategy {

	public AbstractStrategy() {
		// TODO: delete the IStrategy
	}

	public void doPublish(AbstractPublisher publisher) {
		doPublish(EventFactory.createEvent(EventType.DEFAULT_EVENT, publisher, "Default Header", "Default Payload"),
				publisher); //Creates a default event for the publisher
	}

	public void doPublish(AbstractEvent event, AbstractPublisher publisher) {
		System.out.println(String.format("%s publishes %s", publisher, event)); //Prints publisher with event
	}

	@Override
	public String toString() {
		return getClass().getSimpleName(); //toString method
	}

}
