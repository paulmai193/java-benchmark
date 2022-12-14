package logia.research.java.performance;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class LoopIndexVsIterator extends BenchmarkTest {

    public static void main(String[] args) {
        init(LoopIndexVsIterator.class);
    }

    static final int fork = 1;
    static final int warmup = 2;
    static final int measurement = 10;
    static final Integer[] ns = {12345,154,456,6,89,7,4,422,786,32345,9076,467,422,65432,12345,12345,154,456,6,89,7,4,422,786,32345,9076,467,422,65432,12345,12345,154,456,6,89,7,4,422,786,32345,9076,467,422,65432,12345,12345,154,456,6,89,7,4,422,786,32345,9076,467,422,65432,12345};
    static final List<Integer> list = Arrays.asList(ns);
    static final LinkedList<Integer> linkedList = new LinkedList<>(list);
    static final Set<Integer> set = new HashSet<>(list);

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void arrayLoopIndex() {
        int count = 0;
        for (int i = 0; i < ns.length; i++) {
            Integer number = ns[i];
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
    public void arrayIterator() {
        int count = 0;
        for (int number : ns) {
            if (number % 2 == 0) {
                count++;
            }
        }
    }

//    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void collectionLoopIndex() {
        int count = this.loop(list);
    }

//    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void collectionIterator() {
        int count = this.iterator(list);
    }

    int loop(List<Integer> collection) {
        int count = 0;
        for (int i = 0; i < collection.size(); i++) {
            Integer number = collection.get(i);
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    int iterator(List<Integer> collection) {
        int count = 0;
        for (Integer number : collection) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }

}
