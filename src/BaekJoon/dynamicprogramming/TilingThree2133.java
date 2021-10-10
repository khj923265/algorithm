package BaekJoon.dynamicprogramming;

public class TilingThree2133 {

    public static void main(String[] args) throws Exception {
        /**
         * 타일 채우기 3 * N  문제
         */
        // N 이 홀수인 경우는 무조건 0개
        // N 이 4부터 N이 증가 할 때마다 새로운 유형이 2개씩 생겨남

        // N = 2
        // 3
        // N = 4
        // 11 = 9 + 2
        // N = 6
        // 41 -> 33 + 6 + 2


        int N = read();
        int[] dp = new int[N + 1];

        if (N % 2 != 0) {
            System.out.println(0);
        } else {
            dp[0] = 1;
            dp[1] = 0;
            dp[2] = 3;

            for (int i = 4; i <= N; i += 2) {
                dp[i] = dp[i -2] * 3;
                for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] += dp[j] * 2;
                }
            }
            System.out.println(dp[N]);
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
