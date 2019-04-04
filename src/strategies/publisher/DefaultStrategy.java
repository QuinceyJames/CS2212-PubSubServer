package strategies.publisher;

import events.AbstractEvent;

public class DefaultStrategy extends AbstractStrategy {

	protected DefaultStrategy () {
		super();
	}
	
	public void doPublish(int publisherId) {

	}

	public void doPublish(AbstractEvent event, int publisherId) {

	}

}
