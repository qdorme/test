package pour.test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
	private AtomicInteger first  = new AtomicInteger(0);
	private AtomicInteger second  = new AtomicInteger(0);
	private AtomicInteger current ;

	public static void main(String[] args) {
		AtomicIntegerTest myClass3 = new AtomicIntegerTest();
		myClass3.runIt();
	}

	private void runIt() {
		current = first;
		System.out.println(current.getAndIncrement());
		System.out.println(current.incrementAndGet());
		current = second;
		System.out.println(current.incrementAndGet());
		System.out.println(current.incrementAndGet());
		System.out.println(current.incrementAndGet());
		System.out.println(current.incrementAndGet());
		current = first;
		System.out.println(current.incrementAndGet());
		System.out.println(current.incrementAndGet());

	}
}
