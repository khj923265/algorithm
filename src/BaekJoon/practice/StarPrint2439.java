package BaekJoon.practice;

public class StarPrint2439 {

    public static void main(String[] args) throws Exception {
        /**
         *  별 찍기 2 문제
         *  N 의 개수만큼 별 출력하지만 출력 모양이 다름.
         */

        // ex)    *
        //       **
        //      ***

        int N = read();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = N; j >= 1; j--) {
                if (j > i) {
                    sb.append(" ");
                } else {
                    sb.append("*");
                }
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