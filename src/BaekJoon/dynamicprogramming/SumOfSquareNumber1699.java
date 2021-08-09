package BaekJoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfSquareNumber1699 {

    public static void main(String[] args) throws IOException {
        // 1 = 1^
        // 2 = 1^ + 1^
        // 3 = 1^ + 1^ + 1^
        // 4 = 2^
        // 5 = 2^ + 1^
        // 6 = 2^ + 1^ + 1^
        // 7 = 2^ + 1^ + 1^ + 1^
        // 8 = 2^ + 2^
        // 9 = 3^

        //TODO 설명 보충 더 해놔야함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}