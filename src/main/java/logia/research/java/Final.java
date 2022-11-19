package logia.research.java;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class Final extends BenchmarkTest {

    public static void main(String[] args) {
        init(Final.class);
    }

    static final int fork = 1;
    static final int warmup = 1;
    static final int measurement = 5;

    @Override
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void a() {
        int[] ns = {154,456,6,89,7,4,422,786,32345,9076,467,65432,12345};
        sum(ns);
    }

    @Override
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void b() {
        final int[] ns = {1,2,3,4,5,6,7,8,9};
        sum(ns);
    }

    int sum(int[] args) {
        int result = 0;
        for (int l : args) {
            result += l;
        }
        return result;
    }
}