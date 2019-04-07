package publishers.strategies;

import events.AbstractEvent;
import publishers.AbstractPublisher;
import publishers.IPublisher;

public interface IStrategy {

	/**
	 * Method to create and publish an {@link AbstractEvent} for an
	 * {@link AbstractPublisher}
	 * 
	 * @param publisher the {@link AbstractPublisher} that has requested an event to
	 *                  be published
	 */
	void doPublish(IPublisher publisher);

	/**
	 * Method to publish an specified {@link AbstractEvent} for an
	 * {@link AbstractPublisher}
	 * 
	 * @param publisher the {@link AbstractPublisher} that has requested an event to
	 *                  be published
	 * @param event     the {@link AbstractEvent} to be published
	 */
	void doPublish(AbstractEvent event, IPublisher publisher);

}