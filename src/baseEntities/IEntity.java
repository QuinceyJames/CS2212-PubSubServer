package baseEntities;

public interface IEntity<T extends Comparable<?>> {

	T getEntityID();

}