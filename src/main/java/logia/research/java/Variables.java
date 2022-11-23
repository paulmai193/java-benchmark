package logia.research.java;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class Variables extends BenchmarkTest {

    public static void main(String[] args) {
        init(Variables.class);
    }

    static final int fork = 1;
    static final int warmup = 2;
    static final int measurement = 10;
    static final Integer[] ns = {154,456,6,89,7,4,422,786,32345,9076,467,65432,12345,154,456,6,89,7,4,422,786,32345,9076,467,65432,12345,154,456,6,89,7,4,422,786,32345,9076,467,65432,12345,154,456,6,89,7,4,422,786,32345,9076,467,65432,12345,154,456,6,89,7,4,422,786,32345,9076,467,65432,12345,154,456,6,89,7,4,422,786,32345,9076,467,65432,12345};

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void global() {
        int count = 0;
        Integer number;
        for (int i = 0; i < ns.length; i++) {
            number = ns[i];
            if (number % 2 == 0) {
                count++;
            }
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void local() {
        int count = 0;
        for (int i = 0; i < ns.length; i++) {
            Integer number = ns[i];
            if (number % 2 == 0) {
                count++;
            }
        }
    }
}
