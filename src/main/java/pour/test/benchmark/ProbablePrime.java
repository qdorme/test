package pour.test.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 3)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class ProbablePrime {

	@Param({ "10","100" }) private int N;
	@Param({ "64" }) private int BIT_LENGTH;

	BigInteger probablePrime() {
		return BigInteger.probablePrime(BIT_LENGTH, ThreadLocalRandom.current());
	}

	@Benchmark
	public List<BigInteger> sum_of_N_Primes() {
		List<BigInteger> pps = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			BigInteger pp = BigInteger.probablePrime(BIT_LENGTH, ThreadLocalRandom.current());
			pps.add(pp);
		}
		return pps;
	}

	@Benchmark
	public List<BigInteger> sum_of_N_primes_no_resize() {
		List<BigInteger> pps = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			BigInteger pp = BigInteger.probablePrime(BIT_LENGTH, ThreadLocalRandom.current());
			pps.add(pp);
		}
		return pps;
	}

	@Benchmark
	public List<BigInteger> generate_N_primes_parallel() {
		return IntStream.range(0, N).parallel().mapToObj(i -> probablePrime()).collect(Collectors.toList());
	}

	@Benchmark
	public List<BigInteger> generate_N_primes_parallel_unordered() {
		return IntStream.range(0, N).unordered().parallel().mapToObj(i -> probablePrime()).collect(Collectors.toList());
	}

	@Benchmark
	public List<BigInteger> generate_N_primes() {
		return IntStream.range(0, N).mapToObj(i -> probablePrime()).collect(Collectors.toList());
	}

	@Benchmark
	public List<BigInteger> generate_N_primes_parallel_limit() {
		return Stream.generate(() -> probablePrime()).parallel().limit(N).collect(Collectors.toList());
	}

	@Benchmark
	public List<BigInteger> generate_N_primes_limit() {
		return Stream.generate(() -> probablePrime()).limit(N).collect(Collectors.toList());
	}

	public static void main(String[] args)
			throws RunnerException {
		Options opt = new OptionsBuilder().include(ProbablePrime.class.getName()).build();
		new Runner(opt).run();
	}
}
