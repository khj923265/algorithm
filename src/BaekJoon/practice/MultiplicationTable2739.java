package BaekJoon.practice;

public class MultiplicationTable2739 {

    public static void main(String[] args) throws Exception {
        /**
         *  구구단 문제
         *  N 입력값의 구구단을 출력하기.
         */

        StringBuilder sb = new StringBuilder();
        int N = read();

        for (int i = 1; i < 10; i++) {
            sb.append(N).append(" * ").append(i).append(" = ").append(N*i).append("\n");
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
