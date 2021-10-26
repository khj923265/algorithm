package BaekJoon.practice;

public class Comparison1330 {

    public static void main(String[] args) throws Exception {
        /**
         * 비교 문제
         * A, B 입력 받고 비교등호 출력하기.
         */

        int A = read();
        int B = read();

        if (A == B) {
            System.out.println("==");
        } else if (A < B){
            System.out.println("<");
        } else {
            System.out.println(">");
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
