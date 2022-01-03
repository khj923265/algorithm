package BaekJoon.practice;

import java.util.Arrays;

public class SortNumber2750 {
    public static void main(String[] args) throws Exception {
        /**
         * 수 정렬하기 문제
         */

        // 수정렬하기 3 도 이걸로 해결가능

        int testCase =  read();
        int[] numbers = new int[testCase];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            numbers[i] = read();
        }

        Arrays.sort(numbers);
        for (int number : numbers) {
            sb.append(number).append("\n");
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
