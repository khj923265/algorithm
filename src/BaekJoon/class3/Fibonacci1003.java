package BaekJoon.class3;

public class Fibonacci1003 {
    /**
     * 피보나치 함수 문제
     */

    private static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int testCase = read();

        dp[0][0] = 1;	// N=0 일 때의 0 호출 횟수
        dp[0][1] = 0;	// N=0 일 때의 1 호출 횟수
        dp[1][0] = 0;	// N=1 일 때의 0 호출 횟수
        dp[1][1] = 1;	// N=1 일 때의 1 호출 횟수

        for (int i = 0; i < testCase; i++) {
            int n = read();
            fibonacci(n);
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }
        System.out.println(sb);
    }

    public static Integer[] fibonacci(int n) {
        if (dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        return dp[n];
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}