package subscribers;

import baseEntities.IEntity;
import events.AbstractEvent;
import pubSubServer.SubscriptionManager;
import states.subscriber.AbstractState;
import states.subscriber.StateFactory;
import states.subscriber.StateName;
//move set state method here 

/**
 * 
 * Package-Protected class that implements the "State Design Pattern". It forces
 * all implementing classes to define an interchangeable state that is
 * encapsulated in the concrete classes. This allows for easy incorporation of
 * various states that can define unique logic. These classes should not be used
 * outside of this package.
 * 
 * @author Riley
 *
 */
public abstract class AbstractSubscriber implements IEntity, Comparable<AbstractSubscriber> {

	/**
	 * Variable encapsulating the {@link states.subscriber.AbstractState} associated
	 * with an {@link AbstractSubscriber}
	 */
	protected AbstractState state;

	/**
	 * Variable encapsulating the ID number associated with an
	 * {@link AbstractSubscriber}
	 */
	protected int subscriberID;

	/**
	 * Constructor for an {@link AbstractSubscriber} that sets the {@link #state}
	 * and {@link #subscriberID} for said Subscriber.
	 * 
	 * All concrete subscribe instances utilize this method
	 * 
	 * @param stateName is the {@link states.subscribers} associated with a given concrete state
	 * @param subscriberID is the 
	 */
	protected AbstractSubscriber(StateName stateName, int subscriberID) {
		this.subscriberID = subscriberID;
		this.state = StateFactory.createState(stateName);
		// TODO add subscriber discovery class so that id can be used
		System.out.println(String.format("%s has been created", this));
		System.out.println(String.format("%s has %s", this, state));
		
	}

	
	@Override
	public String toString() {
		return String.format("%s with ID %d", getClass().getSimpleName(), this.subscriberID);
	}

	/**
	 * set's the {@link IState} for this ISubscriber implementation using the
	 * {@link StateFactory}
	 * 
	 * @param stateName the entry from the {@link StateName} enumeration that we
	 *                  want the new IState of the ISubscriber to be
	 */
	public abstract void setState(StateName stateName);

	/**
	 * is the function called each time an event is published to one of the channels
	 * that the ISubscriber is sbuscribed to
	 * 
	 * @param event       the AbstractEvent that's received
	 * @param channelName the name of the channel that sent the AbstractEvent to the
	 *                    ISubscriber
	 */
	public void alert(AbstractEvent event, String channelName) {
		System.out.println(String.format("%s recieves %s and handles it at %s", this, event, state));
		state.handleEvent(event, channelName);
	};

	/**
	 * subscribes to the channel whose name is provided by the parameter channelName
	 * 
	 * @param channelName type String
	 */
	public void subscribe(String channelName) {
		SubscriptionManager.getInstance().subscribe(channelName, this);
	};

	/**
	 * unsubscribes from the channel whose name is provided by the parameter
	 * channelName
	 * 
	 * @param channelName type String
	 */
	public void unsubscribe(String channelName) {
		SubscriptionManager.getInstance().unSubscribe(channelName, this);
	}

	@Override
	public int compareTo(AbstractSubscriber o) {
		return o.subscriberID - subscriberID;
	}

}
