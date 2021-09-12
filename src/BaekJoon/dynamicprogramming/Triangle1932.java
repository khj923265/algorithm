package BaekJoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Triangle1932 {

    static int[][] arr;
    static Integer[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        /**
         * 정수 삼각형 문제
         * 맨위층부터 맨아래층으로 내려오며 선택된 수의 합이 최대가 되는 값을 구하시오.
         */

        // 7
        // 3 8
        // 8 1 0
        // 2 7 4 4
        // 4 5 2 6 5

        // 위에서 부터 dp를 저장하는게 아닌 밑에서 부터 시작하는게 좋음
        // 맨 아래에서 부터 arr의 현재값과 오른쪽값중 큰값을 윗칸값과 합쳐서 dp로 저장

        // 점화식 : dp[i - 1][j] = Math.max(dp[i][j], dp[i][j + 1]) + arr[i - 1][j];

        arr = new int[N][N];
        dp = new Integer[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처음 맨아래 dp에 arr 값을 넣어둠
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                dp[i - 1][j] = Math.max(dp[i][j], dp[i][j + 1]) + arr[i - 1][j];
            }
        }

        System.out.println(dp[0][0]);

    }

}
