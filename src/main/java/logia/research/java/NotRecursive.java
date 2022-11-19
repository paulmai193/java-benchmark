package logia.research.java;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class NotRecursive extends BenchmarkTest {

    public static void main(String[] args) {
        init(NotRecursive.class);
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
        doRecursiveFibbonaci(10);
    }

    @Override
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = 1)
    @Warmup(iterations = 0, time = 1)
    @Measurement(iterations = 3, time = 1)
    public void b() {
        doLoopFibbonaci(10);
    }

    static int doRecursiveFibbonaci(int n) {
        if (n<2) return 1;
        else return doRecursiveFibbonaci(n-1) + doRecursiveFibbonaci(n-2);
    }

    double doLoopFibbonaci(int n){
        double prev=0d, next=1d, result=0d;
        for (int i = 0; i < n; i++) {
            result=prev+next;
            prev=next;
            next=result;
        }
        return result;
    }
}
