package logia.research.java;

import org.apache.commons.lang3.RandomStringUtils;
import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class BestList extends BenchmarkTest {

    public static void main(String[] args) {
        init(BestList.class);
    }

    static final int fork = 1;
    static final int warmup = 1;
    static final int measurement = 5;
    static final List<String> template;
    static {
        template = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            template.add(RandomStringUtils.randomAlphabetic(3, 6));
        }
        template.add("REMOVE");
    }

    static final byte count = 3;

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void add1ArrayList() {
        ArrayList<String> list = new ArrayList<>(template);
        LinkedList<String> linkedList = new LinkedList<>(template);
        for (int i = 0; i < count; i++) {
            add(list, "ADD-" + i);
        }
//        System.out.println(list);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void add1LinkedList() {
        ArrayList<String> list = new ArrayList<>(template);
        LinkedList<String> linkedList = new LinkedList<>(template);
        for (int i = 0; i < count; i++) {
            add(linkedList, "ADD-" + i);
        }
//        System.out.println(linkedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void add2ArrayListIndex() {
        ArrayList<String> list = new ArrayList<>(template);
        LinkedList<String> linkedList = new LinkedList<>(template);
        for (int i = 0; i < count; i++) {
            addIndex(list, i, "ADD-" + i);
        }
//        System.out.println(list);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void add2LinkedListIndex() {
        ArrayList<String> list = new ArrayList<>(template);
        LinkedList<String> linkedList = new LinkedList<>(template);
        for (int i = 0; i < count; i++) {
            addIndex(linkedList, i, "ADD-" + i);
        }
//        System.out.println(linkedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void remove1ArrayList() {
        ArrayList<String> list = new ArrayList<>(template);
        LinkedList<String> linkedList = new LinkedList<>(template);
        remove(list, "REMOVE");
//        System.out.println(list);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void remove1LinkedList() {
        ArrayList<String> list = new ArrayList<>(template);
        LinkedList<String> linkedList = new LinkedList<>(template);
        remove(linkedList, "REMOVE");
//        System.out.println(linkedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void remove2ArrayList() {
        ArrayList<String> list = new ArrayList<>(template);
        LinkedList<String> linkedList = new LinkedList<>(template);
        String removed = removeIndex(list, 21);
//        System.out.println(removed);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void remove2LinkedList() {
        ArrayList<String> list = new ArrayList<>(template);
        LinkedList<String> linkedList = new LinkedList<>(template);
        String removed = removeIndex(linkedList, 21);
//        System.out.println(removed);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void getFirstArrayList() {
        ArrayList<String> list = new ArrayList<>(template);
        LinkedList<String> linkedList = new LinkedList<>(template);
        String s = getFirstA(list);
//        System.out.println(s);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void getFirstLinkedList() {
        ArrayList<String> list = new ArrayList<>(template);
        LinkedList<String> linkedList = new LinkedList<>(template);
        String s = getFirstB(linkedList);
//        System.out.println(s);
    }

    boolean add(List<String> list, String element) {
        return list.add(element);
    }

    void addIndex(List<String> list, int index, String element) {
        list.add(index, element);
    }

    boolean remove(List<String> list, String element) {
        return list.remove(element);
    }

    String removeIndex(List<String> list, int index) {
        return list.remove(index);
    }

    String getFirstA(ArrayList<String> list) {
        return list.get(0);
    }

    String getFirstB(LinkedList<String> list) {
        return list.getFirst();
    }

    @Override
    public void a() {

    }

    @Override
    public void b() {

    }
}
