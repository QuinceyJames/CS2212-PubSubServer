package subscribers;

import baseEntities.IEntity;
import events.AbstractEvent;
import pubSubServer.SubscriptionManager;
import subscribers.states.AbstractState;
import subscribers.states.StateFactory;
import subscribers.states.StateName;

/**
 * 
 * Package-Protected class that implements the "State Design Pattern". It forces
 * all implementing classes to define an interchangeable state that is
 * encapsulated in the concrete classes. This allows for easy incorporation of
 * various states that can define unique logic. These classes should not be used
 * outside of this package.
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
public abstract class AbstractSubscriber implements IEntity { 

	/**
	 * A reference to the {@link StateFactory} singleton
	 */
	private static final StateFactory STATE_FACTORY = StateFactory.getInstance();

	/**
	 * A reference to the {@link SubscriptionManager} singleton
	 */
	private static final SubscriptionManager SUBSCRIPTION_MANAGER = SubscriptionManager.getInstance();

	/**
	 * Variable encapsulating the {@link subscribers.states.AbstractState
	 * AbstractState} associated with an {@link AbstractSubscriber}
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
	 * All concrete subscriber instances utilize this method.
	 * 
	 * @param stateName    is the {@link subscribers.states.StateName StateName} of
	 *                     the {@link state} to be associated with the given
	 *                     {@link AbstractSubscriber}.
	 * @param subscriberID is the {@link #subscriberID} to be associated with the
	 *                     given {@link AbstractSubscriber}.
	 */
	protected AbstractSubscriber(StateName stateName, int subscriberID) {
		this.subscriberID = subscriberID; // setting subscriberID
		this.state = STATE_FACTORY.createState(stateName); // setting state

		// printing required output as per document using toString in AbstractSubscriber
		System.out.println(String.format("%s has been created", this));
	}

	/**
	 * Sets the {@link subscribers.states.AbstractState AbstractState} for this
	 * {@link AbstractSubscriber} implementation using the {@link StateFactory}
	 * 
	 * @param stateName the entry from the {@link StateName} enumeration that we
	 *                  want the new AbstractState of the AbstractSubscriber to be
	 */
	public void setState(StateName stateName) {
		this.state = STATE_FACTORY.createState(stateName);

		// printing required output as per document using defined toString methods in
		// AbstractSubscriber and AbstractState
		System.out.println(String.format("%s has %s", this, state));
	}

	/**
	 * Function called each time an event is published to one of the channels that
	 * the {@link AbstractSubscriber} is subscribed to
	 * 
	 * @param event       the AbstractEvent that's received
	 * @param channelName the name of the channel that sent the AbstractEvent to the
	 *                    AbstractSubscriber
	 */
	public void alert(AbstractEvent event, String channelName) {
		System.out.println(String.format("%s recieves %s and handles it at %s", this, event, state));

		// printing required output as per document using defined toString methods in
		// AbstractSubscriber, AbstractEvent and AbstractState
		state.handleEvent(event, channelName);
	}

	/**
	 * Function to subscribe an {@link AbstractSubscriber} to an
	 * {@link pubSubServer.AbstractChannel Channel}
	 * 
	 * @param channelName name of type String used to specify channel
	 */
	public void subscribe(String channelName) {
		SUBSCRIPTION_MANAGER.subscribe(channelName, this);
	}

	/**
	 * Function to unsubscribe an {@link AbstractSubscriber} to an
	 * {@link pubSubServer.AbstractChannel Channel}
	 * 
	 * @param channelName name of type String used to specify channel
	 */
	public void unsubscribe(String channelName) {
		SUBSCRIPTION_MANAGER.unSubscribe(channelName, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// creates string in the form "AlphaSubscriber #1"
		return String.format("%s #%d", getClass().getSimpleName(), subscriberID);
	}
}
