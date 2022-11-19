package logia.research.java;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CharacterMagics extends BenchmarkTest {

    public static void main(String[] args) {
        init(CharacterMagics.class);
    }

    static final int fork = 1;
    static final int warmup = 1;
    static final int measurement = 1;
    static final Integer[] ns = {154,456,6,89,7,4,422,786,32345,9076,467,65432,12345};
    static final String a = "con bò cạp cạp con bò cạp";

    @Override
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void a() {
        System.out.println(Arrays.toString(normalPeopleSplit(a, " ")));
    }

    @Override
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void b() {
        System.out.println(Arrays.toString(geniusSplit(a, ' ')));
    }

    String normalPeopleReplace(String a) {
        return a.replaceAll("b", "B");
    }

    String geniusReplace(String a) {
        return replace(a, 'b', "B");
    }

    private static String replace(String text, char c, String value) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        int length = text.length();
        while(i < length) {
            char tc = text.charAt(i);
            if(tc == c) {
                builder.append(value);
            } else {
                builder.append(tc);
            }
            i++;
        }
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
        return list.toArray(new String[list.size()]);
    }
}
