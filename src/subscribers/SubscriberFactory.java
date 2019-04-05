package subscribers;

import states.subscriber.StateName;


/**
 * @author kkontog, ktsiouni, mgrigori
 *  
 */
/**
 * @author kkontog, ktsiouni, mgrigori
 * creates new {@link AbstractSubscriber} objects
 * contributes to the State design pattern
 * implements the FactoryMethod design pattern   
 */
public class SubscriberFactory {
	
	/**
	 * creates a new {@link AbstractSubscriber} using an entry from the {@link SubscriberType} enumeration
	 * @param subscriberType a value from the {@link SubscriberType} enumeration specifying the type of Subscriber to be created 
	 * @return the newly created {@link AbstractSubscriber} instance 
	 */
	public static AbstractSubscriber createSubscriber(SubscriberType subscriberType, StateName stateName, int subscriberID) {
		switch (subscriberType) {
			case ALPHA_SUBSCRIBER : 
				return new AlphaSubscriber(stateName, subscriberID);
			case BETA_SUBSCRIBER : 
				return new BetaSubscriber(stateName, subscriberID);
			case GAMMA_SUBSCRIBER : 
				return new GammaSubscriber(stateName, subscriberID);
			default:
				return new DefaultSubscriber(stateName, subscriberID);
		}
	}
	
}
