package BaekJoon.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class Divisor2501 {

    public static void main(String[] args) throws Exception {
        /**
         *  약수 구하기 문제
         *  N, K 가 주어졌을 때 N 의 약수중 K번째 를 출력하기.
         *  만약 N의 약수의 갯수보다 K가 클경우 0을 출력
         */

        // ex) N = 6, K = 3
        // 6 의 약수 1, 2, 3, 6  3번째는 3

        int N = read();
        int K = read();
        List<Integer> divisorList = new ArrayList<>();

        for (int i = 1; i <= N/2; i++) {
            if (N%i == 0) divisorList.add(i);
        }
        divisorList.add(N);

        if (divisorList.size() < K) {
            System.out.println(0);
        } else {
            System.out.println(divisorList.get(K - 1));
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
