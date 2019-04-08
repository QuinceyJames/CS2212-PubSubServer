package subscribers;

/**
 * 
 * an enumeration of all the available Subscriber types that can be created
 * using the
 * {@link SubscriberFactory#createSubscriber(SubscriberType, subscribers.states.StateName, int)}
 * note that normally, for each new implementation of the
 * {@link AbstractSubscriber}, a new entry must be added here
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2,
 *         rblack43
 */
public enum SubscriberType {
	ALPHA_SUBSCRIBER, BETA_SUBSCRIBER, GAMMA_SUBSCRIBER, DEFAULT_SUBSCRIBER;
}
