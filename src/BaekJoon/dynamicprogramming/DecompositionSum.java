package BaekJoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DecompositionSum {

    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         *  0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
         *  덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.
         */

        //TODO 설명 추가 해야함 K = 1 경우 무조건 1,K = 2 경우 N + 1
        // K = 3 경우 부터 점화식 dp[K][N] = dp[K - 1][N] + N아래 전부 합산
        // 맨 앞 숫자를 이미 선택 했다 가정하고 접근하면 점화식을 이해하기 쉬움
        // dp[K - 1][N] + N아래 전부 합산 <<-- 이게 결국 dp[i - 1][j] + dp[i][j - 1] 설명써놔야함!

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[K + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= K; i++) {
            dp[i][1] = i;
        }

        // 200 까지 다 넣어놓고 하는거랑 N, K 까지 돌리는거랑 속도차이가 별로 없음
        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        System.out.println(dp[K][N] % MOD);
    }
}
