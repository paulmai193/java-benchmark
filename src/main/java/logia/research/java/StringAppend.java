package logia.research.java;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class StringAppend extends BenchmarkTest {

    public static void main(String[] args) {
        init(StringAppend.class);
    }

    static final int fork = 1;
    static final int warmup = 1;
    static final int measurement = 10;
    static final Integer[] ns = {154,456,6,89,7,4,422,786,32345,9076,467,65432,12345};

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void a() {
        useAddA();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void b() {
        useAddB();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void c() {
        useBuilder();
    }

    String useAddA() {
        String s = "";
        for (Integer n : ns) {
            s += n;
        }
        return s;
    }

    String useAddB() {
        String s = "";
        for (Integer n : ns) {
            s += ("" + n);
        }
        return s;
    }

    String useBuilder() {
        StringBuilder s = new StringBuilder();
        for (Integer n : ns) {
            s.append(n);
        }
        return s.toString();
    }
}
