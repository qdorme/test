package pour.test.matrice;

import java.sql.Array;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadedMatrix extends SimpleMatrix {

	private static int NB_THREAD = 4;

	public ExecutorService executorService = Executors.newFixedThreadPool(NB_THREAD);

	public ThreadedMatrix(double[][] data) {
		super(data);
	}

	public ThreadedMatrix(int line, int column) {
		super(line, column);
	}

	public ThreadedMatrix mul(ThreadedMatrix other) {
		try {
			ThreadedMatrix newMatrix = new ThreadedMatrix(data().length, other.data()[0].length);
			List<Future<Value>> values = new ArrayList<>();
			for (int line = 0; line < data().length; line++)
				for (int column = 0; column < other.data()[0].length; column++) {
					int finalLine = line;
					int finalColumn = column;
					values.add(executorService.submit(
							() -> new Value(super.scalarProduct(super.line(finalLine), super.column(finalColumn)), finalLine, finalColumn)));
					if (values.size() > NB_THREAD*10) {
						values.parallelStream().forEach(valueFuture -> {
							try {
								setValue(valueFuture.get());
							} catch (InterruptedException e) {
								e.printStackTrace();
							} catch (ExecutionException e) {
								e.printStackTrace();
							}
						});
					}
				}
			values.parallelStream().forEach(valueFuture -> {
				try {
					setValue(valueFuture.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			});
			return newMatrix;
		} finally {
			executorService.shutdown();
		}
	}

	public ThreadedMatrix setValue(Value value) {
		this.data()[value.line][value.column] = value.value;
		return this;
	}

	class Value {

		private double value;
		private int line, column;

		public Value(double value, int line, int column) {
			this.value = value;
			this.line = line;
			this.column = column;
		}
	}

	public static void main(String[] args) {
		ThreadedMatrix first = new ThreadedMatrix(1000, 100);
		ThreadedMatrix second = new ThreadedMatrix(100, 100);
		LocalDateTime before = LocalDateTime.now();
		first.mul(second);
		LocalDateTime after = LocalDateTime.now();
		System.out.println(Duration.between(before, after).toSeconds());

	}
}
