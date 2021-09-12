package BaekJoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wine2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wineScoreList = new int[n + 1];
        int[] dp = new int[n + 1];

        /**
         * 포도주 시식 문제
         * ex) 6, 10, 13, 9, 8, 1 의 리스트에서 연속으로 3개이상 포함하지 않게 최대합을 구하기
         */

        // 9로 예시를 들면 경우의 수는
        // 1. 9랑 13을 더하고 10은 연속되니까 10의 전 dp를 더한다
        // dp[i - 3] + arr[i - 1] + arr[i]
        // 2. 9랑 13을 버리고 13의 전 dp를 더한다
        // dp[i - 2] + arr[i]

        // dp[i] = Math.max( dp[i - 1] + arr[i], dp[i - 3] + arr[i - 1] + arr[i] );
        // 여기 까진 나왔는데 자꾸 틀림 그래서 정답 확인

        // 내가 놓친 부분 (마지막 선택값을 선택하지 않는 경우를 생각했어야함)
        // 10 40 2 1 4 20 -> 10 40 4 20 을 선택한 경우가 가장 큰값
        // 이것 때문에 dp[i] = Math.max ( dp[i - 1], dp[i] ) 가 필요함
        // 실질적인 로직은 dp[i - 3] 에서 i값이 1이 될때까지 가장 높은 dp 값을 가져와야함
        // 그걸 줄여서 위의 로직이 만들어짐

        for (int i = 1; i <= n; i++) {
            wineScoreList[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wineScoreList[1];
        if (n >= 2) {
            dp[2] = wineScoreList[1] + wineScoreList[2];
        }

        for (int i = 3; i <= n; i++) {
            int caseOne = dp[i - 3] + wineScoreList[i - 1] + wineScoreList[i];
            int caseTwo = dp[i - 2] + wineScoreList[i];
            dp[i] = Math.max(Math.max(caseOne, caseTwo), dp[i - 1]);
        }

        System.out.println(dp[n]);
    }
}
