package logia.research.java;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Generics extends BenchmarkTest {

    public static void main(String[] args) {
        init(Generics.class);
    }

    static final int fork = 1;
    static final int warmup = 2;
    static final int measurement = 5;
    static final Integer[] ns = {154,456,6,89,7,4,422,786,32345,9076,467,65432,12345};
    static final List<Integer> list = Arrays.asList(ns);

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void a() {
        loopA();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void b() {
        loopB();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void c() {
        addAllA();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void d() {
        addAllB();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void e() {
        addAllC();
    }

    Collection<Integer> loopA() {
        List<Integer> lst = new ArrayList<>();
        int i = 0;
        while (i < list.size()) {
            int number = list.get(i);
            lst.add(number);
            i++;
        }
        return lst;
    }

    Collection<Integer> loopB() {
        List<Integer> lst = new ArrayList<>();
        int i = 0;
        while (i < list.size()) {
            lst.add(list.get(i));
            i++;
        }
        return lst;
    }

    Collection<Integer> addAllA() {
        List<Integer> lst = new ArrayList<>();
        lst.addAll(list);
        return lst;
    }

    Collection<Integer> addAllB() {
        List<Integer> lst = new ArrayList<>(list);
        return lst;
    }

    Collection<Integer> addAllC() {
        List<Integer> list = Arrays.asList(ns);
        return list;
    }
}
