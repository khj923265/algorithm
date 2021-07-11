package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Card11052 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(br.readLine());
//        int[] P = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N + 1];
        int[] P = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            P[i] = sc.nextInt();
        }

        for(int i = 1; i < N + 1; i++) {
            for (int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i],  dp[i - j] + P[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
