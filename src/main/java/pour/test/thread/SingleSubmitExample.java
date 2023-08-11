package pour.test.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleSubmitExample {

	private static ExecutorService executorService = Executors.newSingleThreadExecutor();

	public static Future<Double> getRandom(){
		return executorService.submit(() -> {
			Thread.sleep(1000);
			return Math.random();
		});
	}

	public static void main(String[] args) {
		Future<Double> random = getRandom();
		while(!random.isDone()){
			System.out.println("waiting...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			System.out.println(random.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}
}
