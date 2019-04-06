package driver;

import java.util.Scanner;

/**
 * A class that chooses which {@link DriverStrategy} should be executed
 * 
 * @author qjames2, tzhu63, zzhan746, mgianco2, rblack43
 *
 */
public class DriverStrategySelector {

	/**
	 * Determines and executes the appropriate {@link DriverStrategy} based on the
	 * the first word of the command.
	 * 
	 * @param command The command to be executed where the first word is one of the
	 *                following: ["PUB", "SUB", "UNSUB", "BLOCK", "UNBLOCK"]
	 */
	public static void executeCommand(String command) {
		Scanner scanner = new Scanner(command);

		switch (scanner.next().toUpperCase()) {
		case "PUB":
			new PublisherDriver().executeDriverStrategy(scanner);
			break;

		case "SUB":
			new SubscriberDriver().executeDriverStrategy(scanner);
			break;

		case "UNSUB":
			new UnsubscribeDriver().executeDriverStrategy(scanner);
			break;

		case "BLOCK":
			new BlockerDriver().executeDriverStrategy(scanner);
			break;

		case "UNBLOCK":
			new UnblockerDriver().executeDriverStrategy(scanner);
			break;

		default:
			System.err.println("UNKNOWN COMMAND");
		}

	}
}
