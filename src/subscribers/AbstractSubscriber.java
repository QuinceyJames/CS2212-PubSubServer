package subscribers;

import baseEntities.AbstractEntity;
import events.IEvent;
import pubSub.local.ISubscriptionManagerProxy;
import pubSub.local.SubscriptionManagerProxy;
import subscribers.states.IState;
import subscribers.states.IStateFactory;
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
public abstract class AbstractSubscriber extends AbstractEntity<Integer> implements Comparable<AbstractSubscriber>, ISubscriber {

	/**
	 * A reference to the {@link StateFactory} singleton
	 */
	private static final IStateFactory STATE_FACTORY = StateFactory.getInstance();

	/**
	 * A reference to the {@link SubscriptionManagerProxy} singleton
	 */
	private static final ISubscriptionManagerProxy SUBSCRIPTION_MANAGER = SubscriptionManagerProxy.getInstance();

	/**
	 * Variable encapsulating the {@link subscribers.states.AbstractState
	 * AbstractState} associated with an {@link AbstractSubscriber}
	 */
	protected IState state;

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
		super(subscriberID);

		this.state = STATE_FACTORY.createState(stateName); // setting state

		// printing required output as per document using toString in AbstractSubscriber
		System.out.println(String.format("%s has been created.", this));
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
		System.out.println(String.format("%s has %s.", this, state));
	}

	/* (non-Javadoc)
	 * @see subscribers.ISubscriber#alert(events.AbstractEvent, java.lang.String)
	 */
	@Override
	public void alert(IEvent event, String channelName) {
		System.out.println(String.format("%s recieves %s and handles it at %s.", this, event, state));

		// printing required output as per document using defined toString methods in
		// AbstractSubscriber, AbstractEvent and AbstractState
		state.handleEvent(event, channelName);
	}

	/* (non-Javadoc)
	 * @see subscribers.ISubscriber#subscribe(java.lang.String)
	 */
	@Override
	public void subscribe(String channelName) {
		SUBSCRIPTION_MANAGER.subscribe(channelName, this);
	}

	/* (non-Javadoc)
	 * @see subscribers.ISubscriber#unsubscribe(java.lang.String)
	 */
	@Override
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
		return String.format("%s %d", getClass().getSimpleName(), getEntityID());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(AbstractSubscriber o) {
		return getEntityID().compareTo(o.getEntityID());
	}
}
