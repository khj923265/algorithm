package BaekJoon.practice;

import java.util.ArrayList;
import java.util.List;

public class BlackJack2798 {

    public static void main(String[] args) throws Exception {
        /**
         *  블랙잭 문제
         *  N 장의 카드중 3장을 골라 M 에 가장 가까운 합을 구하기.
         */

        int N = read();
        int M = read();
        List<Integer> cardList = new ArrayList<>();
        int nearNumber = 0;
        int sum;

        for (int i = 0; i < N; i++) {
            cardList.add(read());
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j; k < N - 1; k++) {
                    sum = cardList.get(i) + cardList.get(j) + cardList.get(k + 1);
                    if (sum <= M) {
                        nearNumber = Math.max(nearNumber, sum);
                    }
                }
            }
        }

        System.out.println(nearNumber);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
