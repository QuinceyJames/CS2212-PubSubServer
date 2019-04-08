package subscribers;

import subscribers.states.StateName;

public interface ISubscriberFactory {

	/**
	 * creates a new {@link AbstractSubscriber} using an entry from the
	 * {@link SubscriberType} enumeration
	 * 
	 * @param type         a value from the {@link SubscriberType} enumeration
	 *                     specifying the type of Subscriber to be created.
	 * @param name         {@link StateName} of the {@link StateName} to be
	 *                     associated with {@link AbstractSubscriber}.
	 * @param subscriberID ID to be associated with the given
	 *                     {@link AbstractSubscriber}.
	 * @return the newly created {@link AbstractSubscriber} instance
	 */
	AbstractSubscriber createSubscriber(SubscriberType type, StateName name, int subscriberID);

}