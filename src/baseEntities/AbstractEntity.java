package baseEntities;

/**
 * @author kkontog, ktsiouni, mgrigori
 * 
 *         Base Interface for Publisher, Subscriber and Channel classes
 */
public abstract class AbstractEntity<T extends Comparable<?>> implements IEntity<T> {
	/**
	 * Variable encapsulating the entityID number associated with an {@link AbstractEntity}
	 */
	private final T entityID;

	protected AbstractEntity(T entityID) {
		this.entityID = entityID;
	}
	
	/* (non-Javadoc)
	 * @see baseEntities.IEntity#getEntityID()
	 */
	@Override
	public T getEntityID() {
		return entityID;
	}
}
