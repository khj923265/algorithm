package BaekJoon.practice;

public class ACMHotel10250 {

    public static void main(String[] args) throws Exception {
        /**
         * ACM 호텔 문제
         */

        // 규칙찾아서 그냥 품
        // 제일 꼭대기 층에 걸릴경우 예외가 있어서 수정함

        StringBuilder sb = new StringBuilder();
        int testCase = read();

        while (testCase --> 0) {
            int H = read();
            int W = read();
            int N = read();
            int a;
            int b;

            if (N%H == 0) {
                a = N/H;
                b = H;
            } else {
                a = N/H + 1;
                b = N - H*(N/H);
            }
            int result = b*100 + a;

            sb.append(result).append("\n");
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
