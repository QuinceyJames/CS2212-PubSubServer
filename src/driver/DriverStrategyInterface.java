package driver;

import java.util.Scanner;

/**
 * Package-Protected interface that implements the "Strategy Design Pattern". It
 * forces all implementing classes to define an interchangeable strategy that is
 * encapsulated in the concrete classes. This allows for easy incorporation of
 * new strategies. These classes should not be used outside of this package.
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
interface DriverStrategyInterface {

	/**
	 * Implementation of the logic used by the concrete classes should be contained
	 * in this method.
	 * 
	 * @param scanner The scanner that contains all the parameters required to
	 *                execute this strategy
	 */
	void executeDriverStrategy(Scanner scanner);

}