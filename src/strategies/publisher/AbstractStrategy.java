package strategies.publisher;

import events.AbstractEvent;
import publishers.AbstractPublisher;

public abstract class AbstractStrategy {

	public AbstractStrategy() {
		// TODO: delete the IStrategy
	}

	public void doPublish(AbstractPublisher publisher) {
		
	}

	public void doPublish(AbstractEvent event) {
		
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

}
