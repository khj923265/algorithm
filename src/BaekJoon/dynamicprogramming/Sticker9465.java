package BaekJoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder st = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        /**
         * 스티커 문제
         * 2n개의 스티커 중에서 점수의 합이 최대가 되면서 서로 변을 공유 하지 않는 스티커 집합을 구해야 한다.
         */

        // 50 10 100 20 40
        // 30 50 70 10 60

        // dp[n][0] = Math.max( dp[n - 1][1], Math.max( dp[n-2][0], dp[n-2][1] ) ) + arr[n][0]
        // dp[n][1] = Math.max( dp[n - 1][0], Math.max( dp[n-2][0], dp[n-2][1] ) ) + arr[n][0]
        // dp[n][2] = Math.max( dp[n][0], dp[n][1] )  큰값을 계속 저장

        // 하지만 Math.max( dp[n-2][0], dp[n-2][1] 이부분에서
        // 큰값을 계속 저장할 필요없이 dp[n-2][반대값] 만 비교 하면됨
        // ex) 50 10 100 20 40
        //     30 50 70 10 60
        //     100 을 선택할 경우 최대값을 구하는 경우는 50 + 100, 30부분의최대값 + 100
        // 50 10 에서 50 > 30 + 10
        // 30 50


        while (testCase --> 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] stickerList = new int[N + 1][2];
            int[][] dp = new int[N + 1][2];

            StringTokenizer firstLine = new StringTokenizer(br.readLine());
            StringTokenizer secondLine = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                stickerList[i][0] = Integer.parseInt(firstLine.nextToken());
                stickerList[i][1] = Integer.parseInt(secondLine.nextToken());
            }
            dp[0][0] = stickerList[0][0];
            dp[0][1] = stickerList[0][1];

            dp[1][0] = dp[0][1] + stickerList[1][0];
            dp[1][1] = dp[0][0] + stickerList[1][1];


            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + stickerList[i][0];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + stickerList[i][1];

            }
            st.append(Math.max(dp[N][0], dp[N][1])).append("\n");
        }
        System.out.println(st);
    }
}
