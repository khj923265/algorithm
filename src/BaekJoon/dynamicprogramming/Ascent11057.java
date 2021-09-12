package BaekJoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ascent11057 {

    static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /**
         * 오르막 수 문제
         * 수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.
         */

        // dp[1] = 10
        // 0 1 2 3 4 5 6 7 8 9
        // 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1

        // dp[2] = 55
        // 00 01 02 ~ 11 12 13 ~
        // 10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1

        // dp[3] = 220
        // 55 + 45 + 36 + 28 + 21 + 15 + 10 + 6 + 3 + 1


        long[][] dp = new long[N + 1][11];

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= MOD;
                }
            }
        }
        System.out.println(dp[N][0] % MOD);
        for (int i = 0; i < 10; i++) {
            System.out.println(dp[N][i] % MOD);
        }
    }
}
