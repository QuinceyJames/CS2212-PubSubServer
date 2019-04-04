package publishers;

import strategies.publisher.AbstractStrategy;

public class DefaultPublisher extends AbstractPublisher {

	public DefaultPublisher(AbstractStrategy concreteStrategy) {
		super(concreteStrategy);
	}

	@Override
	public void publish() {
		// TODO Auto-generated method stub

	}

}
