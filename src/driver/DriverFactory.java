package driver;

import java.util.StringTokenizer;

public class DriverFactory {

	public static void createDriver(String line) {
		StringTokenizer tokenizer = new StringTokenizer(line);
		switch (tokenizer.nextToken().toUpperCase().trim()) {
		case "PUB":
			new PublisherDriver().execute(tokenizer);
			break;
		}
		
		
	}
}
