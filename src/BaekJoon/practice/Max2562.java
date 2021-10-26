package BaekJoon.practice;

public class Max2562 {

    public static void main(String[] args) throws Exception {
        /**
         *  최댓값 문제
         *  9개의 서로 다른 자연수가 주어질 때
         *  이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
         */

        int max = 0;
        int index = 0;
        for (int i = 0; i < 9; i++) {
            int a = read();
            if (max < a) {
                max = a;
                index = i + 1;
            }
        }
        System.out.println(max + "\n" + index);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
