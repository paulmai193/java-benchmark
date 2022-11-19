package logia.research.java;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class Type extends BenchmarkTest {

    public static void main(String[] args) {
        init(Type.class);
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
        long[] ns = {1,2,3,4,5,6,7,8,9};
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
        int[] ns = {1,2,3,4,5,6,7,8,9};
        sum(ns);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void c() {
        byte[] ns = {1,2,3,4,5,6,7,8,9};
        sum(ns);
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