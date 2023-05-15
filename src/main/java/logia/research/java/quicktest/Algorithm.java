package logia.research.java.quicktest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

public class Algorithm {

    public static void main(String[] args) {
        System.out.println(solution("]"));
    }

    static boolean solution(String s) {
        final List<Character> open = Arrays.asList('{', '[', '(');
        final List<Character> close = Arrays.asList('}', ']', ')');
        final List<Character> stack = new ArrayList<>(s.length() / 2);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (open.contains(c)) {
                stack.add(0, c);
            }
            else if (close.contains(c)) {
                if (stack.isEmpty() || (open.indexOf(stack.get(0)) != close.indexOf(c))) return false;
                else stack.remove(0);
            }
        }
        return stack.isEmpty() ? true : false;
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