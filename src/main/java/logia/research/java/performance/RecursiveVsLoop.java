package logia.research.java.performance;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class RecursiveVsLoop extends BenchmarkTest {

    public static void main(String[] args) {
        init(RecursiveVsLoop.class);

//        int sum = doRecursiveSum(json);
//        System.out.println("Recursive: " + sum);
//
//        sum = doLoopSum();
//        System.out.println("Loop: " + sum);
    }

    static final int fork = 1;
    static final int warmup = 1;
    static final int measurement = 5;

    static final JsonObject json = JsonParser.parseString("{\"1\":[{\"1.1\":[{\"1.1.1\":2},{\"1.1.2\":6}]},{\"1.2\":[{\"1.2.1\":45},{\"1.2.2\":2}]}]}")
            .getAsJsonObject();

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void recursive() {
        doRecursiveSum(json);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void loop() {
        doLoopSum();
    }

    static int doRecursiveSum(JsonElement element) {
        int sum = 0;
        if (element.isJsonPrimitive()) {
            sum = element.getAsInt();
        } else if (element.isJsonArray()) {
            for (JsonElement jsonElement : element.getAsJsonArray()) {
                sum += doRecursiveSum(jsonElement);
            }
        } else {
            for (JsonElement jsonArr : element.getAsJsonObject().asMap().values()) {
                sum += doRecursiveSum(jsonArr);
            }
        }
        return sum;
    }

    static int doLoopSum() {
        int sum = 0;
        for (JsonElement x : json.asMap().values()) {
            for (JsonElement xJson : x.getAsJsonArray()) {
                for (JsonElement xx : xJson.getAsJsonObject().asMap().values()) {
                    for (JsonElement xxJson : xx.getAsJsonArray()) {
                        for (JsonElement xxx : xxJson.getAsJsonObject().asMap().values()) {
                            sum += xxx.getAsJsonPrimitive().getAsInt();
                        }
                    }
                }
            }
        }
        return sum;
    }

    int doRecursiveFactorial(int n) {
        return n == 1 ? 1 : n * doRecursiveFactorial(n - 1);
    }

    int doLoopFactorial(int n) {
        int result = 1;
        for (int i = 1; i < n + 1; i++) {
            result *= i;
        }
        return result;
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
}
