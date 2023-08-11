package pour.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

	private static ExecutorService executorService = Executors.newFixedThreadPool(3);

	public static void main(String[] args)
			throws InterruptedException {
		int value[] = new int[10];
		for (int i = 0; i < 10; i++) {
			int finalI = i;
			executorService.execute( () -> {
				try {
					System.out.println(String.format(" index: %d - start thread: %d", finalI, Thread.currentThread().getId()));
					TimeUnit.SECONDS.sleep(10);
					value[finalI]=finalI;
					System.out.println(String.format(" index: %d - end", finalI));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});

		}
		System.out.println(String.format("After for loop: [%d,%d,%d,%d,%d,%d,%d,%d,%d,%d]", value[0], value[1], value[2], value[3], value[4], value[5], value[6], value[7], value[8], value[9]));
		//executorService.awaitTermination(20, TimeUnit.SECONDS);
		//System.out.println(String.format("After await termination: [%d,%d,%d,%d,%d,%d,%d,%d,%d,%d]", value[0], value[1], value[2], value[3], value[4], value[5], value[6], value[7], value[8], value[9]));
		executorService.shutdown();
		System.out.println(String.format("After shutdown: [%d,%d,%d,%d,%d,%d,%d,%d,%d,%d]", value[0], value[1], value[2], value[3], value[4], value[5], value[6], value[7], value[8], value[9]));
	}
}
