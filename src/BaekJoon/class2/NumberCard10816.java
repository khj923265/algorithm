package BaekJoon.class2;

import java.util.ArrayList;
import java.util.List;

public class NumberCard10816 {
    private static List<Integer> list;

    public static void main(String[] args) throws Exception {
        /**
         * 숫자 카드2 문제
         */

        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();

        int N = read();

        for (int i = 0; i < N; i++) {
            list.add(read());
        }
        list.sort(Integer::compareTo);

        int M = read();

        for (int i = 0; i < M; i++) {
            int number = read();

            sb.append(binarySearchUpper(number, 0, list.size()) - binarySearchLow(number, 0, list.size())).append(" ");
        }
        System.out.println(sb);
    }

    private static int binarySearchLow(int targetNumber, int low, int high) {
        int mid;

        while(low < high) {
            mid = (low + high) / 2;

            if(targetNumber <= list.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int binarySearchUpper(int targetNumber, int low, int high) {
        int mid;

        while(low < high) {
            mid = (low + high) / 2;

            if(targetNumber < list.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
