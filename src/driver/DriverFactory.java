package driver;

import java.util.StringTokenizer;

public class DriverFactory {

	public static void createDriver(String line) {
		StringTokenizer tokenizer = new StringTokenizer(line);
		switch (tokenizer.nextToken().toUpperCase().trim()) {
		case "PUB":
			new PublisherDriver().execute(tokenizer);
			break;
		case "SUB":
			new SubscriberDriver().execute(tokenizer);
			break;
		case "UNSUB":
			new SubscriberDriver().execute(tokenizer);
			break;
		case "BLOCK":
			new BlockerDriver().execute(tokenizer);
			break;
		case "UNBLOCK":
			new UnblockerDriver().execute(tokenizer);
			break;
		default:
			System.err.println("UNKNOWN COMMAND");
		}
	}
}
