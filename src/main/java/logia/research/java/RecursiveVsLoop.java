package logia.research.java;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class RecursiveVsLoop extends BenchmarkTest {

    public static void main(String[] args) {
        init(RecursiveVsLoop.class);
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
    public void recursive() {
//        doRecursiveFibbonaci(10);
        doRecursiveFactorial(10);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void loop() {
//        doLoopFibbonaci(10);
        doLoopFactorial(10);
    }

    int doRecursiveFibbonaci(int n) {
        if (n < 2) return 1;
        else return doRecursiveFibbonaci(n - 1) + doRecursiveFibbonaci(n - 2);
    }

    int doLoopFibbonaci(int n) {
        int prev = 0, next = 1, result = 0;
        for (int i = 0; i < n; i++) {
            result = prev + next;
            prev = next;
            next = result;
        }
        return result;
    }

    int doRecursiveFactorial(int n) {
//        return n == 1 ? 1 : n * doRecursiveFactorial(n - 1);
        return doTailRecursiveFactorial(1, n);
    }

    int doLoopFactorial(int n) {
        int result = 1;
        for (int i = 1; i < n + 1; i++) {
            result *= i;
        }
        return result;
    }

    int doTailRecursiveFactorial(int result, int n) {
        return n == 1 ? result : doTailRecursiveFactorial(result * n, n - 1);
    }
}
