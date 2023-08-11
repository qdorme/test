package pour.test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Fibonaccie {

	public static void main(String[] args) {
		Fibonaccie f = new Fibonaccie();
		LocalDateTime avant = LocalDateTime.now();
		f.fib(50);
		LocalDateTime apres = LocalDateTime.now();
		System.out.println(" fib(50) = "+Duration.between(avant,apres).toSeconds());


		avant = LocalDateTime.now();
		f.fibMemo(50);
		apres = LocalDateTime.now();
		System.out.println("fibMemo(50) = "+Duration.between(avant,apres).toSeconds());

	}

	public long fib(int n){
		if (n <= 1) return n;
		return fib(n - 2) + fib(n - 1);
	}

	static HashMap<Integer, Long> memo = new HashMap<Integer, Long>();
	public long fibMemo(int n) {
		if (n <= 1) return n;
		Long l = memo.get(n);
		if (l != null) return l;
		l = fibMemo(n - 2) + fibMemo(n - 1);
		memo.put(n, l);
		return l;
	}
}
