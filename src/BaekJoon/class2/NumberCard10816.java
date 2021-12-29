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
            int startIndex = binarySearch(number, 0, list.size()- 1 );
            int count = 0;
            if (startIndex != -1) {
                count = countNumber(startIndex, number);
            }
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int targetNumber, int low, int high) {
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;

            if(targetNumber == list.get(mid)) {
                return mid;
            } else if(targetNumber < list.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1; // 탐색 실패
    }

    private static int countNumber(int startIndex, int targetNumber) {
        int count = 0;

        while (true) {
            if (startIndex < list.size()) {
                if (list.get(startIndex) == targetNumber) {
                    count++;
                } else {
                    return count;
                }
            } else {
                return count;
            }
            startIndex++;
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
