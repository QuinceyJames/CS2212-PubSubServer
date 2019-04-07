package states.subscriber;
import events.AbstractEvent;

public class DefaultState extends AbstractState {

	/**
	 * Protected constructor for {@link AlphaSubscriber}. To create this object use
	 * {@link StateFactory#createState(StateName)}
	 */
	protected DefaultState() {
		super(); //Calls parent
	}
	
	public void handleEvent(AbstractEvent event, String channelName) {
		
	}
	
	
}
