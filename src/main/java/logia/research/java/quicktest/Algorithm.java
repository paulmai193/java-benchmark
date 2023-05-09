package logia.research.java.quicktest;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.apache.commons.lang3.RandomUtils;

public class Algorithm {

    public static void main(String[] args) {
        // int[] a = {-1,2,1,-4};
        // System.out.println(Arrays.toString(a));
        System.out.println(solution("23"));
    }

    static List<String> solution(final String digits) {
        int n = digits.length();
        String[] arr = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ArrayList<String> l = new ArrayList<String>();
        if (n == 0)
            return l;
        Queue<String> q = new LinkedList<String>();
        q.add("");
        while (!q.isEmpty()) {
            String s = q.remove();
            if (s.length() != n) {
                String val = arr[(digits.charAt(s.length()) - '0') - 2];
                for (int i = 0; i < val.length(); i++) {
                    q.add(s + val.charAt(i));
                    System.out.println(q);
                }
            } else
                l.add(s);
        }
        return l;
    }

    static int[] randomArray(int size) {
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = size; i >= 1; i--) {
            list.add(RandomUtils.nextInt(1, size));
        }
        int[] a = new int[size];
        int i = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            a[i] = it.next();
            i++;
        }
        return a;
    }
}
