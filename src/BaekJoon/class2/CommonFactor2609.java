package BaekJoon.class2;

public class CommonFactor2609 {

    public static void main(String[] args) throws Exception {
        /**
         * 최대공약수와 최소공배수 문제
         */

        // 유클리드 호제법 (Euclidean algorithm)
        // 두 수 a, b ∈ ℤ 이고, r = a mod b 이라고 한다. (r 은 a에 b를 나눈 나머지를 의미)
        // 이 때 r은 (0 ≤ r < b) 이고, a ≥ b 이다.
        // GCD(a, b) == GCD(b, r)

        int firstNumber = read();
        int secondNumber = read();

        int greatestCommonFactor = GCD(firstNumber, secondNumber);
        int leastCommonMultiple = firstNumber * secondNumber / greatestCommonFactor;
        System.out.println(greatestCommonFactor + "\n" + leastCommonMultiple);
    }

    private static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }


    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
