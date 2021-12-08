package BaekJoon.class2;

public class BinomialCoefficient11050 {

    public static void main(String[] args) throws Exception {
        /**
         * 이항계수 문제
         */

        // r!(n - r)! 분의 n!
        int N = read();
        int K = read();

        System.out.println(factorial(N) / (factorial(N - K) * factorial(K)));
    }

    private static int factorial(int N) {
        if(N == 0) {
            return 1;
        }
        return N * factorial(N - 1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
