package BaekJoon.class2;

public class PrimeNumber1978 {

    public static void main(String[] args) throws Exception {
        /**
         * 소수 찾기 문제
         */

        // 1과 자기자신을 제외 후 2, 3, 5, 7 의 배수에 해당하는 값은 삭제
        // % 가 아니라 배수를 탐색해서 지워야 함

        int N = read();
        int count = 0;

        while (N --> 0) {
            int number = read();
            if (number == 1) continue;
            if (number == 2 || number == 3 || number == 5 || number == 7) {
                count++;
            } else if (number%2 != 0 && number%3 != 0 && number%5 != 0 && number%7 != 0){
                count++;
            }
        }
        System.out.println(count);

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
