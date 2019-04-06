package states.subscriber;
import events.AbstractEvent;

public class DefaultState extends AbstractState {

	protected DefaultState() {
		super(); //Calls parent
	}
	
	public void handleEvent(AbstractEvent event, String channelName) {
		
	}
	
	
}
