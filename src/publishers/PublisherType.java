package publishers;

import subscribers.AbstractSubscriber;
import subscribers.SubscriberFactory;
import subscribers.SubscriberType;

/**
 * @author kkontog, ktsiouni, mgrigori, rblack43
 * 	an enumeration of all the available
 *  Publisher types that can be created using the
 *  {@link PublisherFactory#createPublisher(PublisherType, strategies.publisher.StrategyName)} note that normally, for
 *  each new implementation of the {@link AbstractPublisher}, a new entry
 *  must be added here   
 */
public enum PublisherType {
	ALPHA_PUBLISHER, BETA_PUBLISHER, GAMMA_PUBLISHER, DEFAULT_PUBLISHER;
}
