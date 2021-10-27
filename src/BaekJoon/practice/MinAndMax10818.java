package BaekJoon.practice;

public class MinAndMax10818 {

    public static void main(String[] args) throws Exception {
        /**
         *  최소값,최대값 문제
         *  입력값의 최소값과 최대값을 출력하기.
         *  10 5 20 30 40 -> 5 40 출력
         */
        int testCase = read();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (testCase --> 0) {
            int score = read();

            if (score > max) max = score;
            if (score < min) min = score;
        }

        System.out.println(min + " " + max);


    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
