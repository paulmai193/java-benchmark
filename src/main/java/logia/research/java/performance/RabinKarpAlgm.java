package logia.research.java.performance;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class RabinKarpAlgm extends BenchmarkTest {

    public static void main(String[] args) {
        init(RabinKarpAlgm.class);
    }

    static final int fork = 1;
    static final int warmup = 2;
    static final int measurement = 10;
    static final String probe = "1) You need to use Wavelet compression algorithm to encode the fingerprint in sequence of wavelet compression parameters:\n" +
        "\n" +
        "0, -1, 2.4, 5.6.7.7, 32.-1.5, e.t.c.\n" +
        "\n" +
        "2) You need to define match function, which will find some similarities, there are two options:\n" +
        "\n" +
        "-the geometry approach (compare qudrants to qudrants, all field are spaced in continuous blocks by some space algorithm)\n" +
        "\n" +
        "Pros:\n" +
        "\n" +
        "hardware accelerated (SSE) pixel matching algorithm, normalization all fingerprints to a standart basis using affine transformation, f.e. to square 512x512 px\n" +
        "\n" +
        "Cons:\n" +
        "\n" +
        "Hight sensitivity in fingerprint quality (if a part of searched fingerprint is omittet totally)\n" +
        "\n" +
        "-the topology approach (the connectivity of lines, arcs, the breakpoints, mutual positioning each other)\n" +
        "\n" +
        "Pros:\n" +
        "\n" +
        "Low sensibility to angle, position, and quality of fingerprint, can use the original image scale and direction;\n" +
        "\n" +
        "Cons:\n" +
        "\n" +
        "Low speed of analysis, highly dependent upon quality of an classification function,\n" +
        "\n" +
        "3) You need to define some sort of a genetic algorithm to train the evaluate function on a known set of fingerprints\n" +
        "\n" +
        "You knowledge system will be able to find fingerprints by the given sample, not known by the system, but trained to find some particular differences/matches, raises the probability of a successful search, lovering the probability of false matches upon the search.";
    static final String candidate = "topology";

    static final short d = 256;
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void q1() {
        search(candidate, probe, 1);
    }
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void q11() {
        search(candidate, probe, 11);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = fork)
    @Warmup(iterations = warmup, time = 1)
    @Measurement(iterations = measurement, time = 1)
    public void q101() {
        search(candidate, probe, 101);
    }

    static void search(String candidateTemplate, String probeTemplate, int q)
    {
        int M = candidateTemplate.length();
        int N = probeTemplate.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (d * p + candidateTemplate.charAt(i)) % q;
            t = (d * t + probeTemplate.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters one by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (probeTemplate.charAt(i + j) != candidateTemplate.charAt(j))
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
//                if (j == M)
//                    System.out.println("Pattern found at index " + i);
            }

            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - probeTemplate.charAt(i) * h) + probeTemplate.charAt(i + M)) % q;

                // We might get negative value of t, converting it
                // to positive
                if (t < 0)
                    t = (t + q);
            }
        }
    }
}
