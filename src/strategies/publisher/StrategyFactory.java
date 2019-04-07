package strategies.publisher;

/**
 * creates new {@link AbstractStrategy } objects
 * contributes to the Strategy design pattern implements the
 * FactoryMethod design pattern
 * 
 * @author kkontog, ktsiouni, mgrigori, qjames2, tzhu63, zzhan746, mgianco2, rblack43
 */
public class StrategyFactory {

	/**
	 * creates a new {@link AbstractStrategy} using an entry from the {@link StrategyName}
	 * enumeration
	 * 
	 * @param strategyName a value from the {@link StrategyName} enumeration
	 *                     specifying the strategy to be created
	 * @return the newly created {@link AbstractStrategy} instance
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
