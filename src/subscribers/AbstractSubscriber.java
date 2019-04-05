package subscribers;

import baseEntities.IEntity;
import events.AbstractEvent;
import pubSubServer.SubscriptionManager;
import states.subscriber.IState;
import states.subscriber.StateFactory;
import states.subscriber.StateName;


/**
 * @author kkontog, ktsiouni, mgrigori
 * the base Interface for the Subscriber hierarchy
 */
public abstract class AbstractSubscriber implements IEntity {
	
	protected IState state;

	//package protected meaning only factory can instantiate
	protected AbstractSubscriber(StateName stateName) {
		
		this.state = StateFactory.createState(stateName);
		//TODO add subscriber discovery class so that id can be used 
		System.out.println(this + " " + SubscriberDiscovery.getInstance().findID(this) + " haaaas been created.");
		System.out.println(this + " " + SubscriberDiscovery.getInstance().findID(this) + " has " + this.state + ".");
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
	
	/**
	 * set's the {@link IState} for this ISubscriber implementation using the {@link StateFactory}
	 * @param stateName the entry from the {@link StateName} enumeration that we want the new IState of the ISubscriber to be 
	 */
	public abstract void setState(StateName stateName);

	
	/**
	 * is the function called each time an event is published to one of the channels that the 
	 * ISubscriber is sbuscribed to
	 * @param event the AbstractEvent that's received
	 * @param channelName the name of the channel that sent the AbstractEvent to the ISubscriber
	 */
	public void alert(AbstractEvent event, String channelName) {
		System.out.println("Subscriber " + this + " handling event ::" + event + ":: published on channel " + channelName);
		state.handleEvent(event, channelName);
	};
	
	
	/**
	 * subscribes to the channel whose name is provided by the parameter channelName 
	 * @param channelName type String
	 */
	public void subscribe(String channelName) {
		SubscriptionManager.getInstance().subscribe(channelName, this);	
	};
	
	
	/**
	 * unsubscribes from the channel whose name is provided by the parameter channelName
	 * @param channelName type String
	 */
	public void unsubscribe(String channelName) {
	SubscriptionManager.getInstance().unSubscribe(channelName, this);
	}
	
}
