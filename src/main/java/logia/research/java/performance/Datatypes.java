package logia.research.java.performance;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class Datatypes extends BenchmarkTest {

    public static void main(String[] args) {
        init(Datatypes.class);
    }

    static final int fork = 1;
    static final int warmup = 1;
    static final int measurement = 5;

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void longObject() {
        Long[] ns = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L};
        sum(ns);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void longPrimitive() {
        long[] ns = {1,2,3,4,5,6,7,8,9};
        sum(ns);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void intPrimitive() {
        int[] ns = {1,2,3,4,5,6,7,8,9};
        sum(ns);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void bytePrimitive() {
        byte[] ns = {1,2,3,4,5,6,7,8,9};
        sum(ns);
    }

    long sum(Long[] args) {
        Long result = 0L;
        for (Long l : args) {
            result += l;
        }
        return result;
    }

    long sum(long[] args) {
        long result = 0;
        for (long l : args) {
            result += l;
        }
        return result;
    }

    int sum(int[] args) {
        int result = 0;
        for (int l : args) {
            result += l;
        }
        return result;
    }

    short sum(byte[] args) {
        byte result = 0;
        for (byte l : args) {
            result += l;
        }
        return result;
    }
}
