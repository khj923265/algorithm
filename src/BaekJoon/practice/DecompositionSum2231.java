package BaekJoon.practice;

public class DecompositionSum2231 {

    public static void main(String[] args) throws Exception {
        /**
         *  분해합 문제
         *  M = 245 의 분해합은 256 = 245 + 2 + 4 + 5 (각 자리수의 합)
         *  여기서 256은 분해합이라고 하고 M 은 256의 생성자라고도 한다.
         *  분해합이 주어졌을 때 나올 수 있는 가장 작은 생성자를 구하기.
         *  생성자는 여러개 있을 수도 있고 1개도 없을 수도 있다.
         */

        int N = read();
        int targetValue = N/10;
        if (N > 1000) {
            targetValue = N -100;
        }
        int result = 0;

        while (targetValue < N) {
            int targetCopyValue = targetValue;
            int sum = targetValue;

            if (targetValue > 10) {
                while (targetCopyValue > 0) {
                    sum += targetCopyValue%10;
                    targetCopyValue /= 10;
                }
            } else {
                sum = targetValue * 2;
            }

            if (sum == N) {
                result = targetValue;
                break;
            }
            ++targetValue;
        }

        System.out.println(result);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
