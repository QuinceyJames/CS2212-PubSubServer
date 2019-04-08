package publishers.strategies;

import events.IEvent;
import publishers.IPublisher;

public interface IStrategy {

	/**
	 * Method to create and publish an {@link IEvent} for an {@link IPublisher}
	 * 
	 * @param publisher the {@link IPublisher} that has requested an event to be
	 *                  published
	 */
	void doPublish(IPublisher publisher);

	/**
	 * Method to publish an specified {@link IEvent} for an {@link IPublisher}
	 * 
	 * @param publisher the {@link IPublisher} that has requested an event to be
	 *                  published
	 * @param event     the {@link IEvent} to be published
	 */
	void doPublish(IEvent event, IPublisher publisher);

}