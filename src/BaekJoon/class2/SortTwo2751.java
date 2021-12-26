package BaekJoon.class2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTwo2751 {

    public static void main(String[] args) throws Exception {
        /**
         * 수 정렬하기 2 문제
         */

        int N = read();
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int number = read();
            list.add(number);
        }

        Collections.sort(list);

        for (int number : list) {
            sb.append(number).append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) {
            n = System.in.read() & 15;
        }
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return isNegative ? ~n + 1 : n;
    }
}
