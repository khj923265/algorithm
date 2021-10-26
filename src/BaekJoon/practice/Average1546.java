package BaekJoon.practice;

public class Average1546 {

    public static void main(String[] args) throws Exception {
        /**
         *  평균 문제
         *  N 개의 과목점수를 받고 가장 잘본 점수를 구해서
         *  모든 점수에 점수/max*100 해서 평균을 구하기.
         */

        int N = read();
        double[] list = new double[N + 1];
        double sum = 0;
        double max = 0;

        for (int i = 0; i < N; i++) {
            list[i] = read();
            if (max < list[i]) max = list[i];
            sum += list[i];
        }

        System.out.println(sum/max/N*100);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
