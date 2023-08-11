package pour.test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleExecuteExample {

	public static void main(String[] args) {
		example1();
		example2();
	}

	private static void example2() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		List<Callable<Integer>> callables = new ArrayList<>();
		callables.add(() -> 1);
		callables.add(() -> 2);

		try {
			Thread.sleep(100);
			System.out.println(executorService.invokeAny(callables));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}

	}

	private static void example1() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(() -> System.out.println("1: " + Math.random() + " Thread id:" + Thread.currentThread().getId()));
		executorService.execute(() -> System.out.println("2: " + Math.random() + " Thread id:" + Thread.currentThread().getId()));
		executorService.execute(() -> System.out.println("3: " + Math.random() + " Thread id:" + Thread.currentThread().getId()));
		executorService.execute(() -> System.out.println("4: " + Math.random() + " Thread id:" + Thread.currentThread().getId()));

		executorService.shutdown();
	}
}
