package BaekJoon.practice;

public class PrintN2741 {

    public static void main(String[] args) throws Exception {
        /**
         *  N 찍기 문제
         *  N 만큼 순서대로 숫자를 출력하기.
         */
        StringBuilder sb = new StringBuilder();
        int N = read();

        // 1 ~ 5
        for (int i = 1; i <= N; i++) {
            sb.append(i).append("\n");
        }

        // 5 ~ 1
        for (int i = N; i > 0; i--) {
            sb.append(i).append("\n");
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
