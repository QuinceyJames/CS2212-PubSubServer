package strategies.publisher;

public abstract class AbstractStrategy implements IStrategy{
	
	public AbstractStrategy() {
		// TODO: delete the IStrategy 
	}
	
	
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
	
}
