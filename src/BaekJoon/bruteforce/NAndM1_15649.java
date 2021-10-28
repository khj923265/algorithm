package BaekJoon.bruteforce;

public class NAndM1_15649 {

    public static void main(String[] args) throws Exception {
        /**
         *  N 과 M (1) 문제
         *  1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 출력하기.
         */

        // ex) 4 2
        //     1 2, 1 3, 1 4, 2 1, 2 3 ...

        //TODO 재귀로 해결
        StringBuilder sb = new StringBuilder();
        int N = read();
        int M = read();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {

                }
            }
        }

        System.out.println(sb);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
