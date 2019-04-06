package subscribers;


/**
 * @author kkontog, ktsiouni, mgrigori
 * 	an enumeration of all the available
 *  Subscriber types that can be created using the
 *  {@link SubscriberFactory#createSubscriber(SubscriberType, states.subscriber.StateName)} note that normally, for
 *  each new implementation of the {@link AbstractSubscriber}, a new entry
 *  must be added here   
 */
public enum SubscriberType {
	ALPHA_SUBSCRIBER, BETA_SUBSCRIBER, GAMMA_SUBSCRIBER, DEFAULT_SUBSCRIBER;
}
