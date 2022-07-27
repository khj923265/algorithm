package BaekJoon.class3;

public class Fibonacci1003 {
    /**
     * 피보나치 함수 문제
     */

    private static int zeroCount = 0;
    private static int oneCount = 0;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int testCase = read();

        for (int i = 0; i < testCase; i++) {
            int n = read();
            fibonacci(n);
            sb.append(zeroCount).append(" ").append(oneCount).append("\n");
            zeroCount = 0;
            oneCount = 0;
        }
        System.out.println(sb);
    }

    public static void fibonacci(int n) {
        if (n == 0) {
            zeroCount = zeroCount + 1;
        } else if (n == 1) {
            oneCount = oneCount + 1;
        } else {
            fibonacci(n - 1);
            fibonacci(n - 2);
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