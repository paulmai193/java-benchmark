package logia.research.java;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.math.NumberUtils;
import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class RedundantCode extends BenchmarkTest {

    public static void main(String[] args) {
        init(RedundantCode.class);
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
    public void addAllLoopCast() {
        List<Integer> lst = new ArrayList<>();
        int i = 0;
        while (i < list.size()) {
            int number = list.get(i);
            lst.add(number);
            i++;
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void addAllLoopGeneric() {
        List<Integer> lst = new ArrayList<>();
        int i = 0;
        while (i < list.size()) {
            lst.add(list.get(i));
            i++;
        }
    }

//    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void addAllMethod1() {
        List<Integer> lst = new ArrayList<>();
        lst.addAll(list);
    }

//    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void addAllMethod2() {
        List<Integer> lst = new ArrayList<>(list);
    }

//    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void addAllMethod3() {
        List<Integer> list = Arrays.asList(ns);
    }

//    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void newInstanceConstructor() {
        Sample s = new Sample(1, "label 1", 0.6f, 100);
    }

//    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void newInstanceSetter() {
        Sample s = new Sample();
        s.setNo(1);
        s.setLabel("label 1");
        s.setRate(0.6f);
        s.setTotal(100);
    }

//    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void newInstanceReflection() throws InstantiationException, IllegalAccessException {
        Sample s = Sample.class.newInstance();
        s.setNo(1);
        s.setLabel("label 1");
        s.setRate(0.6f);
        s.setTotal(100);
    }

    static class Sample {
        private int no;
        private String label;
        private float rate;
        private double total;

        public Sample() {
        }

        public Sample(int no, String label, float rate, double total) {
            this.no = no;
            this.label = label;
            this.rate = rate;
            this.total = total;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public float getRate() {
            return rate;
        }

        public void setRate(float rate) {
            this.rate = rate;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                .append("no", no)
                .append("label", label)
                .append("rate", rate)
                .append("total", total)
                .toString();
        }
    }

//    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void nullCheck1() {
        E i = E.foo;
        boolean e = i != null && i.equals(E.bar);
    }

//    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void nullCheck2() {
        E i = E.foo;
        boolean e = E.bar.equals(i);
    }

//    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void nullCheck3() {
        E i = E.foo;
        boolean e = i == E.bar;
    }

    enum E {
        foo, bar
    }

}
