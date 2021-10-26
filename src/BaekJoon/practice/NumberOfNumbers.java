package BaekJoon.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfNumbers {

    public static void main(String[] args) throws Exception {
        /**
         *  숫자의 개수 문제
         *  A, B, C 를 입력받고 A*B*C 의 값에서 0~9 가 몇개 포함하는지 출력하기.
         */

        int A = read();
        int B = read();
        int C = read();
        int sum = A * B * C;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        while (sum > 0) {
            list.add(sum%10);
            sum /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (i < 9) {
                sb.append(Collections.frequency(list, i)).append("\n");
            } else {
                sb.append(Collections.frequency(list, i));
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
