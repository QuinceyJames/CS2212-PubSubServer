package publishers.strategies;

public interface IStrategyFactory {

	/**
	 * creates a new {@link AbstractStrategy} using an entry from the
	 * {@link StrategyName} enumeration
	 * 
	 * @param strategyName a value from the {@link StrategyName} enumeration
	 *                     specifying the strategy to be created
	 * @return the newly created {@link AbstractStrategy} instance
	 */
	IStrategy createStrategy(StrategyName strategyName);

}