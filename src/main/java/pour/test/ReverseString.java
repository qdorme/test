package pour.test;

import java.time.Duration;
import java.time.LocalDateTime;

public class ReverseString {

	public static void main(String[] args) {
		int attempt = 10000000;

		String card = "2C";
		LocalDateTime start = LocalDateTime.now();
		for(int current = 0; current < attempt ; current++){
			new StringBuilder(card).reverse().toString();
		}
		LocalDateTime stop = LocalDateTime.now();
		System.out.println(Duration.between(start,stop).toSeconds());
		start = LocalDateTime.now();
		for(int current = 0; current < attempt ; current++){
			String.format("%s%s",card.toCharArray()[1],card.toCharArray()[0]);
		}
		stop = LocalDateTime.now();
		System.out.println(Duration.between(start,stop).toSeconds());
	}
}
