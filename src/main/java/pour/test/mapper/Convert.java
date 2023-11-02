package pour.test.mapper;

import org.mapstruct.factory.Mappers;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 3)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class Convert {

    private static ToDTO mapper = Mappers.getMapper(ToDTO.class);

    /*
    Benchmark           Mode  Cnt  Score    Error  Units
    Convert.auto        avgt   15  0,004 �  0,001  us/op
    Convert.functional  avgt   15  0,004 �  0,001  us/op
    Convert.manual      avgt   15  0,004 �  0,001  us/op
    */

    public static void main(String[] args)
            throws RunnerException {
        Options opt = new OptionsBuilder().include(Convert.class.getName()).build();
        new Runner(opt).run();
    }

    @Benchmark
    public void functional() {
        StubEntity stub = new StubEntity();
        for (long i = 0; i < 10_000_000_000l; i++) {

            TargetDTO dto = ToDoFunctionnal.from((target)->{
                target.setId(stub.getId());
                target.setNum(stub.getNum());
                target.setTexte(stub.getTexte());
            });
        }
    }

    @Benchmark
    public void manual() {
        StubEntity stub = new StubEntity();
        for (long i = 0; i < 10_000_000_000l; i++) {

            TargetDTO dto = ToDoManual.from(stub);
        }
    }

    @Benchmark
    public void auto() {
        StubEntity stub = new StubEntity();

        for (long i = 0; i < 10_000_000_000l; i++) {

            TargetDTO dto = mapper.from(stub);
        }
    }
}
