package strategies.publisher;

/**
 * @author kkontog, ktsiouni, mgrigori creates new {@link IStrategy } objects
 *         contributes to the Strategy design pattern implements the
 *         FactoryMethod design pattern
 */
public class StrategyFactory {

	/**
	 * creates a new {@link IStrategy} using an entry from the {@link StrategyName}
	 * enumeration
	 * 
	 * @param strategyName a value from the {@link StrategyName} enumeration
	 *                     specifying the strategy to be created
	 * @return the newly created {@link IStrategy} instance
	 */
	public static AbstractStrategy createStrategy(StrategyName strategyName) {
		switch (strategyName) {
		case ALPHA_STRATEGY:
			return new AlphaStrategy();
		case BETA_STRATEGY:
			return new BetaStrategy();
		case GAMMA_STRATEGY:
			return new GammaStrategy();
		default:
			return new DefaultStrategy();
		}
	}

}
