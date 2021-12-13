package BaekJoon.class2;

public class PrimeNumber1978 {

    public static void main(String[] args) throws Exception {
        /**
         * 소수 찾기 문제
         */

        // 에라토스테네스의 체 방식 (값이 크고 반복이 많을 경우 유리할 것 같음)
        // 1과 자기자신을 제외 후 2, 3, 5, 7 의 배수에 해당하는 값은 삭제

        // 1과 자기 자신을 제외 후 찾고자 하는 값의 제곱근 까지 % 가 0인지 확인하기

        int N = read();
        int count = 0;

        while (N --> 0) {
            int number = read();
            if (number == 1) continue;
            if (isPrimeNumber(number)) count++;
        }
        System.out.println(count);

    }

    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number %i == 0) return false;
        }
        return true;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) {
            n = System.in.read() & 15;
        }
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return isNegative ? ~n + 1 : n;
    }
}
