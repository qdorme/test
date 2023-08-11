package pour.test.thread;

import java.util.concurrent.*;

public class ScheduledPoolExample {

	private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(50);

	public static void main(String[] args) {
		Future<Double> schedule = executorService.schedule(() -> {
			System.out.println(1 + " Thread id: " + Thread.currentThread().getId());
			Thread.sleep((long) (Math.random() * 200));
			return Math.random();
		}, 1000, TimeUnit.MILLISECONDS);


		try {
			System.out.println(schedule.get(100,TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
			schedule.cancel(true);
		}

		if(schedule.isCancelled())
			System.out.println("It's canceled !!");
		if(schedule.isDone())
			System.out.println("Done !");

		executorService.shutdown();
	}
}
