package pour.test.singleton;

import java.time.Duration;
import java.time.LocalDateTime;

public class TestSingleton {

	public static void main(String[] args) {

		LocalDateTime avant = LocalDateTime.now();
		for(long i = 0 ; i < 1_000_000_000_000l ; i++){
			OldWay.getInstance();
		}
		LocalDateTime apres = LocalDateTime.now();
		System.out.println(Duration.between(avant,apres).toSeconds());

		avant = LocalDateTime.now();
		for(int i = 0 ; i < 1_000 ; i++){
			EnumWay instance = EnumWay.INSTANCE;
		}
		apres = LocalDateTime.now();
		System.out.println(Duration.between(avant,apres).toSeconds());

		avant = LocalDateTime.now();
		for(int i = 0 ; i < 1_000 ; i++){
			FunctionalWay.getInstance();
		}
		apres = LocalDateTime.now();
		System.out.println(Duration.between(avant,apres).toSeconds());

	}
}
