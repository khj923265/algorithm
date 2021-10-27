package BaekJoon.practice;

public class APlusB10952 {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int A;
        int B;

        while (true) {
            A = read();
            B = read();

            if (A == 0 && B == 0) break;

            sb.append(A + B).append("\n");
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
