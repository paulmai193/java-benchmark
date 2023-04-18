package logia.research.java.test;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class FingerprintsTest {

    static final String probe = "asdf-rewq-fdasfe";
    static final String candidate = "asdf";
    public static void main(String[] args) {
        HashCode probeHash = Hashing.farmHashFingerprint64().hashBytes(probe.getBytes(StandardCharsets.UTF_8));
        HashCode cadidateHash = Hashing.farmHashFingerprint64().hashBytes(candidate.getBytes(StandardCharsets.UTF_8));

//        System.out.println(matcher.match(candidateTempate));
    }
}
