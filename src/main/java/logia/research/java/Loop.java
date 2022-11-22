package logia.research.java;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Loop extends BenchmarkTest {

    public static void main(String[] args) {
        init(Loop.class);
    }

    static final int fork = 1;
    static final int warmup = 2;
    static final int measurement = 5;
    static final Integer[] ns = {12345,154,456,6,89,7,4,422,786,32345,9076,467,422,65432,12345};
    static final List<Integer> list = Arrays.asList(ns);
    static final LinkedList<Integer> linkedList = new LinkedList<>(list);

    @Override
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void a() {
        foreachCollection(linkedList);
    }

    @Override
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void b() {
        forindexCollection(linkedList);
    }

    void forindexArray(Integer[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            Integer number = array[i];
            if (number % 2 == 0) {
                count++;
            }
        }
    }

    void foreachArray(Integer[] array) {
        int count = 0;
        for (Integer number : array) {
            if (number % 2 == 0) {
                count++;
            }
        }
    }

    void forindexCollection(List<Integer> collection) {
        int count = 0;
        for (int i = 0; i < collection.size(); i++) {
            Integer number = collection.get(i);
            if (number % 2 == 0) {
                count++;
            }
        }
    }

    void foreachCollection(List<Integer> collection) {
        int count = 0;
        for (Integer number : collection) {
            if (number % 2 == 0) {
                count++;
            }
        }
    }
}
