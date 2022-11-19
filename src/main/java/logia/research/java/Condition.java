package logia.research.java;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class Condition extends BenchmarkTest {

    public static void main(String[] args) {
        init(Condition.class);
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
        ifelse();
    }

    @Override
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void b() {
        switchcase();
    }

    int ifelse() {
        int count = 0;
        for (Integer number : ns) {
            int x = number % 5;
            if (x == 0 || x == 1) {
                count++;
            } else if (x == 2 || x == 3) {
                // Do nothing
            } else {
                count++;
            }
        }
        return count;
    }

    int switchcase() {
        int count = 0;
        for (Integer number : ns) {
            int x = number % 5;
            switch (x) {
                case 0:
                case 1:
                    count++;
                    break;
                case 2:
                case 3:
                    // Do nothing
                    break;
                default:
                    count++;
                    break;
            }
        }
        return count;
    }
}
