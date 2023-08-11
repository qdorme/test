package pour.test.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureTest {

	public static void main(String[] args)
			throws InterruptedException, ExecutionException {
		System.out.println("main - start");
		CompletableFutureTest futureTest = new CompletableFutureTest();
		Future<String> stringFutureHello = futureTest.calculateAsync("Hello");
		Future<String> stringFutureWorld = futureTest.calculateAsync("World");
		Future<String> stringFutureDot = futureTest.calculateAsync(".");
		System.out.println("after futureTest call");
		System.out.println(String.format("--> %s %s",stringFutureHello.get(),stringFutureWorld.get()));
		System.out.println(String.format("--> %s %s%s",stringFutureHello.get(),stringFutureWorld.get(),stringFutureDot.get()));
		System.out.println("main - end");
	}

	public Future<String> calculateAsync(String value) throws InterruptedException{
		System.out.println(String.format("  ComplatebleFutureTest.calculateAsync(%s) - start",value));
		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		Executors.newCachedThreadPool().submit(() -> {
			System.out.println(String.format("    Executors.newCachedThreadPool().submit(%s) - start",value));
			try {
				if(".".equals(value)) Thread.sleep(5000);
				else Thread.sleep(500);
				completableFuture.complete(value);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(String.format("    Executors.newCachedThreadPool().submit() - end",value));
		});

		System.out.println(String.format("  ComplatebleFutureTest.calculateAsync(%s) - end",value));
		return completableFuture;
	}
}
