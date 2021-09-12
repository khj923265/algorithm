package BaekJoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zoo1309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /**
         * 동물원 문제
         * 2*N 배열에 사자를 배치하는 경우의 수 ( 사자는 가로,세로 붙어있을 수 없음 )
         */
        // 3개
        // N = 1 (1, 0), (0, 1), (0, 0)
        // dp[1][0] = (0, 0)
        // dp[1][1] = (1, 0)
        // dp[1][2] = (0, 1)

        // 7개
        // N = 2 (1, 0), (1, 0), (0, 1), (0, 1), (0, 0), (0, 0), (0, 0)
        //       (0, 0), (0, 1), (0, 0), (1, 0), (1, 0), (0, 1), (0, 0)
        // dp[2][0] = dp[1][3]
        // dp[2][1] = dp[1][0] + dp[1][2]
        // dp[2][2] = dp[1][0] + dp[1][1]
        // sum[2] = dp[2][0] + dp[2][1] + dp[2][2]

        // 17개
        // N = 3 (1, 0), (1, 0), (1, 0), (1, 0), (1, 0), (0, 1), (0, 1), (0, 1), (0, 1), (0, 1), (0, 0), (0, 0), (0, 0), (0, 0), (0, 0), (0, 0), (0, 0)
        //       (0, 0), (0, 0), (0, 0), (0, 1), (0, 1), (0, 0), (0, 0), (0, 0), (1, 0), (1, 0), (1, 0), (1, 0), (0, 1), (0, 1), (0, 0), (0, 0), (0, 0)
        //       (0, 0), (1, 0), (0, 1), (0, 0), (1, 0), (0, 0), (1, 0), (0, 1), (0, 0), (0, 1), (0, 0), (0, 1), (0, 0), (1, 0), (1, 0), (0, 1), (0, 0)

        // 더 빠른 방법
        // dp[i] = (2 * dp[i - 1]) + dp[i - 2]

        long[][] dp = new long[N + 1][3];
        long[] sum = new long[N + 1];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        sum[1] = 3;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = sum[i - 1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
            sum[i] = (dp[i][0] + dp[i][1] + dp[i][2]) % 9901;
        }

        System.out.println(sum[N]);

    }

}
