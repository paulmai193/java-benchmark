package logia.research.java;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public abstract class BenchmarkTest {

    public static void init(Class clazz) {
        Options opt = new OptionsBuilder()
                .include(clazz.getSimpleName())
                .build();

        try {
            new Runner(opt).run();
        } catch (RunnerException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void a();

    public abstract void b();
}
