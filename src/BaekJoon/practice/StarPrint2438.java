package BaekJoon.practice;

public class StarPrint2438 {

    public static void main(String[] args) throws Exception {
        /**
         *  별 찍기 문제
         *  N 의 개수만큼 별 출력하기.
         */

        //  ex) *
        //      **
        //      ***

        int N = read();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
