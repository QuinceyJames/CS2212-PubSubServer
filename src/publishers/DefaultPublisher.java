package publishers;

import events.AbstractEvent;
import strategies.publisher.AbstractStrategy;

public class DefaultPublisher extends AbstractPublisher {

	public DefaultPublisher(AbstractStrategy concreteStrategy) {
		super(concreteStrategy);
	}

	@Override
	public void publish() {
		// TODO Auto-generated method stub

	}

	@Override
	public void publish(AbstractEvent event) {
		// TODO Auto-generated method stub
		
	}

}
