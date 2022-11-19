package logia.research.java;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CharacterMagics extends BenchmarkTest {

    public static void main(String[] args) {
        init(CharacterMagics.class);
    }

    static final int fork = 1;
    static final int warmup = 2;
    static final int measurement = 5;
    static final String a = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sagittis vitae et leo duis ut. Vitae ultricies leo integer malesuada nunc vel risus. Id nibh tortor id aliquet lectus proin. Nunc mattis enim ut tellus elementum sagittis vitae et.";

    @Override
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void a() {
        normalPeopleReplace(a, "b", "B");
    }

    @Override
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void b() {
        geniusReplace(a, 'b', "B");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void c() {
        normalPeopleSplit(a, ",");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void d() {
        geniusSplit(a, ',');
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void e() {
        normalEquals(a, a);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void f() {
        geniusEquals(a, a);
    }

    String normalPeopleReplace(String text, String mark, String replacement) {
        return text.replaceAll(mark, replacement);
    }

    String geniusReplace(String text, char mark, String replacement) {
        return replace(text, mark, replacement);
    }

    private static String replace(String text, char c, String value) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        int length = text.length();
        for (char tc : text.toCharArray()) {
            if(tc == c) {
                builder.append(value);
            } else {
                builder.append(tc);
            }
        }
//        while(i < length) {
//            char tc = text.charAt(i);
//            if(tc == c) {
//                builder.append(value);
//            } else {
//                builder.append(tc);
//            }
//            i++;
//        }
        return builder.toString();
    }

    String[] normalPeopleSplit(String a, String mark) {
        return a.split(mark);
    }

    String[] geniusSplit(String a, char mark) {
        return split(a, mark);
    }

    private static String[] split(String text, char mark) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int start = 0;
        int length = text.length();
        while(i < length) {
            if (text.charAt(i) == mark) {
                list.add(text.substring(start, i));
                start = i + 1;
            }
            i++;
        }
        if(start < length) list.add(text.substring(start, length));
        return list.toArray(new String[0]);
    }

    boolean normalEquals(String a, String b) {
        return a.equals(b);
    }

    boolean geniusEquals(String a, String b) {
        return a.intern() == b.intern();
    }
}
