package logia.research.java.quicktest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;

import org.apache.commons.lang3.RandomUtils;

public class Codility {

    public static void main(String[] args) {
        int[] A = randomArray(1010);
        // Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        BitSet bitSet = new BitSet(A.length);
        for (int a : A) {
            if (a >= 0) {
                bitSet.set(a);
            }
        }
        int nonOccur = 0;
        for (int i = 0; i < bitSet.length(); i++) {
            nonOccur = bitSet.nextClearBit(i);
            if (nonOccur > 0) {
                break;
            }
        }
        return nonOccur == 0 ? 1 : nonOccur;
    }

    static int[] randomArray(int size) {
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = size; i >= 1; i--) {
            list.add(RandomUtils.nextInt(1, size));
        }
        Collections.shuffle(list);
        int[] a = new int[size-3];
        int i = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (i == size-3) break;
            a[i] = it.next();
            i++;
        }
        return a;
    }
}
