package BaekJoon.practice;

import java.util.HashSet;
import java.util.Set;

public class NumberCard10815 {

    public static void main(String[] args) throws Exception {
        /**
         * 숫자 카드 문제
         */

        // TreeSet(972ms) -> HashSet(624ms)

        Set<Integer> treeSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int N = read();

        for (int i = 0; i < N; i++) {
            treeSet.add(read());
        }

        int M = read();

        for (int i = 0; i < M; i++) {
            int number = read();
            if (treeSet.contains(number)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
