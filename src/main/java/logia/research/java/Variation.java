package logia.research.java;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Variation extends BenchmarkTest {

    public static void main(String[] args) {
        init(Variation.class);
    }

    static final int fork = 1;
    static final int warmup = 1;
    static final int measurement = 5;

    static final Integer[] ns = {154,456,6,89,7,4,422,786,32345,9076,467,65432,12345};

    @Override
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void a() {
        int count = 0;
        Integer number;
        for (int i = 0; i < ns.length; i++) {
            number = ns[i];
            if (number % 2 == 0) {
                count++;
            }
        }
    }

    @Override
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void b() {
        int count = 0;
        for (int i = 0; i < ns.length; i++) {
            Integer number = ns[i];
            if (number % 2 == 0) {
                count++;
            }
        }
    }
}
